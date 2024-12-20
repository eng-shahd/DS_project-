import java.util.*;

public class BrowserHistoryManager implements IBrowserHistoryManager {
    private final WebsiteList websiteList;
    private final Stack<String> backStack;
    private final Stack<String> forwardStack;

    public BrowserHistoryManager() {
        this.websiteList = new WebsiteList();
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();
    }

    @Override
    public void visit(String url) {
        if (websiteList.getCurrentNode() != null) {
            backStack.push(websiteList.getCurrentNode().url);
        }

        websiteList.add(url);
        forwardStack.clear(); // Clear the forward stack after a new visit
    }

    @Override
    public String back() {
        if (backStack.isEmpty()) {
            throw new NoSuchElementException("No previous pages in history.");
        }

        forwardStack.push(websiteList.getCurrentNode().url);
        return websiteList.jumpTo(backStack.pop());
    }

    @Override
    public String forward() {
        if (forwardStack.isEmpty()) {
            throw new NoSuchElementException("No forward pages in history.");
        }

        backStack.push(websiteList.getCurrentNode().url);
        return websiteList.jumpTo(forwardStack.pop());
    }

    @Override
    public void jumpTo(String url) {
        if (websiteList.getCurrentNode() != null) {
            backStack.push(websiteList.getCurrentNode().url);
        }
        websiteList.jumpTo(url);
        forwardStack.clear(); // Clear the forward stack after jumping to a page
    }

    @Override
    public void displayHistory() {
        System.out.println(websiteList.display());
    }

    @Override
    public String getCurrent() {
        if (websiteList.getCurrentNode() == null) {
            return "No current page.";
        }
        return websiteList.getCurrentNode().url;
    }

    @Override
    public List<String> getBackStack() {
        return new ArrayList<>(backStack);
    }

    @Override
    public List<String> getForwardStack() {
        return new ArrayList<>(forwardStack);
    }
}
