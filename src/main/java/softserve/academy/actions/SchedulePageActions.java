package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import softserve.academy.pages.SchedulePage;
import softserve.academy.pages.TopMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static softserve.academy.models.Utils.getDriver;

public class SchedulePageActions extends BaseActions {


    private SchedulePage schedulePage = new SchedulePage();

    public SchedulePageActions(){
    }


	/*public SchedulePageActions goToSchedulePage() {
		topMenu.goToSchedulePage();
		LOGGER.log(Level.INFO, "Go to Shedule page ...");
		return this;
	}*/


    public SchedulePageActions verifyRowsOfKeyDates(List<String> expectedRows) {

        List<String> linesOfKeyDatesTable = new ArrayList<>();

        for (WebElement keyDate : schedulePage.keyDates) {
            LOGGER.info(keyDate.getText());
            if (!keyDate.getText().isEmpty()) {
                linesOfKeyDatesTable.add(keyDate.getText());
            }
        }
        softAssert.assertTrue(linesOfKeyDatesTable.containsAll(expectedRows));
        return this;

    }

    public SchedulePageActions verifyRowOfKeyDates(String expectedRows) {

        List<String> linesOfKeyDatesTable = new ArrayList<>();

        for (WebElement keyDate : schedulePage.keyDates) {
            LOGGER.info(keyDate.getText());
            if (!keyDate.getText().isEmpty()) {
                linesOfKeyDatesTable.add(keyDate.getText());
            }
        }
        softAssert.assertTrue(linesOfKeyDatesTable.contains(expectedRows));
        return this;

    }
    public SchedulePageActions verifyActivities(List<String> expectedRows) {

        List<String> activitiesText = new ArrayList<>();
        for (WebElement activity : schedulePage.activities) {
            //	LOGGER.info(activity.getText());
            activitiesText.add(activity.getText().replaceAll("\n", " "));

        }

        softAssert.assertTrue(activitiesText.containsAll(expectedRows));
        return this;
    }


	/*public List<String> getRowsOfKeyDatesTable() {

		List<String> linesOfKeyDatesTable = new ArrayList<>();
		for (WebElement keyDate : schedulePage.keyDates) {
			LOGGER.info(keyDate.getText());
			if (!keyDate.getText().isEmpty()) {
				linesOfKeyDatesTable.add(keyDate.getText());
			}
		}
		return linesOfKeyDatesTable;

	}*/


    /*public List<String> getActivities() {

        List<String> activitiesText = new ArrayList<>();
        for (WebElement activity : activities) {
            //	LOGGER.info(activity.getText());
            activitiesText.add(activity.getText().replaceAll("\n", " "));

        }

        return activitiesText;
    }
*/
    public SchedulePageActions selectGroup(String groupName) {

        for (WebElement group : schedulePage.groups) {

            if (group.getText().equalsIgnoreCase(groupName) && !isSelected(group)) {
                LOGGER.info(group.getText());
                waitClickable(group).click();
                //group.click();
            } else {
                break;
            }
        }
        return this;
    }

    public SchedulePageActions verifyСounterOfSelectedGroups() {


        String actualStringOfNumber = schedulePage.groupName.getText().replaceAll("[^0-9]", "");

        int actualQuantity = Integer.parseInt(actualStringOfNumber);
        LOGGER.info(actualQuantity + " actualQuantity from groupname ");
        int quantityOfSelectedGroups = 0;
        for (WebElement group : schedulePage.groups) {
            //log.info(group.getText());
            if (isSelected(group)) {
                quantityOfSelectedGroups += 1;
            }
        }
        softAssert.assertEquals(quantityOfSelectedGroups, actualQuantity);

        return this;

    }


    public SchedulePageActions deselectGroup(String groupName) {

        for (WebElement group : schedulePage.groups) {
            //log.info(group.getText());
            if (group.getText().equalsIgnoreCase(groupName) && isSelected(group)) {
                group.click();
            } else {
                break;
            }
        }
        return this;
    }


    public SchedulePageActions isSelectedAll() {

        for (WebElement group : schedulePage.groups) {
            //LOGGER.info(group.getText());
            softAssert.assertTrue(isSelected(group), "group not selected");
        }

        return this;
    }

    public SchedulePageActions isDeselectedAll() {

        for (WebElement group : schedulePage.groups) {
            //LOGGER.info(!isSelected(group)+" ff");

            softAssert.assertFalse(isSelected(group), "group selected");
        }

        return this;
    }

