package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LeftContextMenu extends BasePage {

    @FindBy(xpath = "//i[@class='fa fa-plus-square-o fa-4x create']")
    public WebElement createButton;

    @FindBy(xpath = "//i[@class='fa fa-search fa-4x search']")
    public WebElement searchButton;

    @FindBy(xpath = "//i[@class='fa fa-cog fa-4x edit']")
    public WebElement editButton;

    @FindBy(xpath = "//i[@class='fa fa-trash-o fa-4x delete']")
    public WebElement deleteButton;

    public LeftContextMenu() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

}