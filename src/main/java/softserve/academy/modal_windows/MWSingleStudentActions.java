package softserve.academy.modal_windows;

import org.openqa.selenium.support.ui.ExpectedConditions;
import softserve.academy.actions.BaseActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import softserve.academy.models.Student;
import softserve.academy.pages.MWSingleStudent;


public class MWSingleStudentActions extends BaseActions {
    MWSingleStudent modalWindowSingleStudent = new MWSingleStudent();

    /*
     *This method fills the fields of the student record
     */

    public MWEditStudentlistActions setAllStudentRequiredFields(Student student) {

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-window']//*[contains(@class,'dropZone form-inline form-wrapper container')]")));
        wait.until(ExpectedConditions.elementToBeClickable(modalWindowSingleStudent.fieldFirstName)).click();
        modalWindowSingleStudent.fieldFirstName.clear();
        modalWindowSingleStudent.fieldFirstName.sendKeys(String.valueOf(student.getName()));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-window']//*[contains(@class,'dropZone form-inline form-wrapper container')]")));
        wait.until(ExpectedConditions.elementToBeClickable(modalWindowSingleStudent.fieldLastName)).click();
        modalWindowSingleStudent.fieldLastName.clear();
        modalWindowSingleStudent.fieldLastName.sendKeys(String.valueOf(student.getLastName()));
//        wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.elementToBeClickable(fieldMarkIncomingTest)).click();
        modalWindowSingleStudent.fieldMarkIncomingTest.clear();
        modalWindowSingleStudent.fieldMarkIncomingTest.sendKeys(String.valueOf(student.getIncomingTest()));
//        wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.elementToBeClickable(fieldMarkEntryScore)).click();
        modalWindowSingleStudent.fieldMarkEntryScore.clear();
        modalWindowSingleStudent.fieldMarkEntryScore.sendKeys(String.valueOf(student.getEntryScore()));
        modalWindowSingleStudent.confirm.click();
//        setFieldFirstName(student);
//        setFieldLastName(student);
//        setMarkIncomingTest(student);
//        setMarkEntryScore(student);
        return new MWEditStudentlistActions();
    }

    public MWSingleStudentActions setFieldFirstName(Student student) {
//        fillField(modalWindowSingleStudent.fieldFirstName, student.getName());
        modalWindowSingleStudent.fieldFirstName.clear();
        modalWindowSingleStudent.fieldFirstName.sendKeys(student.getName());
        return this;
    }

    public MWSingleStudentActions setFieldLastName(Student student) {
//        fillField(modalWindowSingleStudent.fieldLastName, student.getLastName());
        modalWindowSingleStudent.fieldLastName.clear();
        modalWindowSingleStudent.fieldLastName.sendKeys(student.getLastName());
        return this;
    }

    public Select getSelect(WebElement element) {
        modalWindowSingleStudent.select = new Select(element);
        return modalWindowSingleStudent.select;
    }

    public MWSingleStudentActions setFieldEnglishLevel(Student student) {
        getSelect(modalWindowSingleStudent.fieldEnglishLevel);
        modalWindowSingleStudent.select.selectByVisibleText(String.valueOf(student.getEnglishLevel()));
        return this;
    }

    public MWSingleStudentActions setCv(Student student) {
        modalWindowSingleStudent.cv.sendKeys(student.getCv());
        return this;
    }

    public MWSingleStudentActions setMarkIncomingTest(Student student) {
//        fillField(modalWindowSingleStudent.fieldMarkIncomingTest, String.valueOf(student.getIncomingTest()));
        modalWindowSingleStudent.fieldMarkIncomingTest.clear();
        modalWindowSingleStudent.fieldMarkIncomingTest.sendKeys(String.valueOf(student.getIncomingTest()));
        return this;
    }

    public MWSingleStudentActions setMarkEntryScore(Student student) {
//        fillField(modalWindowSingleStudent.fieldMarkEntryScore, String.valueOf(student.getEntryScore()));
        modalWindowSingleStudent.fieldMarkEntryScore.clear();
        modalWindowSingleStudent.fieldMarkEntryScore.sendKeys(String.valueOf(student.getEntryScore()));
        return this;
    }

    public MWSingleStudentActions setApprovedBy(Student student) {
        getSelect(modalWindowSingleStudent.approvedBy);
        modalWindowSingleStudent.select.selectByVisibleText(String.valueOf(student.getApprovedBy()));
        return this;
    }

    public MWSingleStudentActions setBrowsePhoto(Student student) {
        modalWindowSingleStudent.browsePhoto.sendKeys(student.getPhoto());
        return this;
    }

    //******** Custom Setters *************//
    public MWSingleStudentActions setCustomMarkIncomingTest(Integer incomeTestValue) {
        modalWindowSingleStudent.fieldMarkIncomingTest.clear();
        modalWindowSingleStudent.fieldMarkIncomingTest.sendKeys(String.valueOf(incomeTestValue));
        return this;
    }

    public MWEditStudentlistActions clickConfirm() {
        modalWindowSingleStudent.confirm.click();
        return new MWEditStudentlistActions();
    }

    public MWEditStudentlistActions clickClose() {
        modalWindowSingleStudent.close.click();
        return new MWEditStudentlistActions();
    }

    public MWSingleStudentActions verifyTextBoxGroupIsDisabled() {
        softAssert.assertFalse(waitVisible(modalWindowSingleStudent.textBoxGroup).isEnabled(),
                "'fieldFirstName is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyFieldFirstNameIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.fieldFirstName).isDisplayed(),
                "'fieldFirstName is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyFieldLastNameIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.fieldLastName).isDisplayed(),
                "'fieldLastName is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyEnglishLevelIsDisplayed() {
        softAssert.assertEquals(waitVisible(modalWindowSingleStudent.fieldEnglishLevel).isDisplayed(),
                "'fieldEnglishLevel is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyCvIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.cv).isDisplayed(),
                "'cv is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyFieldMarkIncomingTestIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.fieldMarkIncomingTest).isDisplayed(),
                "'fieldMarkIncomingTest is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyFieldMarkEntryScoreIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.fieldMarkEntryScore).isDisplayed(),
                "'fieldMarkEntryScore is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyApprovedByIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.approvedBy).isDisplayed(),
                "'approvedBy is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyBrowsePhotoIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.browsePhoto).isDisplayed(),
                "'browsePhoto is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyConfirmIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.confirm).isDisplayed(),
                "'confirm is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyCloseIsDisplayed() {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.close).isDisplayed(),
                "'close is displayed ... '");
        return this;
    }

    public MWSingleStudentActions verifyPresenceElementsOfModalWindowSingleStudent(){
        verifyTextBoxGroupIsDisabled();
        verifyFieldFirstNameIsDisplayed();
        verifyFieldLastNameIsDisplayed();
//        verifyEnglishLevelIsDisplayed();
        verifyApprovedByIsDisplayed();
//        verifyBrowsePhotoIsDisplayed();
//        verifyCvIsDisplayed();
        verifyFieldMarkIncomingTestIsDisplayed();
        verifyFieldMarkEntryScoreIsDisplayed();
        verifyConfirmIsDisplayed();
        verifyCloseIsDisplayed();
        return this;
    }

    //******* Verify student fields values *********//
    public MWSingleStudentActions verifyIncomingTestValueIsEequals(int value) {
        softAssert.assertTrue(waitVisible(modalWindowSingleStudent.fieldMarkIncomingTest)
                        .getAttribute("value").equals(String.valueOf(value)), "IncomingTest value didn't match");
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}

