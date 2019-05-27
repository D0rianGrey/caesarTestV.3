package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class SchedulePage extends MainPage {

    @FindBy(xpath = "//*[@id='left-side-bar']//div[@class='group-list-footer']//button[contains(@class, 'allGroups')]")
    public
    WebElement allGroupsButton;

    @FindBy(className = "groupName")
    public
    WebElement groupName;

    @FindBy(className = "weekBtn")
    public
    WebElement weekTab;

    @FindBy(className = "keyDatesBtn")
    public
    WebElement keyDatesTab;

    //@FindBy(xpath = "//*[@id='main-section']/div/div/table/tbody")
    //@FindBy(xpath = "//*/table[@class='keydates-schedule']//tr")
    @FindBy(xpath = "//*/table[@class='keydates-schedule']/tbody/tr")
    public List<WebElement> keyDates;

    @FindBy(className = "activity")
    public
    List<WebElement> activities;
    @FindBy(className = "prevMonth")
    public WebElement prevMonthShifter;
    @FindBy(className = "nextMonth")
    public WebElement nextMonthShifter;
    @FindBy (xpath = "//*/table[@class='calendar-table']/tbody/tr[1]/th")
    public List<WebElement> calendarHeaders;
    @FindBy(xpath = "//*/table[@class='calendar-table']/tbody/tr")
    public List<WebElement> calendarLines;
    @FindBy(xpath = "//div[@class='month-toggle']/p")
    public WebElement monthName;
    @FindBy(xpath = "//p[@class='groupStageTitle']")
    public WebElement year;
    @FindBy(xpath = "//*/table[@class='keydates-schedule']/thead/tr")
    public List<WebElement> keyDatesHeaders;
    @FindBy(xpath = "//*/table[@class='keydates-schedule']/tbody/tr")
    public List<WebElement> keyDatesLines;

    @FindBy(xpath = "//div[contains(concat('',@class,''),'small-group-view')]")
    public List<WebElement> groups;
    @FindBy(xpath = "//button[@class='allGroups']")
    public WebElement myGroupsBtn;
    @FindBy(xpath = "//label[@for='endedGroups']")
    public WebElement finishedGroupsFilter;
    @FindBy(xpath = "//label[@for='currentGroups']")
    public WebElement currentGroupsFilter;
    @FindBy(xpath = "//label[@for='futureGroups']")
    public WebElement plannedGroupsFilter;


    public SchedulePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

}