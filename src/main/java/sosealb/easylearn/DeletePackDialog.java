package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePackDialog {

    @FindBy(xpath = "//*[@id=\"remove-pack-dialog\"]/div[2]/button[1]")
    WebElement submit;

    public DeletePackDialog(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mdl-dialog__actions > button.mdl-button")));
        PageFactory.initElements(driver, this);
    }

    public void clickSubmit() {
        submit.click();
    }
}
