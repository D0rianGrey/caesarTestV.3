package softserve.academy.AdminTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import softserve.academy.actions.AdminPanelActions;
import softserve.academy.models.User;
import softserve.academy.models.UserDataProvider;
@Test(groups = {"admin", "funcCreate"})
public class AdminCreateTest extends AdminBaseTest{


    @Test(priority = 1, dataProvider = "UserDataProvider")
    public void createUsers(User user){
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .openCreateModal()
                .fillAllUserFieldsAndSubmit(user)
                .verifyRowWithNamePresentInTab(user.getLastName(), "users")
                .verifyCellWithTextPresentInRow(user.getFirstName())
                .verifyCellWithTextPresentInRow(user.getLocation())
                .verifyCellWithTextPresentInRow(user.getRole())
                .verifyCellWithTextPresentInRow(user.getLogin())
                .verifyCellWithTextPresentInRow(user.getPassword())
                .assertAll();

    }


    @Test(priority = 2, dataProvider = "UserDataProvider")
    public void deleteUsers(User user){
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .deleteRowByName(user.getLastName());
    }




    @DataProvider(name="UserDataProvider")
    public Object[][] userCreateData() {
        return new Object[][]{
                {UserDataProvider.adminTeacher},
                {UserDataProvider.adminCoord}
        };
    }




    }
