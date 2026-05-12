// ── PROTOTYPE INTERFACE ────────────────────────────────────────
public interface Prototype<T> {
    T deepClone();
}

// ── COMPLEX OBJECT TO CLONE ────────────────────────────────────
public class StreamProfile implements Prototype<StreamProfile> {

    private String name;
    private String codec;
    private String drmProvider;
    private int    maxBitrate;
    private List<String> cdnRegions; // mutable — needs deep copy

    // Expensive constructor — simulates hitting external services
    public StreamProfile(String name) {
        this.name       = name;
        this.codec      = "H.264";
        this.drmProvider = "Widevine";
        this.maxBitrate  = 4500;
        this.cdnRegions  = new ArrayList<>(List.of("us-east", "eu-west"));
        System.out.println("[StreamProfile] Built '" + name + "' (expensive init).");
    }

    // Private copy constructor — used by deepClone() only
    private StreamProfile(StreamProfile source) {
        this.name        = source.name;
        this.codec       = source.codec;
        this.drmProvider = source.drmProvider;
        this.maxBitrate  = source.maxBitrate;
        this.cdnRegions  = new ArrayList<>(source.cdnRegions); // deep copy the list
    }

    @Override
    public StreamProfile deepClone() {
        System.out.println("[StreamProfile] Cloning '" + name + "' (cheap).");
        return new StreamProfile(this); // uses private copy constructor
    }

    // Fluent setters — lets you tweak after cloning
    public StreamProfile withName(String name)             { this.name = name; return this; }
    public StreamProfile withCodec(String codec)           { this.codec = codec; return this; }
    public StreamProfile withMaxBitrate(int mbr)           { this.maxBitrate = mbr; return this; }
    public StreamProfile addRegion(String region)          { this.cdnRegions.add(region); return this; }

    @Override
    public String toString() {
        return String.format("StreamProfile{ name='%s', codec='%s', drm='%s', bitrate=%d, regions=%s }",
                name, codec, drmProvider, maxBitrate, cdnRegions);
    }
}

// ── Demo ───────────────────────────────────────────────────────
public class PrototypeDemo {
    public static void main(String[] args) {

        // Build once — the expensive part
        StreamProfile base = new StreamProfile("Global-Default");

        // Clone and customize — the cheap part
        StreamProfile asiaProfile = base.deepClone()
                .withName("Asia-Pacific")
                .withMaxBitrate(3000)
                .addRegion("ap-southeast");

        StreamProfile mobileProfile = base.deepClone()
                .withName("Mobile-Low-Bandwidth")
                .withCodec("H.265")
                .withMaxBitrate(1200);

        System.out.println("\nBase:    " + base);
        System.out.println("Asia:    " + asiaProfile);
        System.out.println("Mobile:  " + mobileProfile);

        // Prove deep copy — Asia's region list doesn't affect base
        System.out.println("\nBase regions untouched: " + base);
    }
}