package softserve.academy.Story_3_02;

import org.testng.annotations.*;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.actions.MainPageActions;
import softserve.academy.actions.StudentsPageActions;
import softserve.academy.models.User;
import softserve.academy.models.Utils;
import softserve.academy.pages.TopMenu;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;

public class us302NavigateAndUseStudentsPage {

    @BeforeTest(groups = {"smokeStud"}, description = "Preconditions for smoke test Students Page")
    public void setUpForOrdinaryTest() {

        setDriver()
                .manage()
                .window()
                .maximize();
    }
        @BeforeMethod(groups = {"smokeStud"})
        public void setStudPage(){
        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User("dmytro", "1234"))
                .waitPageLoaded();
    }

    @Test(groups = {"smokeStud"}, description = "User story 3-02:  Coordinator is on the “Group” page -> " +
            "Main menu -> Navigate to “Students” pageUser -> select group in group list -> Cogwheel -> " +
            "‘Edit Student list” modal window -> “Edit Student list”  ->  “Edit Student list” modal window -> " +
            "“+” for editing should open “Create/Edit student” modal window ")

    public void userNavigateStudentsPageSelectAllGroups(){
        new StudentsPageActions()
                .openStudentsPage()
                .verifyURL()
                .selectGroup("DP-094-MQC")
                .verifyVisibleOfStudentsTableHeaders()
                .editStudentList()
                .verifyPresenceElementsOfModalWindowEditStudentsList()
                .verifyChevronRightIsDisplayed()
                .verifyClickChevronRight()
                .verifyChevronLeftIsDisplayed()
                .verifyClickChevronLeft()
                .clickCreateStudent()
                .verifyPresenceElementsOfModalWindowSingleStudent()
                .clickClose()
                .clickIconExit()
                .assertAll();
    }

    @Test(groups = {"smokeStud"}, description = "User story 3-02:  Coordinator is on the “Group” page -> " +
            "Main menu -> Navigate to “Students” pageUser -> select All groups in group list -> Cogwheel -> " +
            "EditGroupWrapperActions” modal window -> Edit Student list” modal window")

    public void userNavigateStudentsPage(){
        new StudentsPageActions()
                .openStudentsPage()
                .verifyURL()
                .editStudentListAllGroup()
                .selectGroup("DP-094-MQC")
                .clickIconExit()
                .assertAll();
    }

    @AfterMethod(groups = {"smokeStud"})
    public void logOut() {
        Utils.getDriver().get(Utils.LOGOUT_URL); ;
    }
    @AfterTest(groups = {"smokeStud"})
    public void tearDown() {
        getDriver().quit() ;

    }

}
