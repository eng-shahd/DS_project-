
import java.util.List;

public interface IBrowserHistoryManager {
    void visit(String url); // Add a new URL and clear the forward stack
    String back(); // Move to the previous page using the stack
    String forward(); // Move to the next page using the stack
    void jumpTo(String url); // Navigate to a specific page
    void displayHistory(); // Print all visited pages
    String getCurrent(); // Get the current page
    List<String> getBackStack(); // View all URLs in the back stack
    List<String> getForwardStack(); // View all URLs in the forward stack
}
