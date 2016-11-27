package sosealb.easylearn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bernie on 2016/11/27.
 */
public class NewFolderDialog {
    @FindBy(id = "new-dir-name")
    WebElement textField;

    @FindBy(css = "div.mdl-dialog__actions > button.mdl-button")
    WebElement submit;

    public void addNewDir(String name) {
        textField.click();
        textField.clear();
        textField.sendKeys(name);
        submit.click();
    }
}
