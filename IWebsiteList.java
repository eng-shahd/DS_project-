public interface IWebsiteList {
    void add(String url); // Add a URL to the doubly linked list
    String back(); // Move to the previous node
    String forward(); // Move to the next node
    String jumpTo(String url); // Jump to a specific node
    String display(); // Display the full list of websites
}