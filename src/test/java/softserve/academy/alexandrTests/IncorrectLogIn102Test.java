package softserve.academy.alexandrTests;

import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

public class IncorrectLogIn102Test extends BaseTest102 {

    @Test
    public void incorrectLogInTest() {
        User user = new User("dmytro", "dmytro");

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .incorrectLogin(user)
                .verifyIncorrectDataMessageIsDisplayed()
                .assertAll();
    }

}