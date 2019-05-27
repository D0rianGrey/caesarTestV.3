package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import softserve.academy.models.EnglishLevel;

public class MWSingleStudent extends BasePage {

    @FindBy(xpath = "//div[@id='modal-window']//*[contains(@name,'groupId')]")
    public WebElement textBoxGroup;

    @FindBy(xpath = "//div[@id='modal-window']//*[contains(@class,'form-control firstName')]")
    public WebElement fieldFirstName;

    @FindBy(xpath = "//div[@id='modal-window']//*[contains(@class,'form-control lastName')]")
    public WebElement fieldLastName;

    @FindBy(xpath = "//*[contains(@class='form-control fieldEnglishLevel')]")
    public WebElement fieldEnglishLevel;
    public Select select;

    @FindBy(xpath = "//input[@name='uploadCV']")
    public WebElement cv;

    @FindBy(xpath = "//div[@id='modal-window']//*[@name='incomingTest']")
    public WebElement fieldMarkIncomingTest;

    @FindBy(xpath = "//div[@id='modal-window']//*[@name='entryScore']")
    public WebElement fieldMarkEntryScore;

    @FindBy(xpath = "//select[@class='form-control approvedBy']")
    public WebElement approvedBy;

    @FindBy(xpath = "//input[@name='uploadPhoto']")
    public WebElement browsePhoto;

    @FindBy(xpath = "//button[@class='save-changes fa fa-check-circle-o fa-3x btn-icon']")
    public WebElement confirm;

    @FindBy(xpath = "//button[@class='close-modal-window fa fa-times-circle-o fa-3x btn-icon']")
    public WebElement close;

   // public EnglishLevel englishLevel;

    public MWSingleStudent() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
