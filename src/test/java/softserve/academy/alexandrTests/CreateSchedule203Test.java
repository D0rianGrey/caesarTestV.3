package softserve.academy.alexandrTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

public class CreateSchedule203Test extends BaseTest102 {

    @BeforeTest
    public void logIn() {
        User user = new User("pastor", "1234");

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(user)
                .waitGroupsPageLoad();
    }

    @BeforeTest(dependsOnMethods = "logIn")
    private void createGroup() {
        new GroupsPageActions()
                .goToLeftContextMenu()
                .openCreateGroupModalWindow()
                .waitModalWindowCreateGroupLoad()
                .createAtqcGroup();
    }

    @Test
    public void createScheduleUsingConfirmButtonTest() {
        new GroupsPageActions()
                .goToCreateSchedulePage()
                .createScheduleUsingConfirmButton()
                .waitGroupsPageLoad()
                .verifyUserPhotoIsDisplayed()
                .assertAll();
    }

    @Test(dependsOnMethods = "createScheduleUsingConfirmButtonTest")
    public void createScheduleUsingCancelButtonTest() {
        new GroupsPageActions()
                .goToCreateSchedulePage()
                .createScheduleUsingCancelButton()
                .waitGroupsPageLoad()
                .verifyUserPhotoIsDisplayed()
                .assertAll();
    }

    @AfterTest
    public void deleteGroup() {
        new GroupsPageActions()
                .selectGroupAtqc()
                .goToLeftContextMenu()
                .deleteGroup();
    }

}