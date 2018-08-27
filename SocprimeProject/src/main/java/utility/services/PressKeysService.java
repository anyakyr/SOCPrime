package utility.services;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utility.Log;

import static utility.Log.info;

public class PressKeysService {
    public static void pressEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
        info("Press \"Enter\" key.");
    }

    public static void paste(WebElement element){
        element.sendKeys(Keys.CONTROL, Keys.chord("v"));
        info("Element is pasted from buffer.");

    }

    public static void pressBackSpace(WebElement element){
        element.sendKeys(Keys.BACK_SPACE);
        Log.info("Press \"Back Space\" key.");
    }

}
