package softserve.academy.alexandrTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import softserve.academy.models.Utils;

import static softserve.academy.models.Utils.setDriver;

public class BaseTest102 {

    @BeforeTest
    public static void setUp() {
        setDriver().manage().window().maximize();
    }

    @AfterTest
    public void logOut() {
        Utils.getDriver().get(Utils.LOGOUT_URL);
    }

    @AfterTest
    public void quit() {
        Utils.getDriver().quit();
    }

}