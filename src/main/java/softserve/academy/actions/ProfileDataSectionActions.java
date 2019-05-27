package softserve.academy.actions;

import softserve.academy.pages.ProfileDataSection;

import java.util.logging.Level;

public class ProfileDataSectionActions extends BaseActions {

    private ProfileDataSection profileDataSection = new ProfileDataSection();

    public ProfileDataSectionActions verifyLogoutButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(profileDataSection.logoutButton).isDisplayed());
        LOGGER.log(Level.INFO, "User photo is display ...");
        return this;
    }

    public ProfileDataSectionActions waitProfileDataSectionLoad() {
        waitClickable(profileDataSection.logoutButton);
        LOGGER.log(Level.INFO, "Wait for profile data section displayed....");
        return this;
    }

    public LoginPageActions clickLogoutButton() {
        waitClickable(profileDataSection.logoutButton).click();
        return new LoginPageActions();
    }

}