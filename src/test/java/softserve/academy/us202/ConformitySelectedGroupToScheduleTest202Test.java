package softserve.academy.us202;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import softserve.academy.pages.TopMenu;
import softserve.academy.us101.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class ConformitySelectedGroupToScheduleTest202Test extends BaseTest {


    List<String> expectedRows;

    @BeforeTest(groups = {"schedulePage"}, description = "test verify conformity selected Group to Activities")
    public void createExpectedData() {
        expectedRows = new ArrayList<>();
        expectedRows.add("MQC Practice D. Petin 305");
        expectedRows.add("Weekly Report D. Petin 309");
        expectedRows.add("MQC Lecture D. Petin 305");
        expectedRows.add("Weekly Report D. Petin 309");
        expectedRows.add("Expert Meeting N. Varenko 309");
    }

    @Test(groups = {"schedulePage"}, description = "test verify conformity selected Group to Schedule")
    public void verifySchedule() {
        String expectedRow = "DP-094-MQC 02/01/2016 02/22/2016 03/14/2016 04/04/2016 04/25/2016";

        new TopMenu()
                .goToSchedulePage()
                .selectGroup("DP-094-MQC")
                .clickKeyDateTab()
                .verifyRowOfKeyDates(expectedRow)
                .assertAll();

    }

    @Test(groups = {"schedulePage"}, description = "test verify conformity selected Group to Activities")
    public void verifyActivities() {


        new TopMenu()
                .goToSchedulePage()
                .selectGroup("DP-094-MQC")
                .clickWeekTab()
                .verifyActivities(expectedRows)
                .assertAll();


    }
}
