package softserve.academy;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;

public class BaseTestK {

    //@BeforeSuite(alwaysRun = true)
    //public void openTestSite() {
    //    getDriver()
    //            .manage()
    //            .window()
    //            .maximize();
    //
    //}

    @BeforeTest(alwaysRun = true)
    @Parameters({"login", "password"})
    public void logIn(String login, String password) {
        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User(login, password));

    }

    @AfterTest(alwaysRun = true)
    @AfterGroups(groups = "with bugs")
    public void logOut() {
        getDriver().navigate().to("http://146.148.17.49/logout");
        getDriver().quit();

    }


    //@AfterSuite(alwaysRun = true)
    //public void closeBrowser() {
    //    getDriver().quit();
    //}

}
