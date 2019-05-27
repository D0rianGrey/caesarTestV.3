package softserve.academy.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalCreateEditUser extends ModalCreateEdit{

    @FindBy(name = "firstName")
    public WebElement fieldFirstName;
    @FindBy(name = "lastName")
    public WebElement fieldLastName;
    @FindBy(name = "role")
    public WebElement fieldRole;
    @FindBy(name = "location")
    public WebElement fieldLocation;
    @FindBy(name = "photo")
    public WebElement fieldPhoto;
    @FindBy(name = "login")
    public WebElement fieldLogin;
    @FindBy(name = "password")
    public WebElement fieldPassword;

    public ModalCreateEditUser (){
    }
}
