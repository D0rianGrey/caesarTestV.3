package softserve.academy.modal_windows;

import softserve.academy.actions.BaseActions;
import softserve.academy.pages.MWWarningOfDeletion;

import static java.awt.Event.ENTER;


public class MWwarningOfDeletionActions extends BaseActions {
    public MWWarningOfDeletion modalWindowWarningOfDeletion = new MWWarningOfDeletion();


    public MWEditStudentlistActions confirm() {
        waitClickable(modalWindowWarningOfDeletion.buttonConfirm);
        modalWindowWarningOfDeletion.buttonConfirm.click();
        return new MWEditStudentlistActions();
    }

    public MWEditStudentlistActions cancel(){
        modalWindowWarningOfDeletion.buttonCancel.click();
        return new MWEditStudentlistActions();
    }

    public MWwarningOfDeletionActions verifyButtonConfirmIsClickable() {
        softAssert.assertTrue(waitClickable(modalWindowWarningOfDeletion.buttonConfirm).isDisplayed(),
                "'buttonConfirm is clickable ... '");
        return this;
    }

    public MWwarningOfDeletionActions verifyButtonCancelIsClickable() {
        softAssert.assertTrue(waitClickable(modalWindowWarningOfDeletion.buttonCancel).isDisplayed(),
                "'buttonCancel is clickable ... '");
        return this;
    }

}
