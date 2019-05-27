package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogInPage extends BasePage {
    private final String ERROR_MESSAGE = "Incorrect login or password. Please, try again";

    @FindBy(name = "login")
    public WebElement loginField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='" + ERROR_MESSAGE + "']")
    public WebElement loginErrorMessage;

    public LogInPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

}