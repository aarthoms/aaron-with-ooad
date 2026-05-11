// Your app uses a MediaPlayer interface, but you've licensed a third-party LegacyAudioSDK with a completely different API.

// What your app expects: 
interface MediaPlayer{
    void play(String filename); 
    void pause(); 
    void stop(); 
}

// What the third party sdk gives you: 
class LegacyAudioSDK{
    public void startTrack(String path){
        System.out.println("[LegacySDK] Starting track: "+ path); 
    }
    public void haltPlayback(){
        System.out.println("[LegacySDK] Halting Playback"); 
    }
    public void terminateSession(){
        System.out.println("[LegacySDK] Terminating Session"); 
    }
}

// Adapter bridges the Gap: 
class LegacyAudioAdapter implements MediaPlayer{
    private final LegacyAudioSDK sdk; 
    public LegacyAudioAdapter(LegacyAudioSDK sdk){
        this.sdk = sdk; 
    }
    @Override 
    public void play(String filename){
        sdk.startTrack(filename); 
    }
    @Override 
    public void pause(){
        sdk.haltPlayback(); 
    }
    @Override 
    public void stop(){
        sdk.terminateSession(); 
    }
}

// Client code: 
public class adapter1{
    public static void main(String args[]){
        MediaPlayer player = new LegacyAudioAdapter(new LegacyAudioSDK()); 
        player.play("aaronmat1905/song1.mp3"); 
        player.pause(); 
        player.stop(); 
    }
}