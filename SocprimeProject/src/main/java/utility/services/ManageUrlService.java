package utility.services;

import org.openqa.selenium.*;
import utility.Log;

import java.util.concurrent.TimeUnit;

import static utility.Log.info;
import static utility.Log.warn;
import static utility.services.WaiterService.waitForJSandJQueryToLoad;
import static utility.services.WebElementService.moveToCoordinate;

public class ManageUrlService {

    public static void getDirectlyURL(String url, WebDriver driver) {
        driver.getCurrentUrl();
        info("Navigate to \""+url+"\".");
        try {
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.get(url);
            waitForJSandJQueryToLoad(driver);
            info("Navigate to \""+url+"\" finished.");
            moveToCoordinate(0,0,driver);
        }
        catch (TimeoutException e){
            stopLoad(driver);
        }
        catch (UnhandledAlertException e){
            warn("Catch UnhandledAlertException.");
            skipModalWindow(driver);
        }

    }

    public  static void refreshPage(WebDriver driver){
        try {
            driver.navigate().refresh();
            info("Page was refreshed.");
        }
        catch (WebDriverException e){
            stopLoad(driver);
        }
    }

    public static void switchToWindow(String windowName, WebDriver driver){
        info("Switch to \""+windowName+"\" window.");
        driver.switchTo().window(windowName);
    }

    public static void switchToWindow(WebDriver driver){
        for (String win:driver.getWindowHandles()){
            driver.switchTo().window(win);
        }
        info("Switch to another window.");
        driver.manage().window().maximize();
        info("Maximize window.");
    }


    public static void skipModalWindow(WebDriver driver){
        try {
            Alert alt=driver.switchTo().alert();
            alt.accept();
            info("Skip modal window.");
        }
        catch (NoAlertPresentException e){
            Log.warn("Catch NoAlertPresentException.");
        }
    }

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public static void stopLoad(WebDriver driver){
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
        info("Timeout on loading page \""+driver.getCurrentUrl()+"\".");
    }


    public static void scrollDown(WebDriver driver, int px){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,"+px+")", "");
    }
}
