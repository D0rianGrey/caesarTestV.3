package softserve.academy.modal_windows;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.models.Location;
import softserve.academy.models.Utils;

import java.util.List;

public class SelectLocationMW {
    @FindBy(xpath = "//*[@id='modal-window']//li[contains(@class,'location')]")
    private List<WebElement> locations;
    @FindBy(xpath = "//*[@id='modal-window']//div/button[contains(@class,'cancel')]")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id='modal-window']//div/button[contains(@class,'save')]")
    private WebElement saveButton;

    public SelectLocationMW() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Utils.getDriver(), 15), this);
    }

    public GroupsPageActions selectLocationByDoubleClick(Location location) {
        Actions action = new Actions(Utils.getDriver());
        locations.stream().filter(l -> l.getText().equals(location.getValue()))
                .findFirst().ifPresent(l -> action.doubleClick(l).perform());

        return new GroupsPageActions();
    }

    public GroupsPageActions save() {
        saveButton.click();
        return new GroupsPageActions();
    }

    public GroupsPageActions enter() {
        saveButton.sendKeys(Keys.ENTER);
        return new GroupsPageActions();
    }

    public GroupsPageActions cancel() {
        cancelButton.click();
        return new GroupsPageActions();
    }

    public GroupsPageActions escape() {
        cancelButton.sendKeys(Keys.ESCAPE);
        return new GroupsPageActions();
    }

    public SelectLocationMW selectLocation(Location location) {
        locations.stream().filter(l -> l.getText().trim().equalsIgnoreCase(location.getValue()))
                .findFirst().ifPresent(WebElement::click);
        return this;
    }

    public SelectLocationMW selectAllLocations() {
        clearChecks();
        locations.forEach(WebElement::click);
        return this;
    }

    public SelectLocationMW clearChecks() {
        locations.forEach(l -> {
            if (l.getAttribute("class").contains("active-location")) {
                l.click();
            }
        });
        return this;
    }
}
