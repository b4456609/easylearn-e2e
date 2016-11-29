package sosealb.easylearn;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Created by bernie on 2016/11/27.
 */
public class Util {
    public static Optional<String> screenShot(WebDriver driver) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).
                getScreenshotAs(OutputType.FILE);
        String filename = new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
        File dest = new File(filename);
        try {
            FileUtils.copyFile(screenshot, dest);
            return Optional.of(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
