package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;

import static softserve.academy.models.Utils.getDriver;

public class BaseActions {

    protected static final Logger LOGGER = Logger.getLogger(BaseActions.class.getName());
    protected Level level = Level.INFO;

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 30);

    protected SoftAssert softAssert = new SoftAssert();

    protected void fillField(WebElement element, String value) {
        waitClickable(element).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        waitClickable(element).sendKeys(value);
    }

    protected void fillOptionField(WebElement element, String optionText ) {
        Select select = new Select(element);
        select.selectByVisibleText(optionText);
    }

    protected WebElement waitClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitClickable(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement moveTo(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        return element;
    }

    public void assertAll() {
        softAssert.assertAll();
    }

}