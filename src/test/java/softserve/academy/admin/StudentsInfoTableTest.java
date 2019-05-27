package softserve.academy.admin;

import org.testng.annotations.Test;
import softserve.academy.BaseTestK;
import softserve.academy.pages.TopMenu;

public class StudentsInfoTableTest extends BaseTestK {
    private static final String WORKING_GROUP = "Dp-149 TAQC";

    @Test
    void testStudentsTableHeadings() {
        new TopMenu()
                .goToGroupsPage()
                .selectGroup(WORKING_GROUP)
                .openStudentsTab()
                .verifyStudentsInfoTable();
    }

    @Test
    void testTableRecordChangesColorAfterHoveringTheMouse() {
        new TopMenu()
                .goToGroupsPage()
                .selectGroup(WORKING_GROUP)
                .openStudentsTab()
                .verifyTableRecordChangesColorWhenHovered();
    }

    @Test
    void testSortByName() {
        new TopMenu()
                .goToGroupsPage()
                .selectGroup(WORKING_GROUP)
                .openStudentsTab()
                .sortByName()
                .verifyStudentsInfoTableIsSortedByName();
    }

    @Test
    void testSortByEnglishLevel() {
        new TopMenu()
                .goToGroupsPage()
                .selectGroup(WORKING_GROUP)
                .openStudentsTab()
                .sortByEnglishLevel()
                .verifyStudentsInfoTableIsSortedByEnglishLevel();
    }
}
