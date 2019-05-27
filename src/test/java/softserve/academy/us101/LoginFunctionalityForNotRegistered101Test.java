package softserve.academy.us101;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

public class LoginFunctionalityForNotRegistered101Test extends BaseTest {

    @DataProvider(name = "authorizationData")
    public static Object[][] credentials() {
        return new Object[][]{
                {"dmytro", "qazq"},
                {"frtrf", "1234"},
                {"ortymd", "qazq"}};

    }


    @Test(groups = {"loginPage"}, description = "test verify Login Page Functionality for not registered users",
            dataProvider = "authorizationData")
    void verifyLoginPageFunctionality(String login, String password) {

        User user = new User(login, password);

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .incorrectLogin(user)
                .verifyLoginFieldIsDisplayed()
                .verifyIncorrectDataMessageIsDisplayed()
                .verifyErrorMessage()
                .verifyAbilitySaveLoginValue(login)
                .verifyEmptyPasswordField()
                .assertAll();

    }
}
