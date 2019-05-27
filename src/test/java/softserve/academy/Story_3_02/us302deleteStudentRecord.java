package softserve.academy.Story_3_02;

import org.testng.annotations.*;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.actions.StudentsPageActions;
import softserve.academy.modal_windows.MWEditStudentlistActions;
import softserve.academy.models.Student;
import softserve.academy.models.User;

import static softserve.academy.models.Utils.setDriver;

public class us302deleteStudentRecord {
    @BeforeClass(groups = {"deleteStudentsList"}, description = "Preconditions for test Students Page " +
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
                .selectGroup("DP-094-MQC");

    }

    @DataProvider(name = "provideStudentData")
    public Object[][] groupStudents() {
        return new Object[][]{
         //       {new Student("Irina", "Svitlenko", 0, 2)},
                {new Student("Maksim", "Nikitghenko", 1, 3)},
                {new Student("Alina", "Titarenko", 100, 2)},
                {new Student("Tetyana", "Vasilenko", 200, 3)},
                {new Student("Dmitro", "Zinchenko", 250, 4)},
                {new Student("Oksana", "Zelenko", 300, 5)},
                {new Student("Evgen", "Franchuk", 350, 4)},
                {new Student("Pavlo", "Visochin", 400, 3)},
                {new Student("Vladislava", "Dziga", 450, 2)},
         //       {new Student("Pak", "Tok", 500, 2)},
        };
    }

    @Test(dataProvider = "provideStudentData", groups = {"deleteStudentsList"}, description = "User story 3-02:  Coordinator is on the “Group” page -> " +
            "Main menu -> Navigate to “Students” pageUser -> select group in group list -> Cogwheel -> " +
            "‘Edit Student list” modal window -> “Edit Student list”  ->  “Edit Student list” modal window -> " +
            "“+” for editing should open “Create/Edit student” modal window -> creating sdudents")
    public void deleteStudents(Student student) {
        new StudentsPageActions()
                .editStudentList()
                .clickDeleteStudent(student)
                .cancel()
                .clickIconExit()
                .assertAll();
    }

    @AfterMethod(groups = {"deleteStudentsList"})
    public void closeMWEditStudentList() {
        new MWEditStudentlistActions()
                .clickIconExit();
    }
}
