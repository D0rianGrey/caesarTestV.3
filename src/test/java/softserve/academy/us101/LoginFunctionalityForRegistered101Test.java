package softserve.academy.us101;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

public class LoginFunctionalityForRegistered101Test extends BaseTest {

    @DataProvider(name = "authorization")
    public static Object[][] authorizationData() {
        return new Object[][]{
                {"dmytro", "1234"},
                {"sasha", "1234"},
                /*{"artur", "1234"}*/};

    }


    @Test(groups = {"loginPage"}, description = "test verify Login Page Functionality for registered users",
            dataProvider = "authorization")
    void verifyLoginPageFunctionality(String login, String password) {

        User user = new User(login, password);

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(user)
                .waitPageLoaded()
                .verifyLogoCaesarIsDisplayed()
                .verifyURL()
                .assertAll();

    }


}
