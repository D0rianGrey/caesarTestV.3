package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProfileDataSection extends BasePage {

    @FindBy(xpath = "//div[@class='profile-container']/a/i")
    public WebElement logoutButton;

    public ProfileDataSection() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

}