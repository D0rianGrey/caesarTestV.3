package softserve.academy.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import softserve.academy.pages.BasePage;

public class ModalCreateEdit extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'submit')]")
    public WebElement submit;
    @FindBy(xpath="//*[contains(@class,'default')]")
    public WebElement close;
    @FindBy(xpath="//*[@class='modal-title']")
    public WebElement modalTitle;



    public ModalCreateEdit(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }


}

