package softserve.academy.us101;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;

public class LoginPageKeyboardEventFunctionality101Test extends BaseTest {


    @DataProvider(name = "data")
    public static Object[][] loginData() {
        return new Object[][]{
                {"dmytro", "1234", By.name("login")},
                {"dmytro", "1234", By.name("password")},
                {"", "1234", By.name("password")},
                {"", "1234", By.name("login")},
                {"artur", "", By.name("password")},
                {"artur", "", By.name("login")}};

    }


    @DataProvider(name = "data2")
    public static Object[][] loginData2() {
        return new Object[][]{
                {"1234", "1234"}};

    }

    //button esc functionality
    @Test(groups = {"loginPage"}, description = "test for esk key functionality", dataProvider = "data", priority = 2)
    void testEscapeKeyEvent(String login, String password, By locator) {

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .fillLoginField(login)
                .fillPasswordField(password)
                .pressEscKey(locator)
                .verifyEmptyLoginField()
                .verifyEmptyPasswordField()
                .assertAll();

    }

    //button enter functionality
    @Test(groups = {"loginPage"}, description = "test for enter key functionality", dataProvider = "data2", priority = 1)
    void testEnterKeyEvent(String login, String password) {


        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .fillLoginField(login)
                .fillPasswordField(password)
                .pressEnterKey()
                .verifyAbilitySaveLoginValue(login)
                .verifyEmptyPasswordField()
                .verifyErrorMessage()
                .assertAll();

    }


}
