package softserve.academy.actions;

import softserve.academy.pages.CreateSchedulePage;

public class CreateSchedulePageActions extends BaseActions {

    CreateSchedulePage createSchedule = new CreateSchedulePage();

    public GroupsPageActions createScheduleUsingConfirmButton() {
        waitClickable(createSchedule.workWithExpertEventType).click();
        createSchedule.wednesday_16_00.click();
        createSchedule.weeklyReportEventType.click();
        createSchedule.friday_18_00.click();
        createSchedule.friday_19_00.click();
        createSchedule.saveButton.click();
        return new GroupsPageActions();
    }

    public GroupsPageActions createScheduleUsingCancelButton() {
        waitClickable(createSchedule.practiceEventType).click();
        createSchedule.monday_16_00.click();
        createSchedule.monday_17_00.click();
        createSchedule.tuesday_16_00.click();
        createSchedule.tuesday_17_00.click();
        createSchedule.thursday_16_00.click();
        createSchedule.thursday_17_00.click();
        createSchedule.friday_16_00.click();
        createSchedule.friday_17_00.click();
        createSchedule.cancelButton.click();
        return new GroupsPageActions();
    }

}