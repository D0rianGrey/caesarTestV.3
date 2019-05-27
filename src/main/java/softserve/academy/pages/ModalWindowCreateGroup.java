package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ModalWindowCreateGroup extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameField;

    @FindBy(xpath = "//select[@name='direction']")
    public WebElement direction;

    @FindBy(xpath = "//option[@value='ATQC']")
    public WebElement atqcDirection;

    @FindBy(xpath = "//span[@class='add-teacher-btn']")
    public WebElement addTeacher;

    @FindBy(id = "acceptSelect")
    public WebElement submitAddingTeacher;

    @FindBy(id = "experts")
    public WebElement addExpert;

    @FindBy(xpath = "//*[@id='experts']/div/div/div/input")
    public WebElement addExpertField;

    @FindBy(id = "acceptInput")
    public WebElement submitAddingExpert;

    @FindBy(xpath = "//*[@id='modal-window']/section/section/section/div[2]/div[2]/span")
    public WebElement startDateCalendarTab;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")
    public WebElement startDay;

    @FindBy(id = "save")
    public WebElement submitButton;

    public ModalWindowCreateGroup() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

}