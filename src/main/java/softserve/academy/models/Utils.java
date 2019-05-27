package softserve.academy.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import softserve.academy.pages.BasePage;

public class Utils {

    public final static String BASE_URL="http://146.148.17.49/";
    public final static String LOGOUT_URL = "http://146.148.17.49/logout";
    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", BasePage.class.getResource("/chromedriver.exe").getPath());
    }

    public static WebDriver setDriver() {
        driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }

}