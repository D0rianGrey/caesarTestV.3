package softserve.academy;

import org.testng.annotations.Test;
import softserve.academy.actions.AboutPageActions;

public class AboutPageTest extends BaseTest {

    @Test(enabled = true, groups = {"about"}, description = "about page")
    public void selectTabTest() {
        AboutPageActions actions = new AboutPageActions();
        actions.waitPageLoaded()
                .selectDevelopmentTab()
                .assertAll();
    }
}
