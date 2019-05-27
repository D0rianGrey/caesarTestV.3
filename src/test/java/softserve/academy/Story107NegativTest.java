package softserve.academy;

import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.Location;
import softserve.academy.models.User;

import static softserve.academy.models.UserDataProvider.*;

public class Story107NegativTest extends BaseTest {

    @Test(groups = {"login"}, description = "User story 1-07: Teacher can't edit group NOT assigned to him in his location")
    public void teacherNotAssignedInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(teacher107)
                .selectGroup("Dp-433")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Teacher can't edit group assigned to him NOT in his location")
    public void teacherAssignedNotInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(teacher107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.LVIV)
                .save()
                .selectGroup("Lv-532")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Teacher can't edit group NOT assigned to him NOT in his location")
    public void teacherNotAssignedNotInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(teacher107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.LVIV)
                .save()
                .selectGroup("Kv-630")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Coordinator can't edit group assigned to him NOT in his location")
    public void coordinatorAssignedNotInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(coordinator107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.DNIPRO)
                .save()
                .selectGroup("Dp-433")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"login"}, description = "User story 1-07: Admin can't edit group NOT assigned to him NOT in his location")
    public void coordinatorNotAssignedNotInLocation() {
        new LoginPageActions()
                .openLoginPage()
                .login(coordinator107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.LVIV)
                .save()
                .selectGroup("Lv-531")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }
}
