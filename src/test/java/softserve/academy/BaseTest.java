package softserve.academy;

import org.testng.annotations.*;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

import java.util.logging.Level;
import java.util.logging.Logger;

import static softserve.academy.models.Utils.*;

public class BaseTest {

    protected static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
    protected Level level = Level.INFO;

    @BeforeSuite(groups = {"ordinary", "login"}, description = "")
    public void beforeSuite() {
        LOGGER.log(level, "Caesar Test Suite started ...");
    }

    @BeforeMethod(groups = {"ordinary"}, description = "Preconditions for ordinary test")
    public void setUpForOrdinaryTest() {
        LOGGER.log(level, "ordinary before method ... ");

        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User("sasha", "1234"));
    }

    @BeforeMethod(groups = {"login", "about"}, description = "Preconditions for login test")
    public void setUpForLogin() {
        LOGGER.log(level, "login before method ... ");

        setDriver()
                .manage()
                .window()
                .maximize();
    }


    @AfterMethod(groups = {"ordinary", "login"}, description = "")
    public void tearDown() {
        LOGGER.log(level, "after method ...");
        getDriver().quit();
    }

    @AfterSuite(groups = {"ordinary", "login"}, description = "")
    public void afterSuite() {
        LOGGER.log(level, "Caesar Test Suite finished ...");
    }

    
    @Parameters({"login", "password"})
    @BeforeMethod(groups = {"userStory201"}, description = "Preconditions for user story 2-01 test")
    public void setUpForUserStory201Test(String login, String password) {
        LOGGER.log(level, "userStory201 before method ... ");

        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(login, password);
    }

    @AfterMethod(groups = {"userStory201"}, description = "Postpone actions after user story 2-01 test")
    public void tearDownAfterUserStory201() {
        LOGGER.log(level, "userStory201 after method ...");
        getDriver().quit();
    }


    @BeforeClass(groups = {"us107"}, description = "")
    public void beforeSuite107() {
        setDriver()
                .manage()
                .window()
                .maximize();
        LOGGER.log(level, "107 Caesar Test Suite started ...");
        new LoginPageActions()
                .openLoginPage();
    }

    @BeforeMethod(groups = {"us107"}, description = "")
    public void setUpForLogin107() {
        LOGGER.log(level, "107 before method ... ");
    }

    @AfterMethod(groups = {"us107"}, description = "")
    public void tearDown107() {
        LOGGER.log(level, "107 after method ...");
        getDriver().navigate().to(LOGOUT_URL);
    }

    @AfterClass(groups = {"us107"}, description = "")
    public void afterSuite107() {
        LOGGER.log(level, "107 Caesar Test Suite finished ...");
        getDriver().quit();
    }
}