package softserve.academy.alexandrTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

public class LogOut102Test extends BaseTest102 {

    @BeforeTest
    public void logIn() {
        User user = new User("Dmytro", "1234");

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(user)
                .waitGroupsPageLoad();
    }

    @Test
    public void logoutTest() {
        new GroupsPageActions()
                .goToProfileDataSection()
                .waitProfileDataSectionLoad()
                .clickLogoutButton()
                .waitLogInPageLoad()
                .verifyLoginFieldIsDisplayed()
                .assertAll();
    }

}