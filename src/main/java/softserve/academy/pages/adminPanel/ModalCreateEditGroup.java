package softserve.academy.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalCreateEditGroup extends ModalCreateEdit{
    @FindBy(name = "name")
    public WebElement fieldName;
    @FindBy(name = "location")
    public WebElement fieldLocation;
    @FindBy(name = "budgetOwner")
    public WebElement boxBudgetOwner;
    @FindBy(name = "direction")
    public WebElement fieldDirection;
    @FindBy(name = "startDate")
    public WebElement fieldStartDate;
    @FindBy(name = "finishDate")
    public WebElement fieldFinishDate;
    @FindBy(name = "teachers")
    public WebElement fieldTeachers;
    @FindBy(name = "experts")
    public WebElement fieldExperts;
    @FindBy(name = "stage")
    public WebElement fieldStage;

    public ModalCreateEditGroup() {
    }



}
