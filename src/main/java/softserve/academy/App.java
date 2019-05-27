package softserve.academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import softserve.academy.actions.AdminPanelActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

import java.util.ArrayList;
import java.util.List;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;

public class App {

    public static void main(String[] args) {

        User user=new User("dmytro", "1234");
        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(user.getLogin(), user.getPassword())
                .waitPageLoaded();

        new AdminPanelActions()
                .openAdminPanel()
                .openGroupTab();


    AdminPanelActions admin=new AdminPanelActions();
    List<WebElement>table =getDriver().findElements((By.xpath("//*[@id='groups']/div/table/tbody/tr")));

        //List<WebElement>rowsWithRowName=new ArrayList<>();
        List<WebElement> fields = new ArrayList<>();
        List<String> groupNames = new ArrayList<>();
        for (WebElement row : table) {
            if (row.getText().contains("Reuta")) {
                fields = row.findElements(By.tagName("td"));
                groupNames.add(fields.get(0).getText());
            }

        }




        for (String r:groupNames  ) {
            System.out.println(r);
        }





        getDriver().quit();
    }



}
