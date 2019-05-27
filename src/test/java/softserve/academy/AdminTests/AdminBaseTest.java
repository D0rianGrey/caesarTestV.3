package softserve.academy.AdminTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import softserve.academy.BaseTest;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;
import softserve.academy.models.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;

public class AdminBaseTest { protected static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
    protected Level level = Level.INFO;
    User userLogIn = new User("alena", "1234");

//
//    @BeforeSuite(groups = {"ordinaryAdmin", "suite"}, description = "")
//    public void beforeSuite() {
//        LOGGER.log(level, "Caesar Test Suite started ...");
//    }

    @BeforeTest(groups = {"ordinaryAdmin", "test"}, description = "Preconditions for ordinary test")
    public void setUpForOrdinaryTest(){

        setDriver()
                .manage()
                .window()
                .maximize();
    }

    @BeforeClass(groups = {"ordinaryAdmin", "class"}, description = "Preconditions for ordinary test")
    public void setUpForOrdinaryClass(){
        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(userLogIn.getLogin(), userLogIn.getPassword())
                .waitPageLoaded();
    }


    @AfterClass(alwaysRun = true, groups = {"ordinaryAdmin", "class"}, description = "")
    public void quiteClass() {
        Utils.getDriver().get(Utils.LOGOUT_URL); ;
    }

    @AfterTest(alwaysRun = true, groups = {"ordinaryAdmin", "test"}, description = "")
    public void quiteTest() {
        getDriver().quit() ;
    }


//    @AfterSuite(groups = {"ordinaryAdmin", "suite"}, description = "")
//    public void afterSuite() {
//        LOGGER.log(level, "Caesar Test Suite finished ...");
//    }
}
