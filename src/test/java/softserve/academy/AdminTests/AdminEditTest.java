package softserve.academy.AdminTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import softserve.academy.actions.AdminPanelActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;
import softserve.academy.models.UserDataProvider;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;


@Test(groups ={"admin", "funcEdit"})
public class AdminEditTest {
    User userLogIn = new User("alena", "1234");

    @Test(dataProvider = "UserDataProviderForEditTest")
    public void editUsers(User userToFind, User userFieldNew){
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .openEditModal(userToFind.getLastName())
                .editUserField("firstName", userFieldNew.getFirstName())
                .editUserField("lastName", userFieldNew.getLastName())
                .editUserField("role", userFieldNew.getRole())
                .editUserField("login", userFieldNew.getLogin())
                .editUserField("password", userFieldNew.getPassword())
                .submitEdit()
                .verifyRowWithNamePresentInTab(userFieldNew.getLastName(), "users")
                .verifyCellWithTextPresentInRow(userFieldNew.getFirstName())
                .verifyCellWithTextPresentInRow(userToFind.getLocation())
                .verifyCellWithTextPresentInRow(userFieldNew.getRole())
                .verifyCellWithTextPresentInRow(userFieldNew.getLogin())
                .verifyCellWithTextPresentInRow(userFieldNew.getPassword())
                .assertAll();

    }

    @DataProvider(name="UserDataProviderForEditTest")
    public Object[][] userEditData() {
        return new Object[][]{
                {UserDataProvider.adminAdmin, UserDataProvider.agent007}
        };
    }

    @BeforeTest(groups = {"funcEdit"})
    public void createUserToEdit() {
        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User(userLogIn.getLogin(), userLogIn.getPassword()))
                .waitPageLoaded();

        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .openCreateModal()
                .fillAllUserFieldsAndSubmit(UserDataProvider.adminAdmin);
    }

    @AfterTest(alwaysRun = true, groups = {"funcEdit"})
    public void delete() {
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .deleteRowByName(UserDataProvider.agent007.getLastName());

        getDriver().quit();
    }
}
