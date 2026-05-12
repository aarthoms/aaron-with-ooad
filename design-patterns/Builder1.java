// ── PRODUCT — immutable once built ────────────────────────────
public class ContentPackage {

    // Required
    private final String contentId;
    private final String title;
    private final String codec;

    // Optional
    private final String              thumbnailUrl;
    private final List<String>        subtitleLanguages;
    private final List<String>        bonusFeatures;
    private final Map<String, String> drmConfig;      // region → DRM provider
    private final boolean             is4KEnabled;
    private final boolean             isDownloadable;
    private final String              releaseWindow;  // "GLOBAL", "US_ONLY", etc.

    // Private — only Builder can call this
    private ContentPackage(Builder b) {
        this.contentId         = b.contentId;
        this.title             = b.title;
        this.codec             = b.codec;
        this.thumbnailUrl      = b.thumbnailUrl;
        this.subtitleLanguages = Collections.unmodifiableList(b.subtitleLanguages);
        this.bonusFeatures     = Collections.unmodifiableList(b.bonusFeatures);
        this.drmConfig         = Collections.unmodifiableMap(b.drmConfig);
        this.is4KEnabled       = b.is4KEnabled;
        this.isDownloadable    = b.isDownloadable;
        this.releaseWindow     = b.releaseWindow;
    }

    @Override
    public String toString() {
        return String.format(
            "ContentPackage{\n  id='%s', title='%s', codec='%s',\n" +
            "  4K=%b, downloadable=%b, window='%s',\n" +
            "  subtitles=%s,\n  bonus=%s,\n  drm=%s,\n  thumb='%s'\n}",
            contentId, title, codec, is4KEnabled, isDownloadable,
            releaseWindow, subtitleLanguages, bonusFeatures, drmConfig, thumbnailUrl
        );
    }

    // ── BUILDER ────────────────────────────────────────────────
    public static class Builder {

        // Required fields — set via constructor
        private final String contentId;
        private final String title;
        private final String codec;

        // Optional fields — sensible defaults
        private String              thumbnailUrl      = "";
        private List<String>        subtitleLanguages = new ArrayList<>();
        private List<String>        bonusFeatures     = new ArrayList<>();
        private Map<String, String> drmConfig         = new HashMap<>();
        private boolean             is4KEnabled       = false;
        private boolean             isDownloadable    = false;
        private String              releaseWindow     = "GLOBAL";

        // Required fields enforced at construction — can't build without them
        public Builder(String contentId, String title, String codec) {
            this.contentId = contentId;
            this.title     = title;
            this.codec     = codec;
        }

        public Builder thumbnail(String url)               { this.thumbnailUrl = url;               return this; }
        public Builder subtitle(String language)           { this.subtitleLanguages.add(language);   return this; }
        public Builder bonusFeature(String feature)        { this.bonusFeatures.add(feature);        return this; }
        public Builder drm(String region, String provider) { this.drmConfig.put(region, provider);   return this; }
        public Builder enable4K()                          { this.is4KEnabled = true;                return this; }
        public Builder allowDownload()                     { this.isDownloadable = true;             return this; }
        public Builder releaseWindow(String window)        { this.releaseWindow = window;            return this; }

        // Validation before build — Builder is the last line of defence
        public ContentPackage build() {
            if (contentId == null || contentId.isBlank())
                throw new IllegalStateException("contentId is required.");
            if (title == null || title.isBlank())
                throw new IllegalStateException("title is required.");
            if (is4KEnabled && codec.equals("H.264"))
                throw new IllegalStateException("4K requires H.265 or AV1 codec.");

            System.out.println("[Builder] ContentPackage validated and built: " + title);
            return new ContentPackage(this);
        }
    }
}

// ── Demo ───────────────────────────────────────────────────────
public class BuilderDemo {
    public static void main(String[] args) {

        // Full-featured premium package
        ContentPackage inception = new ContentPackage.Builder(
                "inception_2010", "Inception", "H.265")
            .enable4K()
            .allowDownload()
            .thumbnail("https://cdn.stream.io/thumbs/inception.jpg")
            .subtitle("English")
            .subtitle("Spanish")
            .subtitle("French")
            .bonusFeature("Director's Commentary")
            .bonusFeature("Behind the Scenes")
            .drm("US",  "Widevine")
            .drm("EU",  "PlayReady")
            .drm("APAC","FairPlay")
            .releaseWindow("GLOBAL")
            .build();

        System.out.println(inception);

        System.out.println();

        // Minimal free-tier package — only required fields
        ContentPackage basic = new ContentPackage.Builder(
                "short_film_42", "Short Film #42", "H.264")
            .build();

        System.out.println(basic);
    }
}