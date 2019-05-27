package softserve.academy.us101;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import softserve.academy.actions.LoginPageActions;

public class ValidationFields101Test extends BaseTest {

    @DataProvider(name = "fieldsData")
    public static Object[][] fieldsData() {
        return new Object[][]{
                {"dmytrodmyt", "1234567891"},
                {"dmytrodmytr", "12345678912"}};

    }

    @Test(groups = {"loginPage"}, description = "test verify Validation, length of fields", dataProvider = "fieldsData")
    void testValidationLengthOfFields(String login, String password) {


        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .fillLoginField(login)
                .fillPasswordField(password)
                .verifyValidation()
                .assertAll();

    }


}
