package softserve.academy.actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import softserve.academy.pages.AboutPage;
import softserve.academy.pages.TopMenu;

import java.util.concurrent.TimeUnit;

public class AboutPageActions extends BaseActions {

    private AboutPage aboutPage = new AboutPage();

    public AboutPageActions waitPageLoaded() {
        new TopMenu().goToAboutPage();
        wait.until(ExpectedConditions.urlContains("About"));
        LOGGER.log(level, "About page loaded ...");
        return this;
    }

    public AboutPageActions selectDevelopmentTab() {
        aboutPage.developmentAndReasearch.click();
        System.out.println("done");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.teamDoloto));
        softAssert.assertFalse(aboutPage.mainSection.getText().isEmpty());
        softAssert.assertTrue(aboutPage.fixMachine.isDisplayed());
        softAssert.assertTrue(aboutPage.floppyDrive8.isDisplayed());
        softAssert.assertTrue(aboutPage.teamDoloto.isDisplayed());
        LOGGER.log(level, "Teams on development tab are displayed ...");
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }

    public AboutPageActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
