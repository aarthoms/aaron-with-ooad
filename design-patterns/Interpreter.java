// Interpreter -- Define a grammar, evaluate expression from it. Grammar -> AST from expressions
import java.util.*; 
class ContentContext{
    public final String title; 
    public final String genre; 
    public final double rating; 
    public final Set<String> tags; 

    public ContentContext(String title, String genre, double rating, Set<String> tags){
        this.title = title ;
        this.genre = genre ; 
        this.rating = rating; 
        this.tags = tags; 
    }
}

// Expression Interface -- Every node must be interpretable
interface FilterExpression{
    boolean interpret(ContentContext context); 
}

// Terminal expressions
class GenreExpression implements FilterExpression{
    private final String genre; 
    public GenreExpression(String genre){this.genre = genre; }

    @Override
    public boolean interpret(ContentContext ctx){
        return ctx.genre.equalsIgnoreCase(genre); 
    }
}

// Matches content with rating above a threshold 
class MinRatingExpression implements FilterExpression{
    private final double minRating; 
    public MinRatingExpression(double minRating){
        this.minRating = minRating; 
    }
    @Override
    public boolean interpret(ContentContext ctx){
        return ctx.rating >= minRating; 
    }
}

// Matches content with a Specific tag
class TagExpression implements FilterExpression{
    private final String tag; 
    public TagExpression(String tag){this.tag = tag; }
    @Override 
    public boolean interpret(ContentContext ctx){
        return ctx.tags.contains(tag); 
    }
}

// And Expression 
class AndExpression implements FilterExpression{
    private final FilterExpression left, right; 
    public AndExpression(FilterExpression left, FilterExpression right){
        this.left = left; 
        this.right = right; 
    }
    @Override 
    public boolean interpret(ContentContext ctx){
        return left.interpret(ctx) && right.interpret(ctx); 
    }
}

// Or Expression
class OrExpression implements FilterExpression{
    private final FilterExpression left, right; 
    public OrExpression(FilterExpression left, FilterExpression right){
        this.left = left; 
        this.right = right; 
    }
    @Override 
    public boolean interpret(ContentContext ctx){
        return left.interpret(ctx) || right.interpret(ctx); 
    }
}

// Not Expression
class NotExpression implements FilterExpression{
    private final FilterExpression expr; 
    public NotExpression(FilterExpression expr){
        this.expr = expr; 
    }
    @Override 
    public boolean interpret(ContentContext ctx){
        return !expr.interpret(ctx); 
    }
}


// Search Engine 
public class Interpreter{
    public static void main(String args[]){
        // Build the expression tree maually; 
        FilterExpression rule = new OrExpression(
            new AndExpression(
                new GenreExpression("Comedy"), 
                new MinRatingExpression(8.0)
            ), 
            new TagExpression("Oscar")
        ); 
        List<ContentContext> catalog = List.of(
            new ContentContext("Inception",       "SciFi",  8.8, Set.of("Oscar", "Thriller")),
            new ContentContext("The Room",        "Drama",  3.7, Set.of()),
            new ContentContext("Interstellar",    "SciFi",  8.6, Set.of("SciFi")),
            new ContentContext("Parasite",        "Thriller",8.5,Set.of("Oscar")),
            new ContentContext("Sharknado",       "SciFi",  3.3, Set.of())
        );
        System.out.println("Filter: (genre:SciFi AND rating:≥8) OR tag:Oscar\n");
        catalog.forEach(c -> {
            boolean match = rule.interpret(c);
            System.out.printf("  %-20s → %s%n", c.title, match ? "✓ match" : "✗ skip");
        }); 
    }
}