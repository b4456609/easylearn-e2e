package sosealb.easylearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPackPage {
    private WebDriver driver;
    @FindBy(id = "title")
    private WebElement titleTextField;
    @FindBy(id = "description")
    private WebElement descirptionTextField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/div/div[3]/div/div/div/button")
    private WebElement submitBtn;

    public NewPackPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewPackPage fillTitle(String title) {
        titleTextField.click();
        titleTextField.sendKeys(title);
        return this;
    }

    public NewPackPage fillDescription(String description) {
        descirptionTextField.click();
        descirptionTextField.sendKeys(description);
        return this;
    }


    public FolderPage submitArticleAndGoFolderPage() {
        submitBtn.click();
        FolderPage folderPage = new FolderPage(driver);
        PageFactory.initElements(driver, folderPage);
        return folderPage;
    }
}
