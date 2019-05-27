package softserve.academy.actions;

import softserve.academy.pages.GroupsPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class MainPageActions extends BaseActions {

    public MainPageActions() { }

    private GroupsPage groupPage = new GroupsPage();

    public ProfileDataSectionActions goToProfileDataSection() {
        groupPage.photo.click();
        LOGGER.log(Level.INFO, "Wait for ProfileDataSection opened ...");
        return new ProfileDataSectionActions();
    }


    public MainPageActions waitMainPageLoad() {
        waitClickable(groupPage.logo);
        LOGGER.log(Level.INFO, "Wait for MainPage loaded ...");
        return this;
    }

    public MainPageActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

}