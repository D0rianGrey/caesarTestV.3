package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class MWEditStudentlist extends BasePage {

    @FindBy(xpath = "//*[@class='fa fa-plus-square-o fa-4x createStudent']")
    public WebElement createStudent;

    @FindBy(xpath = "//*[@class='fa fa-times-circle-o fa-3x btn-icon exit']")
    public WebElement iconExit;

    @FindBy(xpath = "//*[@class='fa fa-chevron-right right']")
    public WebElement chevronRight;

    @FindBy(xpath = "//*[@class='fa fa-chevron-left']")
    public WebElement chevronLeft;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> studentList;

    @FindBy(xpath = "//th[contains(@class,'Name')]")
    public WebElement tHadName;

    @FindBy(xpath = "//th[contains(@class,'photo')]")
    public WebElement tHadPhoto;

    @FindBy(xpath = "//th[contains(@class,'engLevel')]")
    public WebElement tHadEnglishLevel;

    @FindBy(xpath = "//th[contains(@class,'incomingTest')]")
    public WebElement tHadIncomingTest;

    @FindBy(xpath = "//th[contains(@class,'entryScore')]")
    public WebElement tHadEntryScore;

    @FindBy(xpath = "//th[contains(@class,'approvedBy')]")
    public WebElement tHadApprovedBy;


    public MWEditStudentlist() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
