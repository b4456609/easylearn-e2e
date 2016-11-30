package soselab.easylearn;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import sosealb.easylearn.FolderPage;

import static sosealb.easylearn.Util.screenShot;
import static soselab.easylearn.Driver.CreateDriverAndLogin;

public class AddVersionTest {
    private WebDriver driver;
    private ExtentTest test;
    private ExtentReports extent;
    private String content = "Kirkenes, Norway (CNN)An American tank full of US Marines crashes through the silence of the sub-zero pine forest, far above the Arctic Circle, as unidentified drones hover overhead and yellow and green smoke fills the freezing air.\n" +
            "\n" +
            "The troops' target? A bunker up ahead, manned by Norwegian soldiers. Shots ring out as the Marines advance, crunching through the snow beneath gray winter skies.\n" +
            "It's all role-play, of course -- the maneuvers are part of a training exercise, but one jarringly imbued with the new reality along NATO's northernmost border with Russia.\n" +
            "Some 300 US Marines are due to be based permanently in Norway from January as part of a package of measures intended to reassure one of NATO's most easterly members.\n" +
            "Although they'll be about 1,000 kilometers (621 miles) from the border, the plan is for them to bolster the readiness of new \"pre-positioned\" tanks and weaponry stored throughout the year in underground caves.";

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
    public void addVersionTest() throws Exception {
        FolderPage folderPage = new FolderPage(driver);
        folderPage
                .viewFirstPack()
                .editTheVersion()
                .setContent(StringEscapeUtils.escapeJava(content))
                .submit();
        screenShot(driver);
    }

    @After
    public void down() {
        driver.quit();
    }
}
