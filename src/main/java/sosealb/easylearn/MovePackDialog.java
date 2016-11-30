package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovePackDialog {
    @FindBy(xpath = "//*[@id=\"moving-dialog\"]/div[1]/ul/li[1]/span[2]/label/span[3]")
    WebElement firstItem;

    @FindBy(css = "div.mdl-dialog__actions > button.mdl-button")
    WebElement submit;

    public MovePackDialog(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mdl-dialog__actions > button.mdl-button")));
        PageFactory.initElements(driver, this);
    }

    public void moveDir() {
        firstItem.click();
        submit.click();
    }
}