    private boolean isSelected(WebElement group) {
        //LOGGER.info(group.getAttribute("class").contains("chosen")+" atr");
        return group.getAttribute("class").contains("chosen");

    }


    public SchedulePageActions verifyActualRows(int expectRows) {

        softAssert.assertEquals(schedulePage.keyDates.size(), expectRows);
        return this;
    }


    public SchedulePageActions verifyRowsNotEmpty() {

        for (WebElement keyDate : schedulePage.keyDates) {
            LOGGER.info(keyDate.getText());

            softAssert.assertTrue(keyDate.getText().isEmpty());

        }
        return this;
    }

    public SchedulePageActions verifyDefaultStateAllGroupsButton() {
        //LOGGER.info(schedulePage.allGroupsButton.getAttribute("class").contains("pressed")+"btn def");
        softAssert.assertFalse(schedulePage.allGroupsButton.getAttribute("class").contains("pressed"),
                "button's clicked state");

		return this;
	}

    public SchedulePageActions verifyStatePressedAllGroupsButton() {
        //LOGGER.info(schedulePage.allGroupsButton.getAttribute("class").contains("pressed")+"btn clicked");
        softAssert.assertTrue(schedulePage.allGroupsButton.getAttribute("class").contains("pressed"),
                "button not clicked state");

        return this;
    }


    public SchedulePageActions clickKeyDateTab() {
        waitClickable(schedulePage.keyDatesTab).click();
        return this;
    }


    public SchedulePageActions clickWeekTab() {
        waitClickable(schedulePage.weekTab).click();
        return this;
    }


    public SchedulePageActions clickEndedGroupTab() {
        waitClickable(schedulePage.finishedGroupsFilter).click();
        return this;

    }

    public SchedulePageActions clickCurrentGroupTab() {
        waitClickable(schedulePage.currentGroupsFilter).click();
        return this;
    }

    public SchedulePageActions clickFutureGroupTab() {
        waitClickable(schedulePage.plannedGroupsFilter).click();
        return this;
    }

    public SchedulePageActions clickAllGroupsButton() {
        waitClickable(schedulePage.allGroupsButton).click();
        LOGGER.log(Level.INFO, "all groups button clicked ...");
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }
    /********************************************************************************
     * Igor. My methods below
     ********************************************************************************/
    public SchedulePageActions verifySchedulePageState(){
        verifyGroupAndCity();
        verifyMainSectionIsEmpty();
        verifyGroupListNotEmpty();
        verifyAllGroupsButton();
        verifyMyGroupsButton();

        LOGGER.log(level, "Default schedule pge state checked ... ");
        return this;
    }

    public SchedulePageActions verifyGroupTabsDisplayed() {
        softAssert.assertTrue(waitClickable(By.className("monthBtn")).getAttribute("class").contains("active"),
                "Month tab should be displayed selected : ");
        softAssert.assertTrue(waitClickable(schedulePage.weekTab).isDisplayed(),
                "Week tab should be displayed : ");
        softAssert.assertTrue(waitClickable(schedulePage.keyDatesTab).isDisplayed(),
                "Keydates tab should be displayed: ");

        LOGGER.log(level, "Default group state checked ....");
        return this;
    }

    public SchedulePageActions verifyMonthTabState() {
        cogWheelButtonIsDisplayed();
        previousMonthShifterIsDisplayed();
        nextMonthShifterIsDisplayed();

        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        List<String> list = schedulePage.calendarHeaders
                .stream()
                .filter(webElement -> webElement.isDisplayed())
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());

        softAssert.assertFalse(schedulePage.monthName.getText().isEmpty(), "Month name isn't displayed : ");
        softAssert.assertFalse(schedulePage.groupName.getText().isEmpty(), "Group name eisn't displayed : ");
        softAssert.assertEquals(list.toArray(), daysOfWeek, "Calendar headers displayed wrong : ");
        softAssert.assertTrue(schedulePage.calendarLines.size() == 6, "Calendar should have 5 lines : ");

