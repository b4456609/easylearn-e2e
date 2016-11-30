package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static sosealb.easylearn.Util.screenShot;

public class FolderPage {
    @FindBy(id = "demo-menu-lower-right")
    WebElement addButton;

    @FindBy(id = "pack-menu-pack1477403034413")
    WebElement pack14MenuBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div[4]/button")
    WebElement firstPackViewBtn;

    WebDriver driver;

    public FolderPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mdl-card__title")));
        PageFactory.initElements(driver, this);
    }

    public FolderPage clickPackMeunBtn() throws InterruptedException {
        pack14MenuBtn.click();
        Thread.sleep(500);
        return this;
    }

    private WebElement getPackMenuBtn() {
        By id = By.id("pack-menu-pack1477403034413");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(id));
        return driver.findElement(id);
    }

    private WebElement getMovePackBtn() {
        By xpath = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div[5]/div/ul/li[2]");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        return driver.findElement(xpath);
    }

    public FolderPage clickPackMove() throws InterruptedException {
        getPackMenuBtn().click();
        getMovePackBtn().click();

        MovePackDialog movePackDialog = new MovePackDialog(driver);
        movePackDialog.moveDir();
        return this;
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
        NewPackPage newPackPage = new NewPackPage(driver);
        PageFactory.initElements(driver, newPackPage);

        return newPackPage;
    }

    private WebElement getDeletePackBtn() {
        By xpath = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div[5]/div/ul/li[1]");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        return driver.findElement(xpath);
    }

    public FolderPage deletePack() {
        getDeletePackBtn().click();
        DeletePackDialog movePackDialog = new DeletePackDialog(driver);
        movePackDialog.clickSubmit();
        return this;
    }


    public PackPage viewFirstPack() {
        firstPackViewBtn.click();
        return new PackPage(driver);
    }
}
