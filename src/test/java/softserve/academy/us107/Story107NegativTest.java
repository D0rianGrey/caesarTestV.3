package softserve.academy.us107;

import org.testng.annotations.Test;
import softserve.academy.BaseTest;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.Location;

import static softserve.academy.models.UserDataProvider.coordinator107;
import static softserve.academy.models.UserDataProvider.teacher107;

public class Story107NegativTest extends BaseTest {

    @Test(groups = {"us107"}, description = "User story 1-07: Teacher can't edit group NOT assigned to him in his location")
    public void teacherNotAssignedInLocation() {
        new LoginPageActions()
                .login(teacher107)
                .selectGroup("Dp-433")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"us107"}, description = "User story 1-07: Teacher can't edit group assigned to him NOT in his location")
    public void teacherAssignedNotInLocation() {
        new LoginPageActions()
                .login(teacher107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.LVIV)
                .save()
                .selectGroup("Lv-532")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"us107"}, description = "User story 1-07: Teacher can't edit group NOT assigned to him NOT in his location")
    public void teacherNotAssignedNotInLocation() {
        new LoginPageActions()
                .login(teacher107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.LVIV)
                .save()
                .selectGroup("Kv-630")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"us107"}, description = "User story 1-07: Coordinator can't edit group assigned to him NOT in his location")
    public void coordinatorAssignedNotInLocation() {
        new LoginPageActions()
                .login(coordinator107)
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.DNIPRO)
                .save()
                .selectGroup("Dp-433")
                .verifyEditGroupButtonNotDisplayed()
                .assertAll();
    }

    @Test(groups = {"us107"}, description = "User story 1-07: Admin can't edit group NOT assigned to him NOT in his location")
    public void coordinatorNotAssignedNotInLocation() {
        new LoginPageActions()
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
