package softserve.academy.admin;

import org.testng.annotations.Test;
import softserve.academy.BaseTestK;
import softserve.academy.models.Location;
import softserve.academy.pages.TopMenu;

import java.util.List;

public class SelectLocationModalWindowTest extends BaseTestK {
    /**
     * BUG!
     */
    @Test(priority = 3)
    //@Parameters({"location1", "locationIndicator1"})
    void displayGroupsOfChosenLocationByDoubleClick(/*String city, String groupNameCityIndicator*/) {
        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocationByDoubleClick(Location.LVIV)
                .verifyGroupsListContainsGroupsOfChosenLocation(Location.LVIV);

    }


    @Test(priority = 1)
        //@Parameters({"location1", "location2", "location3", "locationIndicator1", "locationIndicator2", "locationIndicator3"})
    void displayGroupsOfChosenLocationsByClickingConfirmButton(/*String city1, String city2, String city3,
                                                               String groupNameIndicatorForCity1, String groupNameIndicatorForCity2, String groupNameIndicatorForCity3*/) {

        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.DNIPRO)
                .selectLocation(Location.SOFIA)
                .save()
                .verifyGroupsListContainsGroupsOfChosenLocations();
    }

    /**
     * BUG! If paginator is on 2d page
     */
    @Test(priority = 5)
    void displayGroupsOfChosenLocationsWithPaginator(/*String city1, String city2, String city3,
                                                               String groupNameIndicatorForCity1, String groupNameIndicatorForCity2, String groupNameIndicatorForCity3*/) {

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

    @Test(priority = 4)
        //@Parameters({"location1", "location2", "location3", "locationIndicator1", "locationIndicator2", "locationIndicator3"})
    void displayGroupsOfChosenLocationsByEnterPress(/*String city1, String city2, String city3,
                                                    String groupNameIndicatorForCity1, String groupNameIndicatorForCity2, String groupNameIndicatorForCity3*/) {
        new TopMenu()
                .openSelectLocationWindow()
                .clearChecks()
                .selectLocation(Location.IVANO_FRANKIVSK)
                .selectLocation(Location.DNIPRO)
                .selectLocation(Location.SOFIA)
                .enter()
                .verifyGroupsListContainsGroupsOfChosenLocations();
    }

    @Test(priority = 2)
        //@Parameters({"location2"})
    void cancelChangesWithCancelButton(/*String city*/) {

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
    @Test(priority = 6)
    //@Parameters({"location2"})
    void cancelChangesWithEscPress(/*String city*/) {

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
