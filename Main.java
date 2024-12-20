import java.util.*;

public class Main {
    public static void main(String[] args) {
        BrowserHistoryManager browser = new BrowserHistoryManager();

        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("stackoverflow.com");
        browser.visit("github.com");

        System.out.println("Current: " + browser.getCurrent()); // github.com
        System.out.println("Back: " + browser.back()); // stackoverflow.com
        System.out.println("Back: " + browser.back()); // youtube.com
        System.out.println("Forward: " + browser.forward()); // stackoverflow.com

        browser.visit("linkedin.com");
        System.out.println("Current: " + browser.getCurrent()); // linkedin.com
        browser.jumpTo("google.com");
        System.out.println("Jump to: " + browser.getCurrent()); // google.com

        System.out.println("History:");
        browser.displayHistory();

        System.out.println("Back Stack: " + browser.getBackStack());
        System.out.println("Forward Stack: " + browser.getForwardStack());
    }
}
