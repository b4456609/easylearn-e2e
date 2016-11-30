package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"finish-btn\"]/button")
    private WebElement finishBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/div/div[3]/div[1]/label/span[4]")
    private WebElement publicCheckBox;

    public EditPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"editor_ifr\"]")));
        PageFactory.initElements(driver, this);
    }

    public EditPage setContent(String content) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = String.format("tinymce.activeEditor.setContent(\"%s\");", content);
        System.out.println(script);
        js.executeScript(script);
        return this;
    }

    public PackPage submit() {
        finishBtn.click();
        return new PackPage(driver);
    }

}
