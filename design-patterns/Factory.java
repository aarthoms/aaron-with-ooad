// Your platform supports multiple stram types -- Audio, video, podcast. Each needs different initialization. The rest of the system just wants a stream without caring which type it is.
import java.util.*; 

// Product interface
interface Stream{
    void start(); 
    void stop(); 
    String getInfo(); 
}

class VideoStream implements Stream{
    private final String resolution; 
    private final String contentID; 

    public VideoStream(String resolution, String contentID){
        this.resolution = resolution; 
        this.contentID  = contentID: 
    }

  @Override public void start()        { System.out.println("[VideoStream] ▶ " + contentID + " @ " + resolution); }
    @Override public void stop()         { System.out.println("[VideoStream] ■ " + contentID); }
    @Override public String getInfo()    { return "Video | " + contentID + " | " + resolution; }

}

class AudioStream implements Stream {
    private final String bitrate;
    private final String contentId;

    public AudioStream(String contentId, String bitrate) {
        this.contentID = contentId;
        this.bitrate   = bitrate;
    }

    @Override public void start()        { System.out.println("[AudioStream] ▶ " + contentID + " @ " + bitrate + "kbps"); }
    @Override public void stop()         { System.out.println("[AudioStream] ■ " + contentID); }
    @Override public String getInfo()    { return "Audio | " + contentID + " | " + bitrate + "kbps"; }
}

class PodcastStream implements Stream {
    private final String host;
    private final String episode;

    public PodcastStream(String episode, String host) {
        this.episode = episode;
        this.host    = host;
    }

    @Override public void start()        { System.out.println("[Podcast] ▶ " + episode + " by " + host); }
    @Override public void stop()         { System.out.println("[Podcast] ■ " + episode); }
    @Override public String getInfo()    { return "Podcast | " + episode + " | host: " + host; }
}

class StreamFactory{
    public enum StreamType { VIDEO, AUDIO, PODCAST}
    public static Stream create(StreamType type, String contentID, String param){
        return switch(type){
            case VIDEO -> new VideoStream(contentID, param); 
            case AUDIO -> new AudioStream(contentID, param); 
            case PODCAST -> new PodcastStream(contentID, param); 
        }; 
    }
}
// ── Demo ───────────────────────────────────────────────────────
public class Factory {
    public static void main(String[] args) {

        List<Stream> queue = List.of(
            StreamFactory.create(StreamFactory.StreamType.VIDEO,   "inception_2010",  "4K"),
            StreamFactory.create(StreamFactory.StreamType.AUDIO,   "dark_side_moon",  "320"),
            StreamFactory.create(StreamFactory.StreamType.PODCAST, "lex_ep_400",      "Lex Fridman")
        );

        queue.forEach(s -> {
            s.start();
            System.out.println("  Info: " + s.getInfo());
            s.stop();
            System.out.println();
        });
    }