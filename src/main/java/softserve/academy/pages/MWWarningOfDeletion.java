package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MWWarningOfDeletion extends BasePage {
    @FindBy(xpath = "//*[@class='message-body']/p")
    public WebElement message;

    @FindBy(xpath = "//*[@class='fa fa-check-circle-o fa-3x']")
    public WebElement buttonConfirm;

    @FindBy(xpath = "//*[@class='btn btn-cancel']/i")
    public WebElement buttonCancel;

    public MWWarningOfDeletion() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);}
}
