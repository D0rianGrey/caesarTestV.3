package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.actions.SchedulePageActions;
import softserve.academy.actions.StudentsPageActions;
import softserve.academy.modal_windows.SelectLocationMW;
import softserve.academy.models.Utils;

public class TopMenu {
    @FindBy(xpath = "//div[contains(@class,'itemMenu')][p='Locations']")
    private WebElement locations;
    @FindBy(xpath = "//div[contains(@class,'itemMenu')][p='Groups']")
    private WebElement groups;
    @FindBy(xpath = "//div[contains(@class,'itemMenu')][p='Students']")
    private WebElement students;
    @FindBy(xpath = "//div[contains(@class,'itemMenu')][p='Schedule']")
    public WebElement schedule;
    @FindBy(xpath = "//div[contains(@class,'itemMenu')][p='About']")
    private WebElement about;
    @FindBy(xpath = "//*[@id='top-menu']//a[@class='logout']")
    private WebElement logout;


    public TopMenu() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Utils.getDriver(), 20), this);
    }

    public SelectLocationMW openSelectLocationWindow() {
        locations.click();
        return new SelectLocationMW();
    }

    public GroupsPageActions goToGroupsPage() {
        groups.click();
        return new GroupsPageActions();
    }

    public StudentsPageActions goToStudentsPage() {
        students.click();
        return new StudentsPageActions();
    }

    public SchedulePageActions goToSchedulePage() {
        schedule.click();
        return new SchedulePageActions();
    }

    public AboutPage goToAboutPage() {
        about.click();
        return new AboutPage();
    }

    public LoginPageActions logOut() {
        logout.click();
        return new LoginPageActions();
    }
}
