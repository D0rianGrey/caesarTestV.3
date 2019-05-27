package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GroupsPage extends MainPage {
    @FindBy(xpath = "//*[@id='left-side-bar']//div[contains(concat(' ', @class, ' '), ' paginator ')]")
    public WebElement paginator;
    @FindBy(xpath = "//button[@name='info']")
    public WebElement infoTab;
    @FindBy(xpath = "//button[@name='students']")
    public WebElement studentsTab;
    @FindBy(xpath = "//button[@name='shedule']")
    public WebElement scheduleTab;
    @FindBy(xpath = "//button[@name='message']")
    public WebElement messageTab;
    @FindBy(xpath = "//button[@class='btn editScheduleBtn']/i[@class='fa fa-cog fa-2x']")
    public WebElement cogwheel;
    @FindBy(xpath = "//div[@class='key-dates']/table")
    public WebElement keyDatesTable;
    @FindBy(xpath = "//div[@class='group_info']/table")
    public WebElement groupInfoTable;
    @FindBy(xpath = "//div[@class='group_coordination']/table")
    public WebElement groupCoordinationTable;
    @FindBy(xpath = "//*[@id='main-section']/div/div/table")
    public WebElement studentsInfoTable;
    @FindBy(xpath = "//td[contains(text(),'Date start:')]/../td[2]")
    public WebElement dateStart;
    @FindBy(xpath = "//td[contains(text(),'Date finish:')]/../td[2]")
    public WebElement dateFinish;
    @FindBy(xpath = "//td[contains(text(),'Teacher')]/../td[2]")
    public WebElement teacher;
    @FindBy(xpath = "//td[contains(text(),'Expert')]/../td[2]")
    public WebElement expert;
    @FindBy(xpath = "//button[@name='edit']")
    public WebElement editGroupButton;

    @FindBy(xpath = "//*[@id='logo']/a/img")
    public WebElement logo;



    public GroupsPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

}