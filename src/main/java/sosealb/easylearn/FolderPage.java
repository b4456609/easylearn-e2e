package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FolderPage {
    private final By firstPackDeleteBtn = By.xpath("//div[@id='root']/div/div/main/div/div/div/div/div[5]/div/ul/li");
    private final By firstPackMoveBtn = By.xpath(" //*[@id='root']/div/div/main/div/div/div[1]/div/div[5]/div/ul/li[2]");
    @FindBy(id = "demo-menu-lower-right")
    WebElement addButton;
    @FindBy(xpath = "//div[@id='root']/div/div/main/div/div/div/div/div[5]/button")
    WebElement firstpackMenuBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div[4]/button")
    WebElement firstPackViewBtn;
    WebDriver driver;

    public FolderPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/main/div/div")));
        PageFactory.initElements(driver, this);
    }

    public FolderPage clickFirstPackMeunBtn() throws InterruptedException {
        firstpackMenuBtn.click();
        //wait menu to show
        Thread.sleep(300);
        return this;
    }

    private WebElement getFirstMovePackBtn() {
        return driver.findElement(firstPackMoveBtn);
    }

    public FolderPage clickFirstPackMoveBtnAndMove() throws InterruptedException {
        getFirstMovePackBtn().click();

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

        getNewDirButton().click();

        NewFolderDialog newFolderDialog = PageFactory.initElements(driver, NewFolderDialog.class);
        newFolderDialog.addNewDir(name);
        return this;
    }

    public NewPackPage goToNewPackPage() throws InterruptedException {
        addButton.click();
        Thread.sleep(500);

        getNewPackButton().click();
        NewPackPage newPackPage = new NewPackPage(driver);
        PageFactory.initElements(driver, newPackPage);

        return newPackPage;
    }

    private WebElement getDeletePackBtn() {
        return driver.findElement(firstPackDeleteBtn);
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
