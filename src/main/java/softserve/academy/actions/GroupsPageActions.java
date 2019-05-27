package softserve.academy.actions;

import com.google.common.collect.Comparators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import softserve.academy.modal_windows.SelectLocationMW;
import softserve.academy.models.EnglishLevel;
import softserve.academy.models.Location;
import softserve.academy.models.Utils;
import softserve.academy.pages.GroupsPage;
import softserve.academy.pages.TopMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static softserve.academy.models.Utils.getDriver;

public class GroupsPageActions extends BaseActions {

    private GroupsPage groupsPage = new GroupsPage();

    public GroupsPageActions selectGroup(String groupName) {
        groupsPage.groups.stream().filter(g -> g.getText().equalsIgnoreCase(groupName)).findFirst().ifPresent(WebElement::click);
        return this;
    }

    public List<String> getAllGroupsNames() {
        List<String> groupsNames = new ArrayList<>();
        for (; ; ) {
            groupsNames.addAll(groupsPage.groups.stream().map(el -> el.getText().trim()).collect(Collectors.toList()));

            WebElement rightNav = groupsPage.paginator.findElement(By.xpath("//div[@class='right-nav']"));
            if (!rightNav.getAttribute("style").equals("") || groupsPage.paginator.getAttribute("class").contains("invisible")) {
                break;
            }

            final String pageMarker = groupsPage.paginator.findElement(By.xpath("//div[@class='page-nav']")).getText();
            rightNav.click();
            wait.until((driver) -> !driver.findElement(By.xpath("//div[@class='page-nav']")).getText().equals(pageMarker));
        }

        for (; ; ) {
            WebElement leftNav = groupsPage.paginator.findElement(By.xpath("//div[@class='left-nav']"));
            if (!leftNav.getAttribute("style").equals("") || groupsPage.paginator.getAttribute("class").contains("invisible")) {
                break;
            }

            final String pageMarker = groupsPage.paginator.findElement(By.xpath("//div[@class='page-nav']")).getText();
            leftNav.click();
            wait.until((driver) -> !driver.findElement(By.xpath("//div[@class='page-nav']")).getText().equals(pageMarker));
        }

        return groupsNames;

    }

    public GroupsPageActions sortByName() {
        groupsPage.studentsInfoTable.findElement(By.xpath("thead/tr/th[1]")).click();
        return this;
    }

    public GroupsPageActions sortByEnglishLevel() {
        groupsPage.studentsInfoTable.findElement(By.xpath("thead/tr/th[3]")).click();
        return this;
    }

    public String getGroupName() {
        return groupsPage.groupName.getText().trim();
    }

    public String getGroupLocation() {
        return groupsPage.location.getText().trim();
    }

    public WebElement getStudentsInfoTable() {
        return groupsPage.studentsInfoTable;
    }

