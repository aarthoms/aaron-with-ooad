// A Streaming remote control needs to support play, pause, skip and a full undo history, so that the User can revert any action. 

// Command Interface: 

interface PlayBackCommand{
    void execute(); 
    void undo(); 
}

class VideoPlayer{
    private String currentTrack="none"; 
    private boolean playing = false; 
    private int volume = 50; 
    public void play(String track){
        currentTrack = track; 
        playing = true; 
        System.out.println("[Player] Playing: "+ track);
    }
    public void pause(){
        playing = false; 
        System.out.println("[Player] Paused: "+ currentTrack); 
    }
    public void resume(){
        playing = true; 
        System.out.println("[Player] Resumed: "+ currentTrack); 
    }
    public void setVolume(int level){
        this.volume = level; 
        System.out.println("[Player] Volume changed to "+ level); 
    }
    public int getVolume(){return volume;}
    public String getCurrentTrack(){return currentTrack; }
}
// Concrete commands
class PlayCommand implements PlayBackCommand{
    private final VideoPlayer player ; 
    private final String track; 
    private String previousTrack; // saved for undo

    public PlayCommand(VideoPlayer player, String track){
        this.player = player; 
        this.track = track; 
    }
    @Override 
    public void execute(){
        previousTrack = player.getCurrentTrack(); 
        player.play(track); 
    }
    @Override 
    public void undo(){
        System.out.println("[Undo] Reverting to: "+ previousTrack); 
        if(previousTrack!=null) player.play(previousTrack); 
        else player.pause(); 
    }
}

class PauseCommand implements PlayBackCommand{
    private final VideoPlayer player ; 

    public PauseCommand(VideoPlayer player){
        this.player = player; 
    }
    @Override 
    public void execute(){
        player.pause(); 
    }
    @Override 
    public void undo(){
        player.resume(); 
    }
}

class VolumeCommand implements PlayBackCommand{
    private final VideoPlayer player ; 
    private final int         newVolume;
    private       int         previousVolume;

    public VolumeCommand(VideoPlayer player, int newVolume){
        this.player = player; 
        this.newVolume = newVolume; 
    }
    @Override 
    public void execute(){
        previousVolume = player.getVolume(); 
        player.setVolume(newVolume); 
    }
    @Override 
    public void undo(){
        System.out.println("[Undo] Restoring volume to: " + previousVolume);
        player.setVolume(previousVolume);
    }
}