package soselab.easylearn;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import sosealb.easylearn.FolderPage;

import static sosealb.easylearn.Util.screenShot;
import static soselab.easylearn.Driver.CreateDriverAndLogin;

public class AddDirTest {

    private WebDriver driver;
    private ExtentTest test;
    private ExtentReports extent;

    @Before
    public void setUp() throws Exception {
        driver = CreateDriverAndLogin();
        driver.get("https://dev.microservices.ntou.edu.tw/folder/all");
        // initialize the HtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        // initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // attach only HtmlReporter
        // test with description
        test = extent
                .createTest("MyFirstTest", "Test Description");
    }

    @Test
    public void testAddDir() throws Exception {
        test.log(Status.INFO,"testadddir");
        FolderPage folderPage = new FolderPage(driver);
        // adding screenshots to log
        String filename = screenShot(driver).orElseThrow(RuntimeException::new);
        test.pass("details").addScreenCaptureFromPath(filename);
        folderPage.newDir("newdir");
        extent.flush();
    }

    @After
    public void down() {
        driver.quit();
    }

}
