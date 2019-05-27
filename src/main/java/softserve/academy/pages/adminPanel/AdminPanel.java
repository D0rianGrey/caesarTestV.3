package softserve.academy.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import softserve.academy.models.Utils;
import softserve.academy.pages.BasePage;

import java.util.List;

public class AdminPanel extends BasePage {

    @FindBy(xpath = "//h2")
    public WebElement header;

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersTab;

    @FindBy(xpath = "//a[@href='#groups']")
    public WebElement groupsTab;

    @FindBy(xpath = "//a[@href='#students']")
    public WebElement studentsTab;

    @FindBy(xpath = "//*[text()='Add user']")
    public WebElement addUser;

    @FindBy(xpath = "//*[text()='Add group']")
    public WebElement addGroup;

    @FindBy(xpath = "//*[text()='Add student']")
    public WebElement addStudent;

    @FindBy(xpath = "//button[@class='btn btn-warning home']")
    public WebElement escapeHomeButton;

    @FindBy(xpath = "//body [@class='modal-open']")
    public WebElement modalWindow;

    //Non static WebElements:
    public List<WebElement> table;
    public WebElement tableRow;
    public List<WebElement>rowCells;
    public WebElement rowCell;
    public WebElement delete;
    public WebElement edit;


    public AdminPanel(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }
}
