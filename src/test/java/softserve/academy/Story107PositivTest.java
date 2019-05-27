package softserve.academy;

import org.testng.annotations.Test;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.Location;

import static softserve.academy.models.UserDataProvider.*;

public class Story107PositivTest extends BaseTest {

    @Test(groups = {"login"}, description = "User story 1-07: Teacher can edit group assigned to him in his location")
    public void teacherAssignedInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(teacher107)
                .selectGroup("Dp-432")
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Coordinator can edit group assigned to him in his location")
    public void coordinatorAssignedInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(coordinator107)
                .selectGroup("Kv-632")
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Coordinator can edit group NOT assigned to him in his location")
    public void coordinatorNotAssignedInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(coordinator107)
                .selectGroup("Kv-630")
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Admin can edit group assigned to him in his location")
    public void adminAssignedInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(admin107)
                .selectGroup("Lv-531")
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Admin can edit group assigned to him NOT in his location")
    public void adminAssignedNotInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(admin107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.KYIV)
                .save()
                .selectGroup("Kv-630")  //TODO navigate to Kyiv
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Admin can edit group NOT assigned to him in his location")
    public void adminNotAssignedInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(admin107)
                .selectGroup("Lv-532")
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Admin can edit group assigned NOT to him NOT in his location")
    public void adminNotAssignedNotInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(admin107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.KYIV)
                .save()
                .selectGroup("Kv-632")  //TODO navigate to Kyiv
                .verifyEditGroupButtonIsDisplayed()
                .assertAll();
    }
}
