package softserve.academy.modal_windows;

import org.openqa.selenium.By;
import softserve.academy.actions.BaseActions;
import softserve.academy.models.Utils;
import softserve.academy.pages.MWEditGroupWrapper;

public class MWeditGroupWrapperActions extends BaseActions {
    MWEditGroupWrapper modalWindowEditGroupWrapper = new MWEditGroupWrapper();

    public MWEditStudentlistActions selectGroup(CharSequence group) {
        Utils.getDriver().findElement(By.xpath("//li[@class='group-item']/p[text()='" + group + "']")).click();
        softAssert.assertEquals(Utils.getDriver().getCurrentUrl(), "http://146.148.17.49/Students/Dnipro/DP-094-MQC/list");
        return new MWEditStudentlistActions();
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
