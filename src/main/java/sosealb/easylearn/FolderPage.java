package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static sosealb.easylearn.Util.screenShot;

public class FolderPage {
    @FindBy(id = "demo-menu-lower-right")
    WebElement addButton;

    WebDriver driver;

    public FolderPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getNewDirButton() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/ul/li[2]"));
    }

    private WebElement getNewPackButton() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/ul/li[1]"));
    }

    public FolderPage newDir(String name) throws InterruptedException {
        addButton.click();
        Thread.sleep(500);
        screenShot(driver);

        getNewDirButton().click();

        NewFolderDialog newFolderDialog = PageFactory.initElements(driver, NewFolderDialog.class);
        newFolderDialog.addNewDir(name);
        return this;
    }

    public NewPackPage goToNewPackPage() throws InterruptedException {
        addButton.click();
        Thread.sleep(500);
        screenShot(driver);

        getNewPackButton().click();

        return new NewPackPage(driver);
    }
}
