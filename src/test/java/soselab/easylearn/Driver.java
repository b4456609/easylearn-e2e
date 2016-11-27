package soselab.easylearn;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sosealb.easylearn.LoginPage;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver ourInstance = new Driver();
    private WebDriver driver;

    private Driver() {
        System.setProperty("webdriver.chrome.driver", "/home/bernie/pf/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1000));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        new LoginPage(driver).login("kezwpeccse_1480223702@tfbnw.net", "easylearntest");
    }

    public static Driver getInstance() {
        return ourInstance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
