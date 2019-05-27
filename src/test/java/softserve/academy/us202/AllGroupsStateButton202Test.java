package softserve.academy.us202;

import org.testng.annotations.Test;
import softserve.academy.pages.TopMenu;
import softserve.academy.us101.BaseTest;

public class AllGroupsStateButton202Test extends BaseTest {


    @Test(groups = {"schedulePage"}, description = "test verify conformity selected Group to Schedule")
    public void verifyStateButton() {

        new TopMenu()
                .goToSchedulePage()
                .clickCurrentGroupTab()
                .clickAllGroupsButton()
                .isSelectedAll()
                .verifyStatePressedAllGroupsButton()
                .assertAll();

    }


    @Test(groups = {"schedulePage"}, description = "test verify conformity selected Group to Schedule")
    public void verifyDefaultStateButton() {

        new TopMenu()
                .goToSchedulePage()
                .clickCurrentGroupTab()
                .clickAllGroupsButton()
                .isSelectedAll()
                .deselectGroup("DP-094-MQC")//todo random gr
                .verifyDefaultStateAllGroupsButton()
                .assertAll();

    }
}
