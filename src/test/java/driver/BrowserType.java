package driver;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer"),
    EDGE("msedge");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }

}
