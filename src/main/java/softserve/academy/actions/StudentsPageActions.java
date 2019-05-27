package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import softserve.academy.modal_windows.MWEditStudentlistActions;
import softserve.academy.modal_windows.MWeditGroupWrapperActions;
import softserve.academy.models.Student;
import softserve.academy.models.Utils;
import softserve.academy.pages.StudentsPage;
import softserve.academy.pages.TopMenu;

import java.util.List;
import java.util.stream.Collectors;

public class StudentsPageActions extends BaseActions {

    StudentsPage studentsPage = new StudentsPage();
    TopMenu topMenu = new TopMenu();
//    @FindBy(xpath = "//div[@id='top-menu']")
//    WebElement top;
//
//    @FindBy(xpath = "//div[@id='top-menu']/div/div/i[@class='fa fa-graduation-cap fa-2x']")
//    WebElement stud;

    public StudentsPageActions openStudentsPage() {
//        moveTo(top);
//        wait.until(ExpectedConditions.elementToBeClickable(stud));
//        moveTo(stud).click();
        topMenu.goToStudentsPage();
        //  waitVisible(studentsPage.filterAllGrups);
        return this;
    }

    /*
     * This method opens the window for editing a student list
     */

    public MWEditStudentlistActions editStudentList() {
        wait.until(ExpectedConditions.elementToBeClickable(studentsPage.cogwheel));
        studentsPage.cogwheel.click();
        return new MWEditStudentlistActions();
    }

    public MWeditGroupWrapperActions editStudentListAllGroup() {
       clickFilterAllGroups();
       wait.until(ExpectedConditions.elementToBeClickable(studentsPage.cogwheel));
       studentsPage.cogwheel.click();
       return new MWeditGroupWrapperActions();
    }

    public String getGroupStage() {
        return studentsPage.groupStage.getText();
    }

    /*
     *This method creates new student's record on the student list
     */

    public MWEditStudentlistActions createStudent(Student student) {
        editStudentList().clickCreateStudent().setAllStudentRequiredFields(student);
        return new MWEditStudentlistActions();
    }

    /*
     *This method deletes student's record on the student list
     */

    public MWEditStudentlistActions deleteStudent(Student student) {
    //    editStudentList().clickDeleteStudent(student).confirm();
        return new MWEditStudentlistActions();
    }

    /*
     *This method changes student's record on the student list
     */

    public MWEditStudentlistActions changeStudent(Student student) {
        editStudentList().cliskButtonEditStudent(student).setAllStudentRequiredFields(student);
        return new MWEditStudentlistActions();
    }

    /*
     *This method selects one group by name
     */

    public StudentsPageActions selectGroup(CharSequence group) {
        Utils.getDriver().findElement(By.xpath("//div[@class='small-group-view col-md-6']//p[text()='" + group + "']")).click();
        softAssert.assertEquals(Utils.getDriver().getCurrentUrl(), "http://146.148.17.49/Students/Dnipro/DP-094-MQC/list");
        return this;
    }

    public StudentsPageActions clickFilterAllGroups() {
        studentsPage.filterAllGrups.click();
        return this;
    }

    public StudentsPageActions selectCurrentGroups() {
        waitClickable(studentsPage.currentGroupsFilter).click();
        return this;
    }

    public StudentsPageActions selectFinishedGroups() {
        waitClickable(studentsPage.finishedGroupsFilter).click();
        return this;
    }

    public StudentsPageActions selectFutureGroups() {
        waitClickable(studentsPage.plannedGroupsFilter).click();
        return this;
    }

    public List<String> getAllGroupsNames() {
        return studentsPage.groups.stream().map(el -> el.getText().trim()).collect(Collectors.toList());
    }

    public StudentsPageActions verifyURL() {
        softAssert.assertTrue(Utils.getDriver().getCurrentUrl().contains("Students"),
                "Not Students page loaded. Should be 'Students' word at url ...");
        return this;
    }

    public StudentsPageActions verifyClickableFullNameClickable() {
        softAssert.assertTrue(waitClickable(studentsPage.tHeadFullName).isDisplayed(),
                "'iconExit is displayed ... '");
        return this;
    }

    public StudentsPageActions verifyEnglishLevelVisible() {
        softAssert.assertTrue(waitVisible(studentsPage.tHeadEnglishLevel).isDisplayed(),
                "'tHeadEnglishLevel is displayed ... '");
        return this;
    }

    public StudentsPageActions verifyIncomingTestClickable() {
        softAssert.assertTrue(waitClickable(studentsPage.tHeadIncomingTest).isDisplayed(),
                "'tHeadIncomingTest is displayed ... '");
        return this;
    }

    public StudentsPageActions verifyTHeadEntryScoreClickable() {
        softAssert.assertTrue(waitClickable(studentsPage.tHeadEntryScore).isDisplayed(),
                "'tHeadEntryScore is displayed ... '");
        return this;
    }

    public StudentsPageActions verifyVisibleOfStudentsTableHeaders() {
        verifyClickableFullNameClickable();
        verifyTHeadEntryScoreClickable();
        verifyEnglishLevelVisible();
        verifyIncomingTestClickable();
        return this;
    }
    public void assertAll() {
        softAssert.assertAll();
    }
}

