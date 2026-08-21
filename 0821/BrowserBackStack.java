import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserBackStack {

    private Deque<String> history = new ArrayDeque<>();
    private String currentPage = null;

    public void visit(String url) {
        if (currentPage != null) {
            history.push(currentPage);
        }

        currentPage = url;
        System.out.println("Visit: " + currentPage);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("No previous page.");
            return;
        }

        currentPage = history.pop();
        System.out.println("Back to: " + currentPage);
    }

    public void current() {
        if (currentPage == null) {
            System.out.println("No current page.");
        } else {
            System.out.println("Current: " + currentPage);
        }
    }

    public static void main(String[] args) {

        BrowserBackStack browser = new BrowserBackStack();

        browser.current();
        browser.back();

        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("github.com");

        browser.current();

        browser.back();
        browser.current();

        browser.back();
        browser.back();
        browser.back();
    }
}