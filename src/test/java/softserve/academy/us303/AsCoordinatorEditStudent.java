package softserve.academy.us303;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.actions.StudentsPageActions;
import softserve.academy.modal_windows.MWEditStudentlistActions;
import softserve.academy.models.User;

import static softserve.academy.models.StudentDataProvider.student303;
import static softserve.academy.models.UserDataProvider.coordinator107;
import static softserve.academy.models.UserDataProvider.teacher107;
import static softserve.academy.models.Utils.setDriver;

public class AsCoordinatorEditStudent {
    @BeforeClass(groups = {"createStudentsList"}, description = "Preconditions for test Students Page " +
            "for edit and delete student record")
    public void setUpForOrdinaryTest() {

        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User("dmytro", "1234"))
                .waitPageLoaded();

        new StudentsPageActions()
                .openStudentsPage()
                .selectGroup("DP-094-MQC")
                .editStudentList();
    }

    @Test(groups = {"login"}, description = "")
    public void teacherAssignedInLocation() {
        new MWEditStudentlistActions()
                .clickCreateStudent()
                .setAllStudentRequiredFields(student303).pause(3)
                .cliskButtonEditStudent(student303)
                .setCustomMarkIncomingTest(111)
                .clickConfirm()
                .cliskButtonEditStudent(student303)
                .verifyIncomingTestValueIsEequals(111)
                .assertAll();
    }
}
