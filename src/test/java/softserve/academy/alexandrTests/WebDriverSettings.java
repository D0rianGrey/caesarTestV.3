package softserve.academy.alexandrTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import softserve.academy.models.Utils;

public class WebDriverSettings {

    @BeforeTest
    public static void setUp() {
        Utils.getDriver().manage().window().maximize();
    }

    @AfterTest
    public void logOut() {
        Utils.getDriver().get(Utils.LOGOUT_URL);
    }

    @AfterTest(dependsOnMethods = "logOut")
    public void quit() {
        Utils.getDriver().quit();
    }

}