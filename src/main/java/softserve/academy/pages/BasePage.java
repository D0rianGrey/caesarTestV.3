package softserve.academy.pages;

import org.openqa.selenium.WebDriver;

import static softserve.academy.models.Utils.getDriver;

abstract public class BasePage {
    protected WebDriver driver = getDriver();
}