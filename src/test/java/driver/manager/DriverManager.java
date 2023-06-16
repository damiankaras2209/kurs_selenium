package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            ChromeOptions capability = new ChromeOptions();
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.240.202:4444"), capability);
            }catch (MalformedURLException e) {
                e.printStackTrace();
            }
//            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        if(!driver.getClass().equals(FirefoxDriver.class))
            driver.quit();
        driver = null;
    }
}