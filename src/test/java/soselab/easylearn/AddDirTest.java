package soselab.easylearn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sosealb.easylearn.FolderPage;

import static sosealb.easylearn.Util.screenShot;
import static soselab.easylearn.Driver.CreateDriverAndLogin;

public class AddDirTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = CreateDriverAndLogin();
        driver.get("https://dev.microservices.ntou.edu.tw/folder/all");
    }

    @Test
    public void testWebdriver() throws Exception {
        FolderPage folderPage = new FolderPage(driver);
        screenShot(driver);
        PageFactory.initElements(driver, folderPage);
        folderPage.newDir("newdir");
    }

    @After
    public void down() {
        driver.quit();
    }

}
