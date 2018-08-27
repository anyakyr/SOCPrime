package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anya on 23.08.2018.
 */
public class ClientPage {

    @FindBy(xpath = "//*[@id='current_account']/a")
    public WebElement accButton;

    protected WebDriver driver;

    public ClientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
