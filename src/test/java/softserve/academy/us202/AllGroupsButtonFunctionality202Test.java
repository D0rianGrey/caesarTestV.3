package softserve.academy.us202;

import org.testng.annotations.Test;
import softserve.academy.pages.TopMenu;
import softserve.academy.us101.BaseTest;

public class AllGroupsButtonFunctionality202Test extends BaseTest {


    @Test(groups = {"schedulePage"}, description = "test verify allGroups button ability to select all and deselect all groups")
    public void verifyAbilityToSelectAndDeselect() {


        new TopMenu()
                .goToSchedulePage()
                .clickCurrentGroupTab()
                .clickAllGroupsButton()
                .verifyStatePressedAllGroupsButton()
                .isSelectedAll()
                .clickAllGroupsButton()
                .verifyDefaultStateAllGroupsButton()
                .isDeselectedAll()
                .assertAll();

    }
}
