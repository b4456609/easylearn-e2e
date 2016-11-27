package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public FolderPage newDir(String name) throws InterruptedException {
        addButton.click();
        Thread.sleep(1000);
        getNewDirButton().click();

        NewFolderDialog newFolderDialog = PageFactory.initElements(driver, NewFolderDialog.class);
        newFolderDialog.addNewDir(name);
        return this;
    }
}