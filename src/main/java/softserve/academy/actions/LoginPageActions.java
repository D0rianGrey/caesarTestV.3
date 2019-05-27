package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import softserve.academy.models.User;
import softserve.academy.models.Utils;
import softserve.academy.pages.LogInPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static softserve.academy.models.Utils.getDriver;

public class LoginPageActions extends BaseActions {

    private LogInPage logInPage = new LogInPage();

    public LoginPageActions() {
    }

    public LoginPageActions waitLogInPageLoad() {
        waitClickable(By.name("login"));
        waitClickable(By.name("password"));
        LOGGER.log(Level.INFO, "Wait for login menu displayed....");
        return this;
    }

    public GroupsPageActions login(User user) {
        waitClickable(logInPage.loginField).sendKeys(user.getLogin());
        waitClickable(logInPage.passwordField).sendKeys(user.getPassword());
        waitClickable(logInPage.submitButton).click();
        LOGGER.log(Level.INFO, "Credentials entered ...");
        return new GroupsPageActions();
    }

    public LoginPageActions incorrectLogin(User user) {
        waitClickable(logInPage.loginField).sendKeys(user.getLogin());
        waitClickable(logInPage.passwordField).sendKeys(user.getPassword());
        waitClickable(logInPage.submitButton).click();
        LOGGER.log(Level.INFO, "Incorrect user data entered ...");
        return this;
    }

    public GroupsPageActions login(String login, String password) {
        waitClickable(logInPage.loginField).sendKeys(login);
        waitClickable(logInPage.passwordField).sendKeys(password);
        waitClickable(logInPage.submitButton).click();
        LOGGER.log(Level.INFO, "Credentials entered ...");
        return new GroupsPageActions();
    }

    public LoginPageActions openLoginPage() {
        Utils.getDriver().get("http://146.148.17.49/");
        return this;
    }

    public LoginPageActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginPageActions fillLoginField(String username) {
        fillField(logInPage.loginField, username);
        return this;
    }

    public LoginPageActions fillPasswordField(String password) {
        fillField(logInPage.passwordField, password);
        return this;
    }

    public LoginPageActions clickSubmitButton() {
        waitClickable(logInPage.submitButton).click();
        return this;
    }

    public LoginPageActions verifyIncorrectDataMessageIsDisplayed() {
        softAssert.assertTrue(waitClickable(logInPage.loginErrorMessage).isDisplayed());
        LOGGER.log(Level.INFO, "Incorrect login or password message is display ...");
        return this;
    }

    public LoginPageActions verifyLoginFieldIsDisplayed() {
        softAssert.assertTrue(waitClickable(logInPage.loginField).isDisplayed());
        LOGGER.log(Level.INFO, "Login field is display ...");
        return this;
    }


    /*****************************************************************************************************************
     * tania's methods
     *****************************************************************************************************************/

    public LoginPageActions pressEnterKey() {
        waitClickable(logInPage.submitButton).sendKeys(Keys.ENTER);
        return this;
    }

    public LoginPageActions pressEscKey(By locator) {
        WebElement fieldForPressEsc = getDriver().findElement(locator);
        waitClickable(fieldForPressEsc).sendKeys(Keys.ESCAPE);
        return this;
    }


    public LoginPageActions verifyErrorMessage() {

        softAssert.assertEquals(logInPage.loginErrorMessage.getText(), "Incorrect login or password. Please, try again", " logged");
        return this;
    }

    public LoginPageActions verifyEmptyLoginField() {

        String actualLogin = logInPage.loginField.getAttribute("value");
        softAssert.assertTrue(actualLogin.isEmpty(), "login field not empty");
        return this;
    }

    public LoginPageActions verifyEmptyPasswordField() {

        String actualPassword = logInPage.passwordField.getAttribute("value");
        softAssert.assertTrue(actualPassword.isEmpty(), "password field not empty");
        return this;
    }

    public LoginPageActions verifyAbilitySaveLoginValue(String login) {
        String actualLogin = logInPage.loginField.getAttribute("value");
        softAssert.assertEquals(actualLogin, login);
        return this;
    }

    public LoginPageActions verifyValidation() {
        String LoginActual = logInPage.loginField.getAttribute("value");
        String passwordActual = logInPage.passwordField.getAttribute("value");
        softAssert.assertTrue(LoginActual.length() == 10, "length of login more 10 symbols");
        softAssert.assertTrue(passwordActual.length() == 10, "length of password more 10 symbols");
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }

}