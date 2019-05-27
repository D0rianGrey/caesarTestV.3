package softserve.academy.us101;

import org.testng.annotations.*;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

import java.util.logging.Level;
import java.util.logging.Logger;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;

public class BaseTest {


    protected static final Logger LOGGER = Logger.getLogger(softserve.academy.BaseTest.class.getName());
    protected Level level = Level.INFO;


    @BeforeTest(groups = {"schedulePage"}, description = "Preconditions for ordinary test")
    public void setUpForOrdinaryTest() {
        LOGGER.log(level, "ordinary group, open browser and login as teacher... ");

        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User("sasha", "1234"));
    }

    @AfterMethod(groups = {"schedulePage"}, description = "Preconditions for ordinary test")
    public void updatePage() {
        LOGGER.log(level, "ordinary group, update page... ");
        getDriver().get("http://146.148.17.49/");
    }


    @AfterTest(groups = {"schedulePage"}, description = "Preconditions for ordinary test")
    public void close() {
        LOGGER.log(level, "ordinary group,logout and close browser... ");
        getDriver().get("http://146.148.17.49/logout");
        getDriver().quit();
    }


    @BeforeClass(groups = {"loginPage"}, description = "Preconditions for login test")
    public void setUpforLogin() {
        LOGGER.log(level, "login group, open browser... ");

        setDriver()
                .manage()
                .window()
                .maximize();
    }

    @AfterMethod(groups = {"loginPage"}, description = "")
    public void logout() {
        LOGGER.log(level, "login group,logout ...");
        getDriver().get("http://146.148.17.49/logout");

    }

    @AfterClass(groups = {"loginPage"}, description = "")
    public void closeBrowser() {
        LOGGER.log(level, "login group, close browser ...");
        getDriver().quit();
    }


}

