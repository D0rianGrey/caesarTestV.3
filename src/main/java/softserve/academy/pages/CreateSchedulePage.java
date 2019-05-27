package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CreateSchedulePage extends SchedulePage {

    @FindBy(xpath = "//label[@for='radio-Work with Expert']")
    public WebElement workWithExpertEventType;

    @FindBy(xpath = "//label[@for='radio-Weekly report']")
    public WebElement weeklyReportEventType;

    @FindBy(xpath = "//label[@for='radio-Practice']")
    public WebElement practiceEventType;

    @FindBy(id = "save")
    public WebElement saveButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@data-time='16:00' and @data-day='monday']")
    public WebElement monday_16_00;

    @FindBy(xpath = "//div[@data-time='17:00' and @data-day='monday']")
    public WebElement monday_17_00;

    @FindBy(xpath = "//div[@data-time='16:00' and @data-day='tuesday']")
    public WebElement tuesday_16_00;

    @FindBy(xpath = "//div[@data-time='17:00' and @data-day='tuesday']")
    public WebElement tuesday_17_00;

    @FindBy(xpath = "//div[@data-time='16:00' and @data-day='wednesday']")
    public WebElement wednesday_16_00;

    @FindBy(xpath = "//div[@data-time='16:00' and @data-day='thursday']")
    public WebElement thursday_16_00;

    @FindBy(xpath = "//div[@data-time='17:00' and @data-day='thursday']")
    public WebElement thursday_17_00;

    @FindBy(xpath = "//div[@data-time='16:00' and @data-day='friday']")
    public WebElement friday_16_00;

    @FindBy(xpath = "//div[@data-time='17:00' and @data-day='friday']")
    public WebElement friday_17_00;

    @FindBy(xpath = "//div[@data-time='18:00' and @data-day='friday']")
    public WebElement friday_18_00;

    @FindBy(xpath = "//div[@data-time='19:00' and @data-day='friday']")
    public WebElement friday_19_00;

    public CreateSchedulePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

}