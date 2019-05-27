package softserve.academy.teacher;

import org.testng.annotations.Test;
import softserve.academy.BaseTestK;
import softserve.academy.models.Location;
import softserve.academy.pages.TopMenu;

import java.util.List;

public class SelectLocationModalWindowTest extends BaseTestK {
    /**
     * BUG!
     */
    @Test
    void displayGroupsOfChosenLocationByDoubleClick() {
        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocationByDoubleClick(Location.LVIV)
                .verifyGroupsListContainsGroupsOfChosenLocation(Location.LVIV);

    }


    @Test
    void displayGroupsOfChosenLocationsByClickingConfirmButton() {

        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.DNIPRO)
                .selectLocation(Location.SOFIA)
                .save()
                .verifyGroupsListContainsGroupsOfChosenLocations();
    }

    @Test
    void displayGroupsOfChosenLocationsWithPaginator() {

        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.DNIPRO)
                .selectLocation(Location.SOFIA)
                .selectLocation(Location.LVIV)
                .selectLocation(Location.RIVNE)
                .selectLocation(Location.KYIV)
                .selectLocation(Location.CHERNIVTSY)
                .save()
                .verifyGroupsListContainsGroupsOfChosenLocations();
    }

    @Test
    void displayGroupsOfChosenLocationsByEnterPress() {
        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.DNIPRO)
                .selectLocation(Location.SOFIA)
                .enter()
                .verifyGroupsListContainsGroupsOfChosenLocations();
    }

    @Test
    void cancelChangesWithCancelButton() {

        TopMenu topMenu = new TopMenu();
        List<String> groupsBeforeLocationChoose = topMenu.goToGroupsPage().getAllGroupsNames();
        topMenu
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.CHERNIVTSY)
                .selectLocation(Location.KYIV)
                .selectLocation(Location.SOFIA)
                .selectLocation(Location.RIVNE)
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.DNIPRO)
                .selectLocation(Location.LVIV)
                .cancel()
                .verifyGroupsListIsLeftTheSame(groupsBeforeLocationChoose);
    }

    /**
     * BUG!
     */
    @Test
    void cancelChangesWithEscPress() {

        TopMenu topMenu = new TopMenu();
        List<String> groupsBeforeLocationChoose = topMenu.goToGroupsPage().getAllGroupsNames();
        topMenu
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.CHERNIVTSY)
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.LVIV)
                .escape()
                .verifyGroupsListIsLeftTheSame(groupsBeforeLocationChoose);
    }

}
