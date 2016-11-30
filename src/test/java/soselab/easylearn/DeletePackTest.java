package soselab.easylearn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import sosealb.easylearn.FolderPage;

import static soselab.easylearn.Driver.CreateDriverAndLogin;

public class DeletePackTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = CreateDriverAndLogin();
        driver.get("https://dev.microservices.ntou.edu.tw/folder/all");
    }

    @Test
    public void deletePackTest() throws Exception {
        FolderPage folderPage = new FolderPage(driver);
        folderPage
                .clickFirstPackMeunBtn()
                .deletePack();
    }

    @After
    public void down() {
        driver.quit();
    }
}
