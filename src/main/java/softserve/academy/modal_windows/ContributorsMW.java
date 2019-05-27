package softserve.academy.modal_windows;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import softserve.academy.models.Utils;
import softserve.academy.pages.AboutPage;

public class ContributorsMW extends AboutPage {

    public ContributorsMW() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Utils.getDriver(), 15), this);
    }
}