        LOGGER.log(level, "Month tab checked ...");
        return this;
    }

    public SchedulePageActions verifyCalendarHeader() {
        String[] weekCalendarDays = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        List<String> calendarHeaders = getHeadersList(By.xpath("//*/div[@class='Heading']/div"));
        softAssert.assertEquals(calendarHeaders.toArray(), weekCalendarDays, "Week calendar headers displayed wrong : ");

        return this;
    }

    public SchedulePageActions verifyCalendarTimes() {
        String[] dayTimes = {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
                "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
                "16:30", "17:00", "17:30", "18:00", "18:30", "19:00" , "19:30",
                "20:00", "20:30", "21:00"};
        List<String> dayTime = getHeadersList(By.className("HeadingCell"));

        softAssert.assertEquals(dayTime, Arrays.asList(dayTimes), "Time of a day displayed wrong at weel calendar : ");
        return this;
    }

    public SchedulePageActions verifyWeekTabState() {
        waitClickable(schedulePage.weekTab).click();

        verifyCalendarHeader();
        verifyCalendarTimes();
        cogWheelButtonIsDisplayed();

        LOGGER.log(level, "Week tab checked ...");
        return this;
    }

    public SchedulePageActions verifyKeyDatesTabState() {
        waitClickable(schedulePage.keyDatesTab).click();

        String keyDatesTableHeaders = "Group Start Demo1 Demo2 Offering Finish";
        String headers = schedulePage.keyDatesHeaders.get(0).getText();

        softAssert.assertEquals(keyDatesTableHeaders, headers, "Keydates headers displayed wrong : ");
        cogWheelButtonIsDisplayed();

        LOGGER.log(level, "Key dates tab displayed ...");
        return this;
    }

    public SchedulePageActions waitPageLoaded() {
        new TopMenu().schedule.click();
        wait.until(ExpectedConditions.urlContains("Schedule"));
        LOGGER.log(level, "Schedule page loaded ...");
        return this;
    }

    public SchedulePageActions selectRandomGroup() {
        int x = new Random().nextInt(schedulePage.groups.size() - 1);
        waitClickable(schedulePage.groups
                .get(x))
                .click();

        LOGGER.log(level, "Selected random group ...");
        return this;
    }

    public SchedulePageActions verifyGroupListNotEmpty() {
        softAssert.assertTrue(schedulePage.groups.size() > 0,
                "Should be displayed at least one group ... '");
        LOGGER.log(level, "Checked group list: displayed " + schedulePage.groups.size() + "...");
        return this;
    }

    public SchedulePageActions verifyGroupAndCity() {
        softAssert.assertTrue(getDriver().getCurrentUrl().contains(schedulePage.location.getText()),
                "Should be the same city at URL and location place ....");
        LOGGER.log(level, "Checked city displayed wright ...");
        return this;
    }

    public SchedulePageActions verifyAllGroupsButton() {
        softAssert.assertTrue(waitClickable(schedulePage.allGroupsButton).isDisplayed(),
                "Should be displayed 'All Groups' button : ");
        return this;
    }

    public SchedulePageActions verifyMyGroupsButton() {
        softAssert.assertTrue(waitClickable(schedulePage.myGroupsBtn).isDisplayed(),
                "Should be displayed 'All Groups' button : ");
        return this;
    }

    public SchedulePageActions verifyMainSectionIsEmpty(){
        softAssert.assertTrue(waitClickable(By.xpath("//div[@id='main-section']")).getText().isEmpty(),
                "Main section should be displayed empty ...");
        LOGGER.log(level, "Main section empty field checked ...");
        return this;
    }

    public SchedulePageActions cogWheelButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(schedulePage.cogwheel).isDisplayed(),
                "Cog wheel button should be displayed : ");
        return this;
    }

    public SchedulePageActions previousMonthShifterIsDisplayed() {
        softAssert.assertTrue(schedulePage.prevMonthShifter.isDisplayed(),
                "Previous month tab should be displayed : ");
        return this;
    }

    public SchedulePageActions nextMonthShifterIsDisplayed() {
        softAssert.assertTrue(schedulePage.nextMonthShifter.isDisplayed(),
                "Next month tab should be displayed : ");
        return this;
    }

    public SchedulePageActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    private  List<String> getHeadersList(By locator) {
        return getDriver().findElements(locator)
                .stream()
                .filter(webElement -> webElement.isDisplayed())
                .map(webElement -> { webElement.click(); return webElement.getText();})
                .collect(Collectors.toList());
    }


    public SchedulePageActions clickEveryGroup() {

        schedulePage.groups.stream().forEach(element -> {if (!element.getAttribute("class").contains("chosen")) element.click();});
        softAssert.assertEquals(schedulePage.groups.size(), schedulePage.keyDatesLines.size(),
                "Should be displayed equal count for clicked groups : ");
        return this;
    }

    public SchedulePageActions unClickEveryGroup() {

        schedulePage.groups.stream().forEach(WebElement::click);
        softAssert.assertTrue(schedulePage.keyDatesLines.size() == 1,
                "Should be displayed 1 group left : ");
        return this;
    }


}