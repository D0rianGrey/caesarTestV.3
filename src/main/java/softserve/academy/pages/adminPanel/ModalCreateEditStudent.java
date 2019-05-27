package softserve.academy.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalCreateEditStudent extends ModalCreateEdit{

    @FindBy(name = "groupId")
    public WebElement fieldGroupId;
    @FindBy(name = "name")
    public WebElement fieldName;
    @FindBy(name = "lastName")
    public WebElement fieldLastName;
    @FindBy(name = "englishLevel")
    public WebElement fieldEnglishLevel;
    @FindBy(name = "CvUrl")
    public WebElement fieldCvUrl;
    @FindBy(name = "imageUrl")
    public WebElement fieldImageUrl;
    @FindBy(name = "entryScore")
    public WebElement fieldEntryScore;
    @FindBy(name = "approvedBy")
    public WebElement fieldApprovedBy;


    public ModalCreateEditStudent (){
    }
}
