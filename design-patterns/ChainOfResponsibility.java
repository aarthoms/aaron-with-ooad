import java.util.*; 
// Every stream request must pass through AUTH, RateLimiting, ContentRegion, Parental Controls. Any handlers can reject it early.
// Base Handler: Each handler holds a reference to the next one in the chain. If it can't handle., it will pass along. 

abstract class StreamRequestHandler{ 
    protected StreamRequestHandler next; 
    // fluent chain builder
    public StreamRequestHandler setNext(StreamRequestHandler next){
        this.next = next; 
        return next; 
    }
    public abstract boolean handle (StreamRequest request); 
    protected boolean passToNext(StreamRequest request){
        if(next == null){
            System.out.println("[Chain] All Checks Passed. Stream Approved"); 
            return true; 
        }
        return next.handle(request); 
    }
}

// Request Object 
class StreamRequest{
    public final String userID; 
    public final String contentID; 
    public final String region; 
    public final int userAge; 
    public final int requestsThisMin; 
    public StreamRequest(String userID, String contentID, String region, int age, int requestspermin){
        this.userID = userID; 
        this.contentID = contentID; 
        this.region = region; 
        this.userAge = age; 
        this.requestsThisMin = requestspermin; 
    }
}
// ── HANDLER 1: Authentication ──────────────────────────────────
class AuthHandler extends StreamRequestHandler {
    @Override
    public boolean handle(StreamRequest request) {
        if (request.userID == null || request.userID.isBlank()) {
            System.out.println("[Auth] REJECTED — no user token.");
            return false;
        }
        System.out.println("[Auth] Passed.");
        return passToNext(request);
    }
}

// ── HANDLER 2: Rate Limiting ───────────────────────────────────
class RateLimitHandler extends StreamRequestHandler {
    private static final int MAX_REQUESTS_PER_MINUTE = 10;

    @Override
    public boolean handle(StreamRequest request) {
        if (request.requestsThisMin > MAX_REQUESTS_PER_MINUTE) {
            System.out.println("[RateLimit] REJECTED — too many requests.");
            return false;
        }
        System.out.println("[RateLimit] Passed.");
        return passToNext(request);
    }
}

// ── HANDLER 3: Region Check ────────────────────────────────────
class RegionHandler extends StreamRequestHandler {
    private static final Set<String> BLOCKED = Set.of("CN", "KP", "IR");

    @Override
    public boolean handle(StreamRequest request) {
        if (BLOCKED.contains(request.region)) {
            System.out.println("[Region] REJECTED — content unavailable in: "
                    + request.region);
            return false;
        }
        System.out.println("[Region] Passed.");
        return passToNext(request);
    }
}

// ── HANDLER 4: Parental Controls ──────────────────────────────
class ParentalControlHandler extends StreamRequestHandler {
    private static final int ADULT_CONTENT_AGE = 18;

    @Override
    public boolean handle(StreamRequest request) {
        // Assume adult content for this demo
        boolean isAdultContent = request.contentID.startsWith("R18_");
        if (isAdultContent && request.userAge < ADULT_CONTENT_AGE) {
            System.out.println("[Parental] REJECTED — user under 18.");
            return false;
        }
        System.out.println("[Parental] Passed.");
        return passToNext(request);
    }
}

// Wiring this chain: 
public class ChainOfResponsibility{
    public static void main(String[] args){
        AuthHandler auth = new AuthHandler(); 
        auth.setNext(new RateLimitHandler())
            .setNext(new RegionHandler())
            .setNext(new ParentalControlHandler());
        System.out.println("── Request 1: valid adult user ──");
        auth.handle(new StreamRequest("user_01", "R18_movie", "US", 25, 3));

        System.out.println("── Request 2: underage user ──");
        auth.handle(new StreamRequest("user_02", "R18_movie", "US", 15, 3));

        System.out.println("── Request 3: blocked region ──");
        auth.handle(new StreamRequest("user_03", "movie_01",  "KP", 30, 3));

        System.out.println("── Request 4: rate limited ──");
        auth.handle(new StreamRequest("user_04", "movie_01",  "US", 30, 99));
    }
}