package soselab.easylearn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sosealb.easylearn.FolderPage;

import static sosealb.easylearn.Util.screenShot;
import static soselab.easylearn.Driver.CreateDriverAndLogin;

/**
 * Created by bernie on 11/30/16.
 */
public class MovePackTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = CreateDriverAndLogin();
        driver.get("https://dev.microservices.ntou.edu.tw/folder/all");
    }

    @Test
    public void newPackTest() throws Exception {
        FolderPage folderPage = new FolderPage(driver);
        PageFactory.initElements(driver, folderPage);
        screenShot(driver);
        folderPage
                .clickPackMove();
        screenShot(driver);
    }

    @After
    public void down() {
        driver.quit();
    }
}