    public GroupsPageActions verifyEditGroupButtonNotDisplayed() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//button[@name='edit']"));
        softAssert.assertTrue(elements.isEmpty(),
                "Edit group button should be hidden'");
        LOGGER.log(Level.INFO, "Checked edit group button is absent.");
        return this;
    }

    public GroupsPageActions verifyEditGroupButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.editGroupButton).isDisplayed(),
                "Edit group button should be displayed clickable ... '");
        LOGGER.log(Level.INFO, "Checked edit group button is displayed.");
        return this;
    }

    public void verifyGroupsListContainsGroupsOfChosenLocation(Location chosenLocation) {
        assertTrue(getAllGroupsNames().size() > 0, "No groups displayed after double-click");
        assertTrue(getAllGroupsNames().stream().allMatch(el -> el.toUpperCase().contains(chosenLocation.getIndicator())));
        assertTrue(isLocationMWClosed());
    }

    private boolean isLocationMWClosed() {
        try {
            getDriver().findElement(By.xpath("//*[@class = 'location-wrapper']"));
        } catch (NoSuchElementException ex) {
            return true;
        }
        return false;
    }


    public void verifyGroupsListIsLeftTheSame(List<String> groupsNames) {
        assertEquals(getAllGroupsNames(), groupsNames);
    }

    public void verifyStudentsInfoTableIsSortedByName() {
        List<WebElement> names = groupsPage.studentsInfoTable.findElements(By.xpath("//tbody//tr/td[1]"));
        List<String> n = names.stream().map(WebElement::getText).filter(nam -> !nam.equals("")).collect(Collectors.toList());
        assertTrue(Comparators.isInOrder(n, String::compareTo));
    }

    public void verifyStudentsInfoTableIsSortedByEnglishLevel() {
        List<WebElement> names = groupsPage.studentsInfoTable.findElements(By.xpath("//tbody//tr/td[3]"));
        List<Integer> n = names.stream().map(WebElement::getText).filter(nam -> !nam.equals("")).map(EnglishLevel::getLevelInNum).collect(Collectors.toList());
        assertTrue(Comparators.isInOrder(n, Integer::compareTo));
    }

    public void verifyStudentsInfoTable() {
        SoftAssert sa = new SoftAssert();
        WebElement studentsInfoTable = groupsPage.studentsInfoTable;
        sa.assertEquals("Name", studentsInfoTable.findElement(By.xpath("thead/tr/th[1]")).getText().trim(), "Column 'Name' is invalid");
        sa.assertEquals("Photo", studentsInfoTable.findElement(By.xpath("thead/tr/th[2]")).getText().trim(), "Column 'Photo' is invalid");
        sa.assertEquals("English Level", studentsInfoTable.findElement(By.xpath("thead/tr/th[3]")).getText().trim(), "Column 'English Level' is invalid");
        sa.assertEquals("Incoming Test", studentsInfoTable.findElement(By.xpath("thead/tr/th[4]")).getText().trim(), "Column 'Incoming Test' is invalid");
        sa.assertEquals("Entry Score", studentsInfoTable.findElement(By.xpath("thead/tr/th[5]")).getText().trim(), "Column 'Entry Score' is invalid");
        sa.assertEquals("Approved By", studentsInfoTable.findElement(By.xpath("thead/tr/th[6]")).getText().trim(), "Column 'Approved By' is invalid");
        sa.assertAll();

    }

    public void verifyTableRecordChangesColorWhenHovered() {
        Actions actions = new Actions(getDriver());
        WebElement tableRecord = groupsPage.studentsInfoTable.findElement(By.xpath("//*[@id='main-section']//table/tbody[3]/tr"));
        actions.moveToElement(tableRecord).perform();
        assertEquals(tableRecord.getCssValue("background-color"), "rgba(222, 222, 222, 1)");
    }

    public void verifyGroupsListContainsGroupsOfChosenLocations() {
        List<String> indicators = getIndicatorsOfChosenLocations(getDriver().getCurrentUrl());
        assertTrue(isLocationMWClosed());

        long displayed = getAllGroupsNames().size();
        long valid = getAllGroupsNames().stream().filter(g -> {
            for (String indicator : indicators) {
                if (g.toUpperCase().contains(indicator)) {
                    return true;
                }
            }
            return false;
        }).count();

        assertEquals(valid, displayed, "displayed = " + displayed + " " + "valid = " + valid);

    }

    private List<String> getIndicatorsOfChosenLocations(String currentUrl) {
        Pattern pattern = Pattern.compile("/Groups/(.*)$");
        Matcher matcher = pattern.matcher(currentUrl);
        List<String> indicators = new ArrayList<>();
        if (matcher.find()) {
            String subUrl = matcher.group(1);
            List<String> cities = Arrays.asList(subUrl.split("\\+"));
            indicators = cities.stream().map(Location::get).collect(Collectors.toList());
        }
        return indicators;
    }


    public GroupsPageActions openStudentsTab() {
        groupsPage.studentsTab.click();
        return this;
    }

    public GroupsPageActions openInfoTab() {
        groupsPage.infoTab.click();
        return this;
    }

    public GroupsPageActions openScheduleTab() {
        groupsPage.scheduleTab.click();
        return this;
    }

    public GroupsPageActions openMessageTab() {
        groupsPage.messageTab.click();
        return this;
    }

    public GroupsPageActions openGroupSettings() {
        groupsPage.cogwheel.click();
        return this;
    }


    /*****************************************************************************************************************
     * igor. my methodes
     *****************************************************************************************************************/


    public GroupsPageActions verifyGroupPageState() {
        verifyURL();
        verifyGroupAndCity();
        verifyMainSectionIsEmpty();
        verifyCurrentGroupsIsDisplayed();
        verifyMyGroupsButtonIsDisplayed();
        verifyFutureGroupsIsDisplayed();
        verifyFinishedGroupsIsDisplayed();
        LOGGER.log(level, "Checked group list ....... by combined method");
        return this;
    }

    public GroupsPageActions verifyMenuButtons() {
        infoButtonIsEnabled();
        studentsButtonIsDisplayed();
        scheduleButtonIsDisplayed();
        messageButtonIsDisplayed();
        LOGGER.log(level, "Group tab buttons checked ...");
        return this;
    }

    public GroupsPageActions verifyGroupDataDisplayed() {
        verifyGroupAndCity();
        verifyMenuButtons();
        verifyTeacherAndExpertDisplayed();
        verifyStartAndFinishedDateDisplayed();
        verifyKeyDatesTableDisplayed();
        return this;
    }

    public GroupsPageActions verifyScheduleTabState() {
        verifyCalendarHeader();
        verifyCalendarTimes();
        verifyKeyDatesDisplayed();
        verifyKeyDatesList();
        return this;
    }

    private GroupsPageActions verifyKeyDatesList() {
        softAssert.assertTrue(getDriver().findElements(By.xpath("//table/tbody/tr/td")).size() > 0,
                "Key dates should have at least one empty row : ");
        return this;
    }

    public GroupsPageActions verifyCalendarHeader() {
        String[] weekCalendarDays = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        List<String> calendarHeaders = getHeadersList(By.xpath("//*/div[@class='Heading']/div"));
        softAssert.assertEquals(calendarHeaders.toArray(), weekCalendarDays, "Week calendar headers displayed wrong : ");

        return this;
    }

    public GroupsPageActions verifyCalendarTimes() {
        String[] dayTimes = {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
                "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
                "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30",
                "20:00", "20:30", "21:00"};
        List<String> dayTime = getHeadersList(By.className("HeadingCell"));

        softAssert.assertEquals(dayTime, Arrays.asList(dayTimes), "Time of a day displayed wrong at weel calendar : ");
        return this;
    }

    public GroupsPageActions verifyKeyDatesDisplayed() {
        String[] headers = {"start", "demo1", "demo2", "offering", "finish"};
        List<String> keyDatesHeaders = getHeadersList(By.xpath("//div[@class='key-dates-wrapper']/table/thead/tr/th"));
        System.out.println(keyDatesHeaders);
        softAssert.assertEquals(keyDatesHeaders.toArray(), headers,
                "Should be right key dates headers displayed : ");

        return this;
    }

    private GroupsPageActions verifyKeyDatesTableDisplayed() {

        String exampleHeaders = "start demo1 demo2 offering finish";
        String tableHeaders = getHeadersList(By.xpath("//div[@class='key-dates']/table/thead")).get(0);

        softAssert.assertEquals(tableHeaders, exampleHeaders, "keydates table displayed wrong");
        return this;
    }

    public GroupsPageActions inProgressStatusDisplayed() {

        String s = waitClickable(By.xpath("//p[@class='groupStage']")).getText();
        softAssert.assertTrue(s.contains("process") || s.contains("before"),
                "Should be displayed in-process or before-start staus for current group : ");
        return this;
    }

    public GroupsPageActions finishedStatusDisplayed() {

        String s = waitClickable(By.xpath("//p[@class='groupStage']")).getText();
        softAssert.assertTrue(s.contains("finished"),
                "Should be displayed finished staus for finished group : ");
        return this;
    }

    public GroupsPageActions verifyStartAndFinishedDateDisplayed() {
        softAssert.assertFalse(waitClickable(groupsPage.dateStart).getText().isEmpty(),
                "Start date should be dispalyed at 'Group info' : ");
        softAssert.assertFalse(waitClickable(groupsPage.dateFinish).getText().isEmpty(),
                "Finish date should be dispalyed at 'Group info' : ");
        return this;
    }

    public GroupsPageActions verifyTeacherAndExpertDisplayed() {
        softAssert.assertFalse(waitClickable(groupsPage.teacher).getText().isEmpty(),
                "Teacher name should be dispalyed at 'Group coordination' : ");
        softAssert.assertFalse(waitClickable(groupsPage.expert).getText().isEmpty(),
                "Expert name should be dispalyed at 'Group coordination' : ");
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }

    public GroupsPageActions waitPageLoaded() {
        wait.until(ExpectedConditions.urlContains("Group"));
        return this;
    }

    public GroupsPageActions verifyMainSectionIsEmpty() {
        softAssert.assertTrue(waitClickable(By.xpath("//div[@id='main-section']")).getText().isEmpty(),
                "Main section should be displayed empty ...");
        LOGGER.log(level, "Location field checked ...");
        return this;
    }

    public GroupsPageActions verifyURL() {
        softAssert.assertTrue(Utils.getDriver().getCurrentUrl().contains("Group"),
                "Not Groups page loaded. Should be 'groups' word at url ...");
        LOGGER.log(level, "current URL checked ... ");
        return this;
    }

    public GroupsPageActions verifyGroupAndCity() {
        softAssert.assertTrue(Utils.getDriver().getCurrentUrl().contains(groupsPage.location.getText()),
                "Should be the same city at URL and location place ....");
        LOGGER.log(level, "Checked city displayed wright ...");
        return this;
    }

    public GroupsPageActions verifyMyGroupsButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.myGroupsBtn).isDisplayed(),
                "'My Groups button should be displayed clickable ... '");
        LOGGER.log(level, "Checked my groups button ...");
        return this;
    }

    public GroupsPageActions verifyCurrentGroupsIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.currentGroupsFilter).isDisplayed(),
                "Current groups button should be displayed clickable ... '");
        LOGGER.log(level, "Checked current groups button ...");
        return this;
    }

    public GroupsPageActions verifyFinishedGroupsIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.finishedGroupsFilter).isDisplayed(),
                "Finished groups button should be displayed clickable ... '");
        LOGGER.log(level, "Checked finished groups button ...");
        return this;
    }

    public GroupsPageActions verifyFutureGroupsIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.plannedGroupsFilter).isDisplayed(),
                "Future groups button should be displayed clickable ... '");
        LOGGER.log(level, "Checked future groups button ...");
        return this;
    }

    public GroupsPageActions verifyGroupListNotEmpty() {
        softAssert.assertTrue(groupsPage.groups.size() > 0,
                "Should be displayed at least one group ... '");
        LOGGER.log(level, "Checked group list: displayed " + groupsPage.groups.size() + "...");
        return this;
    }

    public GroupsPageActions selectCurrentGroups() {
        waitClickable(groupsPage.currentGroupsFilter).click();
        LOGGER.log(level, "Select current group ...");
        return this;
    }

    public GroupsPageActions selectFinishedGroups() {
        waitClickable(groupsPage.finishedGroupsFilter).click();
        LOGGER.log(level, "Select finished group ...");
        return this;
    }

    public GroupsPageActions selectFutureGroups() {
        waitClickable(groupsPage.plannedGroupsFilter).click();
        LOGGER.log(level, "Select future group ...");
        return this;
    }

    public void infoButtonIsEnabled() {
        softAssert.assertTrue(waitClickable(groupsPage.infoTab).isDisplayed(),
                "Info Tab Button should be displayed at group menu : ");
    }

    public void studentsButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.studentsTab).isDisplayed(),
                "Students Tab Button should be displayed at group menu : ");
    }

    public void scheduleButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.scheduleTab).isEnabled(),
                "Schedule Tab Button should be displayed at group menu : ");
    }

    public void messageButtonIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.messageTab).isDisplayed(),
                "Message Tab Button should be displayed at group menu : ");
    }

    public GroupsPageActions selectRandomGroup() {
        int x = new Random().nextInt(groupsPage.groups.size() - 1);
        waitClickable(groupsPage.groups
                .get(x))
                .click();

        LOGGER.log(level, "Selected random group ...");
        return this;
    }

    public GroupsPageActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    private List<String> getHeadersList(By locator) {
        return getDriver().findElements(locator)
                .stream()
                .filter(webElement -> webElement.isDisplayed())
                .map(webElement -> {
                    webElement.click();
                    return webElement.getText();
                })
                .collect(Collectors.toList());
    }

    public ProfileDataSectionActions goToProfileDataSection() {
        groupsPage.photo.click();
        LOGGER.log(Level.INFO, "Wait for ProfileDataSection opened ...");
        return new ProfileDataSectionActions();
    }

    public LeftContextMenuActions goToLeftContextMenu() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.mouseMove(0, 150);
        robot.mouseMove(0, 160);
        LOGGER.log(Level.INFO, "Wait for Lef Context Menu opened ...");
        return new LeftContextMenuActions();
    }

    public CreateSchedulePageActions goToCreateSchedulePage() {
        String groupXpath = "//*[@id='left-side-bar']/div/div[2]/div[2]/div/p";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(groupXpath))).click();
        waitClickable(groupsPage.scheduleTab).click();
        groupsPage.cogwheel.click();
        return new CreateSchedulePageActions();
    }

    public GroupsPageActions waitGroupsPageLoad() {
        waitClickable(groupsPage.logo);
        LOGGER.log(Level.INFO, "Wait for MainPage loaded ...");
        return this;
    }

    public GroupsPageActions verifyUserPhotoIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.photo).isDisplayed());
        LOGGER.log(Level.INFO, "User photo is display ...");
        return this;
    }

    public GroupsPageActions selectGroupAtqc() {
        String groupXpath = "//*[@id='left-side-bar']/div/div[2]/div[2]/div/p";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(groupXpath))).click();
        return this;
    }

    public GroupsPageActions moveMouseToLocation() {
        Actions actions = new Actions(Utils.getDriver());
        actions.moveToElement(groupsPage.location);
        return this;
    }

    public SelectLocationMW openSelectLocationWindow(){
        return  new TopMenu().openSelectLocationWindow();
    }


    /*****************************************************************************************************************
     * tania's methods
     *****************************************************************************************************************/

    public GroupsPageActions verifyLogoCaesarIsDisplayed() {
        softAssert.assertTrue(waitClickable(groupsPage.logo).isDisplayed(), "logo not displayed");
        LOGGER.log(Level.INFO, "Logo is displayed...");
        return this;
    }

    public GroupsPageActions verifyAssigntToMeGroups(){
        groupsPage.myGroupsBtn.click();
        List<String>dispGroups = getAllGroupsNames();
        AdminPanelActions adminPanelActions = new AdminPanelActions();
        List<String>actGroups = adminPanelActions.returnCellTextByTabRowNames("groups","Reuta",0);
        softAssert.assertEquals(dispGroups,actGroups);
        return this;
    }
}