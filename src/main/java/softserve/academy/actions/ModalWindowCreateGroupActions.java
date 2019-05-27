package softserve.academy.actions;

import softserve.academy.pages.ModalWindowCreateGroup;

import java.util.logging.Level;

public class ModalWindowCreateGroupActions extends BaseActions {

    ModalWindowCreateGroup modalWindow = new ModalWindowCreateGroup();

    public ModalWindowCreateGroupActions waitModalWindowCreateGroupLoad() {
        waitClickable(modalWindow.submitButton).isDisplayed();
        LOGGER.log(Level.INFO, "Wait for Modal Window Create Group displayed....");
        return this;
    }

    public GroupsPageActions createAtqcGroup() {
        waitModalWindowCreateGroupLoad();
        fillField(modalWindow.nameField, "Dp-101");
        modalWindow.direction.click();
        waitClickable(modalWindow.atqcDirection).click();
        waitClickable(modalWindow.addTeacher).click();
        waitClickable(modalWindow.submitAddingTeacher).click();
        waitClickable(modalWindow.addExpert).click();
        waitClickable(modalWindow.addExpertField).isDisplayed();
        fillField(modalWindow.addExpertField, "Oleksiy");
        waitClickable(modalWindow.submitAddingExpert).click();
        waitClickable(modalWindow.startDateCalendarTab).click();
        waitClickable(modalWindow.startDay).click();
        waitClickable(modalWindow.submitButton).click();
        return new GroupsPageActions();
    }

}