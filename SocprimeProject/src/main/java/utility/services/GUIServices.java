package utility.services;

import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static utility.Log.info;

@Log4j
public class GUIServices {

    static WebDriver driver;

    public static boolean verifyImageLoaded(WebElement element, WebDriver driver){
        Boolean result = (Boolean) ((JavascriptExecutor)driver).
                executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        return result;
    }

    /**
     * Taking screenshot into .//target// + pathToScreenShot
     *
     * @param pathToScreenShot
     * @param driver
     */
    public static void screenShot(String pathToScreenShot, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathToScreenShot));
            info("ScreenShot: " + pathToScreenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
