package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bernie on 11/30/16.
 */
public class PackPage {
    @FindBy(xpath = "//*[@id=\"appbar-menu-lower-right\"]")
    WebElement menu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[2]/div[2]/div/ul/li[1]")
    WebElement newVersionBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[2]/div[2]/div/ul/li[2]")
    WebElement otherVersionBtn;
    private WebDriver driver;

    public PackPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        PageFactory.initElements(driver, this);
    }

    private WebElement getNewVersionBtn() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/header/div[2]/div[2]/div/ul/li[1]"));
    }

    public EditPage editTheVersion() {
        menu.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/header/div[2]/div[2]/div/ul/li[1]")));
        getNewVersionBtn().click();
        return new EditPage(driver);
    }
}
