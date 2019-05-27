package softserve.academy.modal_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import softserve.academy.actions.BaseActions;
import softserve.academy.actions.StudentsPageActions;
import softserve.academy.models.Student;
import softserve.academy.models.Utils;
import softserve.academy.pages.MWEditStudentlist;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MWEditStudentlistActions extends BaseActions {
    MWEditStudentlist modalWindowEditStudentlist = new MWEditStudentlist();


    /*
     * This method opens the window for creating the student
     */

    public MWSingleStudentActions clickCreateStudent() {
        modalWindowEditStudentlist.createStudent.click();
        return new MWSingleStudentActions();
    }

    /*
     *  This method clicks on icon of trash for deleting student
     */

    public MWwarningOfDeletionActions clickDeleteStudent(Student student) {
        Utils.getDriver().findElement(By.xpath(
                ".//tr/td[text()='" + student.getLastName() + " " + student.getName() + "']" +
                        "/..//td/i[@class='fa fa-trash deleteStudent']")).
                click();
        return new MWwarningOfDeletionActions();
    }

    /*
     *  This method clicks on icon of cogwheel for deleting student
     */

    public MWSingleStudentActions cliskButtonEditStudent(Student student) {
        Utils.getDriver().findElement(By.xpath(
                ".//tr/td[text()='" + student.getLastName() + " " + student.getName() + "']" +
                        "/..//td/i[@class='fa fa-cog fa-2x gear editStudent']")).
                click();
        return new MWSingleStudentActions();
    }

    public StudentsPageActions clickIconExit() {
        modalWindowEditStudentlist.iconExit.click();
        return new StudentsPageActions();
    }

    public MWEditStudentlistActions verifyClickChevronRight() {
        modalWindowEditStudentlist.chevronRight.click();
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadIncomingTest).isDisplayed(),
                "'tHadIncomingTest is displayed ... '");
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadEntryScore).isDisplayed(),
                "'tHadEntryScore is displayed ... '");
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadApprovedBy).isDisplayed(),
                "'tHadApprovedBy is displayed ... '");
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadName).isDisplayed(),
                "'tHadName is displayed ... '");
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadPhoto).isDisplayed(),
                "'tHadPhoto is displayed ... '");
        return this;
    }

    public MWEditStudentlistActions verifyClickChevronLeft() {
        modalWindowEditStudentlist.chevronLeft.click();
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadName).isDisplayed(),
                "'tHadName is displayed ... '");
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.tHadPhoto).isDisplayed(),
                "'tHadPhoto is displayed ... '");
        softAssert.assertTrue(waitVisible(modalWindowEditStudentlist.tHadEnglishLevel).isDisplayed(),
                "'tHadEnglishLevel is displayed ... '");
//        softAssert.assertFalse(waitVisible(modalWindowEditStudentlist.tHadIncomingTest).isDisplayed(),
//                "'tHadIncomingTest is displayed ... '");
//        softAssert.assertFalse(waitVisible(modalWindowEditStudentlist.tHadEntryScore).isDisplayed(),
//                "'tHadEntryScore is displayed ... '");
//        softAssert.assertFalse(waitVisible(modalWindowEditStudentlist.tHadApprovedBy).isDisplayed(),
//                "'tHadApprovedBy is displayed ... '");
        return this;
    }

    public List<WebElement> getStudentList() {
        return modalWindowEditStudentlist.studentList;
    }

    public MWEditStudentlistActions verifyCreateStudentIsDisplayed() {
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.createStudent).isDisplayed(),
                "'createStudent is displayed ... '");
        return this;
    }

    public MWEditStudentlistActions verifyIconExitIsDisplayed() {
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.iconExit).isDisplayed(),
                "'iconExit is displayed ... '");
        return this;
    }

    public MWEditStudentlistActions verifyChevronRightIsDisplayed() {
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.chevronRight).isDisplayed(),
                "'chevronRight is displayed ... '");
        return this;
    }

    public MWEditStudentlistActions verifyChevronLeftIsDisplayed() {
        softAssert.assertTrue(waitClickable(modalWindowEditStudentlist.chevronLeft).isDisplayed(),
                "'chevronLeft is displayed ... '");
        return this;
    }

    public MWEditStudentlistActions verifyPresenceElementsOfModalWindowEditStudentsList() {
        verifyCreateStudentIsDisplayed();
        verifyChevronRightIsDisplayed();
        verifyIconExitIsDisplayed();
        return this;
    }

    public MWEditStudentlistActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}

