package sosealb.easylearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.facebook.com/");
        // Check that we're on the right page.
        if (!driver.getTitle().contains("Facebook")) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage login(String email, String password) throws IOException {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("u_0_l")).click();

        return this;
    }
}
