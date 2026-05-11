import java.util.*; 

// A Live concert has 50K concurrent viewers. Each viewer has a chat bubble rendered on the screen. All bubbles share the same font, style and color scheme -- Only message and text position differ. 

// Font, Color, Size: Identical for every chat bubble
class BubbleStyle{ 
    private final String fontFamily; 
    private final String color; 
    private final int fontSize; 

    public BubbleStyle(String fontFamily, String color, int fontsize){
        this.fontFamily = fontFamily; 
        this.color = color; 
        this.fontSize = fontsize; 
    }
    // Renders the bubble using shared style + extrinsic (Unique Data)
    public void render(String message, int x, int y){
        System.out.printf("[Bubble] font=%-12s color=%-8s size=%d | \"%s\" @ (%d, %d)%n", fontFamily, color, fontSize, message, x,y); 
    }
}

// Flyweight Factory: Ensures that each style is created only once: 
class BubbleStyleFactory{ 
    private static final Map<String, BubbleStyle> pool = new HashMap<>(); 
public static BubbleStyle getStyle(String fontfamily, String color, int fontsize){
    String key = fontfamily + "-" + color + "-" + fontsize;

    if(!pool.containsKey(key)){
        System.out.println("[Factory] Creating new BubbleStyle: "+ key);
        pool.put(key, new BubbleStyle(fontfamily, color, fontsize));
    } else {
        System.out.println("[Factory] Reusing BubbleStyle: "+ key);
    }

    return pool.get(key);
}
    public static int poolSize(){return pool.size();}
}

// Extrinsic State -- Unique per viewer
class ChatBubble{
    private final String message; 
    private final int x, y ;
    private final BubbleStyle style; 
    public ChatBubble(String message, int x, int y, BubbleStyle style){
        this.message = message ;
        this.x = x; 
        this.y = y; 
        this.style = style; 
    }
    public void render(){style.render(message, x, y);}
}

// Simulator
public class flyweight1{
    public static void main(String[] args){
        BubbleStyle regular = BubbleStyleFactory.getStyle("Arial",   "white",  14);
        BubbleStyle vip     = BubbleStyleFactory.getStyle("Georgia", "gold",   16);
        List<ChatBubble> bubbles = List.of(
            new ChatBubble("Great Concert!", 120, 300, vip), 
            new ChatBubble("I am AaronTM", 200, 450, regular), 
            new ChatBubble("Hey, who's using this vip", 120, 120, regular), 
            new ChatBubble("I want to beat this guy up...", 20, 30, vip)
        ); 
        bubbles.forEach(ChatBubble::render); 
        System.out.println("\nTotal BubbleStyle objects in memory: "
                + BubbleStyleFactory.poolSize()
                + " (regardless of " + bubbles.size() + " bubbles)");
    }
}