import java.util.* ; 

// Fetching stream metadata hits the database on every call. You want transparent caching without changing metadataservice or it's callers

// Common interface: 
interface MetadataService{
    String getMetadata(String contentID); 
}
// Real Implementation: does the expensive work
class DatabaseService implements MetadataService{ 
    @Override 
    public String getMetadata(String contentID){
        System.out.println("[DB] Fetching Metadata for: "+ contentID); 
        return "{title: 'Aadu2` , year: 2016, genere: 'Comedy'}"; 
    }
}
// Proxy: Same interface, adds caching transparently
class DatabaseProxy implements MetadataService{
    private final MetadataService real; 
    private final Map<String, String> cache = new HashMap<>(); 
    public DatabaseProxy(MetadataService real){
        this.real = real; 
    }
    @Override
    public String getMetadata(String contentID){ 
        if(cache.containsKey(contentID)){
            System.out.println("[Cache] Hit for: "+ contentID); 
            return cache.get(contentID); 
        }

        // Cache Miss -- delegate to real service, then store result
        System.out.println("[Cache] Miss for: "+ contentID + "-- Query DB"); 
        String metadata = real.getMetadata(contentID); 
        cache.put(contentID, metadata); 
        return metadata; 
    }
}

// Client -- wired once, never changed: 
public class proxy1{
    public static void main(String args[]){
        MetadataService service = new DatabaseProxy(new DatabaseService()); 
        service.getMetadata("Aadu2_2016"); 
        service.getMetadata("Aadu2_2016"); 
        service.getMetadata("Aadu2_2016"); 
        service.getMetadata("Aadu2_2016"); 

    }
}
