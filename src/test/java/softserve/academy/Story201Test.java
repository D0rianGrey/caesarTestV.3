package softserve.academy;

import org.testng.annotations.Test;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.actions.SchedulePageActions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Story201Test extends BaseTest{

    protected static final Logger LOGGER = Logger.getLogger(Story201Test.class.getName());
    protected Level level = Level.INFO;

    @Test(groups = {"userStory201"}, description = "User story 2-01a:  Teacher can reach schedule tab from Group page")
    public void verifyAbilityReachScheduleFromMainPAge() {

        GroupsPageActions actions = new GroupsPageActions();

        actions.waitPageLoaded()
                .verifyGroupPageState();

        actions.selectCurrentGroups()
                .verifyGroupListNotEmpty()
                .selectRandomGroup()
                .verifyGroupDataDisplayed()
                .inProgressStatusDisplayed()
                .openScheduleTab()
                .verifyScheduleTabState();

        actions.selectFinishedGroups()
                .verifyGroupListNotEmpty()
                .selectRandomGroup()
                .verifyGroupDataDisplayed()
                .finishedStatusDisplayed()
                .openScheduleTab()
                .verifyScheduleTabState()

                .assertAll();
    }

    @Test(groups = {"userStory201"}, description = "User story 2-01b:  Teacher can reach schedule from Top menu")
    public void verifyAbilityReachScheduleFromMainPAge2() {

        SchedulePageActions actions = new SchedulePageActions();

        actions.waitPageLoaded()
                .verifySchedulePageState();

        actions.clickCurrentGroupTab()
                .selectRandomGroup()
                .verifyGroupTabsDisplayed()
                .verifyMonthTabState()
                .verifyWeekTabState()
                .verifyKeyDatesTabState()
                .clickEveryGroup()
                .unClickEveryGroup()

                .assertAll();
    }
}
