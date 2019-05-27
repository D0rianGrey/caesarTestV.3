package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MWEditGroupWrapper extends BasePage{

    @FindBy(xpath = "//button[@class='cancel']")
    WebElement cancel;

    WebElement group;
    //*[@class='group-item']/p

    public MWEditGroupWrapper() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
