package softserve.academy.alexandrTests;

import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

public class LogInSuccessfully102Test extends BaseTest102 {

    @Test
    public void logInSuccessfullyTest() {
        User user = new User("Dmytro", "1234");

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(user)
                .verifyUserPhotoIsDisplayed()
                .assertAll();
    }

}