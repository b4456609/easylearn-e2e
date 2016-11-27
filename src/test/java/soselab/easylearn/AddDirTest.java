package soselab.easylearn;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sosealb.easylearn.FolderPage;

public class AddDirTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        Driver mydriver = Driver.getInstance();
        driver = mydriver.getDriver();
        driver.get("https://dev.microservices.ntou.edu.tw/folder/all");
    }

    @Test
    public void testWebdriver() throws Exception {
        FolderPage folderPage = new FolderPage(driver);
        PageFactory.initElements(driver, folderPage);
        folderPage.newDir("newdir");
    }

}
