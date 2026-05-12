// Your platform has one StreamingConfig that holds the API Keys, CDN Endpoints, and feature flags. It must be the same object everywhere -- creating multiple configs would cause split-brain bugs

import java.util.*; 

class StreamingConfig{
    // Private Constructor -- noone can call new Streaming Config
    private final Map<String, String> settings = new HashMap<>(); 
    private StreamingConfig(){
        // Simulating loading from a config file; 
        settings.put("CDN_BASE_URL",    "https://cdn.stream.io");
        settings.put("MAX_BITRATE",     "4500");
        settings.put("FEATURE_4K",      "true");
        settings.put("API_KEY",         "sk_live_abc123");
        System.out.println("[StreamingConfig] Loaded configuration.");       
    }
    // Holder Pattern: Instance created only when first accessed: 
    private static class Holder{
        private static final StreamingConfig INSTANCE = new StreamingConfig(); 
    }
    public static StreamingConfig getInstance(){
        return Holder.INSTANCE; 
    }
    public String get(String key){
        return settings.getOrDefault(key, "Not Found"); 
    }
    public void set(String key, String value){
        settings.put(key, value); 
    }
}

public class Singleton {
    public static void main(String args[]){
        StreamingConfig c1 = StreamingConfig.getInstance(); 
        StreamingConfig c2 = StreamingConfig.getInstance(); 
        System.out.println("Same Instance? "+ (c1 == c2)); 
        System.out.println("CDN: "     + c1.get("CDN_BASE_URL"));
        System.out.println("4K on?  "  + c2.get("FEATURE_4K"));

        // Change via c1, visible through c2 — same object
        c1.set("FEATURE_4K", "false");
        System.out.println("4K now? "  + c2.get("FEATURE_4K")); // false
    }
}
