package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class StudentsPage extends MainPage {

//    @FindBy(className = "groupName")
//    public WebElement groupName;
//
//    @FindBy(xpath = "*//button[@name='edit']")
//    public WebElement cogwheelAllGrups;

    @FindBy(xpath = "//button[contains(@class,'allGroups')]")
    public WebElement filterAllGrups;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> students;

    @FindBy(xpath = "//*[@class='btn-group']/*[@name='students']/i")
    public WebElement tabStudents;

    @FindBy(xpath = "//*[@class='btn-group']/*[@name='shedule']/i")
    public WebElement tabSchedule;

    @FindBy(xpath = "//*[@class='btn-group']/*[@name='message']/i")
    public WebElement tabMessage;

    @FindBy(xpath = "*//table//*[contains(@class,'fullName')]")
    public WebElement tHeadFullName;

    @FindBy(xpath = "*//table//*[contains(@class,'photo')]")
    public WebElement tHeadPhoto;

    @FindBy(xpath = "*//table//*[contains(@class,'englishLevel')]")
    public WebElement tHeadEnglishLevel;

    @FindBy(xpath = "*//table//*[contains(@class,'incomingTest')]")
    public WebElement tHeadIncomingTest;

    @FindBy(xpath = "*//table//*[contains(@class,'entryScore')]")
    public WebElement tHeadEntryScore;

    @FindBy(xpath = "*//table//*[contains(@class,'approvedBy')]")
    public WebElement tHeadApprovedBy;

    @FindBy(xpath = "//*[@class='groupStage']")
    public WebElement groupStage;

    public StudentsPage() {

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }
}
