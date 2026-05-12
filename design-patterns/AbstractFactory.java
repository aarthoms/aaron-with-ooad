// ── PRODUCT INTERFACES — one per product type ─────────────────

public interface Player {
    void play(String contentId);
}

public interface RecommendationEngine {
    List<String> recommend(String userId);
}

public interface AdInjector {
    void inject(String contentId);
}

// ── FREE TIER FAMILY ───────────────────────────────────────────

public class FreePlayer implements Player {
    @Override
    public void play(String contentId) {
        System.out.println("[FreePlayer] Playing (480p max): " + contentId);
    }
}

public class BasicRecommendationEngine implements RecommendationEngine {
    @Override
    public List<String> recommend(String userId) {
        System.out.println("[BasicRec] Genre-based recs for: " + userId);
        return List.of("Popular Movie A", "Trending Show B");
    }
}

public class StandardAdInjector implements AdInjector {
    @Override
    public void inject(String contentId) {
        System.out.println("[Ads] Pre-roll + mid-roll ads injected for: " + contentId);
    }
}

// ── PREMIUM TIER FAMILY ────────────────────────────────────────

public class PremiumPlayer implements Player {
    @Override
    public void play(String contentId) {
        System.out.println("[PremiumPlayer] Playing (4K HDR, Dolby Atmos): " + contentId);
    }
}

public class MLRecommendationEngine implements RecommendationEngine {
    @Override
    public List<String> recommend(String userId) {
        System.out.println("[MLRec] Personalised ML recs for: " + userId);
        return List.of("Hidden Gem X", "Curated Pick Y", "Because you watched Z");
    }
}

public class NoAdInjector implements AdInjector {
    @Override
    public void inject(String contentId) {
        System.out.println("[Ads] No ads — Premium subscriber.");
    }
}

// ── ABSTRACT FACTORY ───────────────────────────────────────────
// Defines the contract for creating a full tier's product family.
public interface TierFactory {
    Player                createPlayer();
    RecommendationEngine  createRecommendationEngine();
    AdInjector            createAdInjector();
}

// ── CONCRETE FACTORIES ─────────────────────────────────────────

public class FreeTierFactory implements TierFactory {
    @Override public Player               createPlayer()              { return new FreePlayer(); }
    @Override public RecommendationEngine createRecommendationEngine(){ return new BasicRecommendationEngine(); }
    @Override public AdInjector           createAdInjector()          { return new StandardAdInjector(); }
}

public class PremiumTierFactory implements TierFactory {
    @Override public Player               createPlayer()              { return new PremiumPlayer(); }
    @Override public RecommendationEngine createRecommendationEngine(){ return new MLRecommendationEngine(); }
    @Override public AdInjector           createAdInjector()          { return new NoAdInjector(); }
}

// ── CLIENT — uses the factory, never sees concrete classes ─────
public class StreamingApp {

    private final Player               player;
    private final RecommendationEngine recommender;
    private final AdInjector           adInjector;

    // Entire tier behaviour injected through one factory
    public StreamingApp(TierFactory factory) {
        this.player      = factory.createPlayer();
        this.recommender = factory.createRecommendationEngine();
        this.adInjector  = factory.createAdInjector();
    }

    public void openContent(String userId, String contentId) {
        adInjector.inject(contentId);
        player.play(contentId);
        System.out.println("Up next: " + recommender.recommend(userId));
    }
}

// ── Demo ───────────────────────────────────────────────────────
public class AbstractFactoryDemo {
    public static void main(String[] args) {

        System.out.println("══ FREE USER ══");
        StreamingApp freeApp = new StreamingApp(new FreeTierFactory());
        freeApp.openContent("user_free_01", "inception_2010");

        System.out.println("\n══ PREMIUM USER ══");
        StreamingApp premiumApp = new StreamingApp(new PremiumTierFactory());
        premiumApp.openContent("user_prem_01", "inception_2010");
    }
}