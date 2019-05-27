package softserve.academy.actions;

import org.openqa.selenium.By;
import softserve.academy.models.Utils;
import softserve.academy.pages.MWEditGroupWrapper;

public class ModalWindowEditGroupWrapperActions extends BaseActions {
    MWEditGroupWrapper modalWindowEditGroupWrapper = new MWEditGroupWrapper();

    public ModalWindowEditGroupWrapperActions selectGroup(CharSequence group) {
        Utils.getDriver().findElement(By.xpath("//div[@class='small-group-view col-md-6']//p[text()='" + group + "']")).click();
        softAssert.assertEquals(Utils.getDriver().getCurrentUrl(), "http://146.148.17.49/Students/Dnipro/DP-094-MQC/list");
        return this;
    }

}
