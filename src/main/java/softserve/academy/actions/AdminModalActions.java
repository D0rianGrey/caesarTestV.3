package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import softserve.academy.models.Group;
import softserve.academy.models.Student;
import softserve.academy.models.User;
import softserve.academy.pages.adminPanel.ModalCreateEditGroup;
import softserve.academy.pages.adminPanel.ModalCreateEditStudent;
import softserve.academy.pages.adminPanel.ModalCreateEditUser;

import static softserve.academy.models.Utils.getDriver;

public class AdminModalActions extends BaseActions{
    ModalCreateEditUser modalUser;
    ModalCreateEditGroup modalGroup;
    ModalCreateEditStudent modalStudent;

    public AdminModalActions (){};

    public AdminModalActions (String ID){
        switch(ID){
            case "users":  modalUser = new ModalCreateEditUser();
                break;
            case "groups": modalGroup =new ModalCreateEditGroup();
                break;
            case "students": modalStudent=new ModalCreateEditStudent();
        }
    }

    //******************************************************************************************************************
    // To Create NEW Entity:
    public AdminPanelActions fillAllUserFieldsAndSubmit(User user){
        fillField(modalUser.fieldFirstName, user.getFirstName());
        fillField(modalUser.fieldLastName, user.getLastName());
        fillOptionField(modalUser.fieldRole, user.getRole().toString());
        fillOptionField(modalUser.fieldLocation, user.getLocation().toString());
        fillField(modalUser.fieldPhoto, user.getPhotopath());
        fillField(modalUser.fieldLogin, user.getLogin());
        fillField(modalUser.fieldPassword, user.getPassword());
        modalUser.submit.click();
        return new AdminPanelActions();
    }

    public AdminPanelActions fillAllUserFieldsAndClose(User user){
        fillField(modalUser.fieldFirstName, user.getFirstName());
        fillField(modalUser.fieldLastName, user.getLastName());
        fillOptionField(modalUser.fieldRole, user.getRole().toString());
        fillOptionField(modalUser.fieldLocation, user.getLocation().toString());
        fillField(modalUser.fieldPhoto, user.getPhotopath());
        fillField(modalUser.fieldLogin, user.getLogin());
        fillField(modalUser.fieldPassword, user.getPassword());
        modalUser.close.click();
        return new AdminPanelActions();
    }

    public AdminPanelActions fillAllGroupFieldsAndSubmit(Group group){
        fillField(modalGroup.fieldName, group.getName());
        fillOptionField(modalGroup.fieldLocation, group.getLocation1());
        if (group.isBudgetOwner()==true) {
            modalGroup.boxBudgetOwner.click();
        }
        fillOptionField(modalGroup.fieldDirection, group.getDirection1());
        fillField(modalGroup.fieldStartDate, group.getStartDate());
        fillField(modalGroup.fieldFinishDate, group.getFinishDate());
        fillField(modalGroup.fieldTeachers, group.getTeacher());
        fillField(modalGroup.fieldExperts, group.getExpert());
        fillOptionField(modalGroup.fieldStage, group.getStage1());
        modalGroup.submit.click();
        return new AdminPanelActions();
    }

    public AdminPanelActions fillAllGroupFieldsAndClose(Group group){
        fillField(modalGroup.fieldName, group.getName());
        fillOptionField(modalGroup.fieldLocation, group.getLocation().toString());
        if (group.isBudgetOwner()==true) {
            modalGroup.boxBudgetOwner.click();
        }
        fillOptionField(modalGroup.fieldDirection, group.getDirection().toString());
        fillField(modalGroup.fieldStartDate, group.getStartDate());
        fillField(modalGroup.fieldFinishDate, group.getFinishDate());
        fillField(modalGroup.fieldTeachers, group.getTeacher());
        fillField(modalGroup.fieldExperts, group.getExpert());
        fillOptionField(modalGroup.fieldStage, group.getStage().toString());
        modalGroup.close.click();
        return new AdminPanelActions();
    }

    public AdminPanelActions fillAllStudentFieldsAndSubmit(Student student){
        fillField(modalStudent.fieldGroupId, student.getGroupID());
        fillField(modalStudent.fieldName, student.getName());
        fillField(modalStudent.fieldLastName, student.getLastName());
        fillOptionField(modalStudent.fieldEnglishLevel, student.getEnglishLevel().toString());
        fillOptionField(modalStudent.fieldCvUrl, student.getCv());
        fillField(modalStudent.fieldImageUrl, student.getPhoto());
        fillField(modalStudent.fieldEntryScore, String.valueOf(student.getEntryScore()));
        fillField(modalStudent.fieldApprovedBy, student.getApprovedBy().toString());
        modalStudent.submit.click();
        return new AdminPanelActions();
    }

    public AdminPanelActions fillAllStudentFieldsAndClose(Student student){
        fillField(modalStudent.fieldGroupId, student.getGroupID());
        fillField(modalStudent.fieldName, student.getName());
        fillField(modalStudent.fieldLastName, student.getLastName());
        fillOptionField(modalStudent.fieldEnglishLevel, student.getEnglishLevel().toString());
        fillOptionField(modalStudent.fieldCvUrl, student.getCv());
        fillField(modalStudent.fieldImageUrl, student.getPhoto());
        fillField(modalStudent.fieldEntryScore, String.valueOf(student.getEntryScore()));
        fillField(modalStudent.fieldApprovedBy, student.getApprovedBy().toString());
        modalStudent.close.click();
        return new AdminPanelActions();
    }
    //********************************************************************************************************
    // To Edit existing Entity:
    public AdminModalActions editUserField(String fieldName, String textToEnter){
        WebElement field=getDriver().findElement(By.name(fieldName));
        if (!fieldName.equals("role") && !fieldName.equals("location")){
            fillField(field, textToEnter);
        } else fillOptionField(field,textToEnter);
        return this;
    }

    public AdminPanelActions submitEdit(){
        modalUser.submit.click();
        return new AdminPanelActions();
    }
    //******************************************************************************************************************
    // Assertions


    public AdminPanelActions verifyOpened() {
        boolean isOpened = false;

        if (modalUser != null) {
            isOpened = true;
        } else if (modalGroup != null) {
            isOpened = true;
        } else if (modalStudent != null) {
            isOpened = true;
        }
        softAssert.assertTrue(isOpened);

        return new AdminPanelActions();
    }

    //************************************************************************************************************


}
