package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Log;
import java.util.List;

import java.util.Random;

import static utility.services.WebElementService.*;

/**
 * Created by Anya on 23.08.2018.
 */
public class BookingPage {

    @FindBy(id = "ss")
    public WebElement dectinationInput;

    @FindBy(xpath = "//div[@class='xp__dates-inner xp__dates__checkin']")
    public WebElement checkInDate;

    @FindBy(xpath = "//div[@class='xp__dates-inner xp__dates__checkout']")
    public WebElement checkOutDate;

    @FindBy(xpath = "//button[@class='sb-searchbox__button  ']")
    public WebElement checkPriceButton;

    @FindBy(id = "current_account_create")
    public WebElement registerButton;

    @FindBy(id = "current_account")
    public WebElement loginToAccButton;

    @FindBy(xpath = "//form[@target='log_tar']/label[1]/input")
    public WebElement emailInput;

    @FindBy(xpath = "//form[1]/label[2]/input")
    public WebElement passwordInput;

    @FindBy(id ="password")
    public WebElement createPassword;

    @FindBy(xpath = "//input[@class='bootstrapped-input btn btn-primary  ']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@value='Начать']")
    public WebElement startButton;

    @FindBy(xpath = "//div[contains(text(), 'укажите действительный электронный адрес')]")
    public WebElement loginError;

    @FindBy(xpath = "//div/div[contains(text(), 'укажите действительный электронный адрес')]")
    public WebElement registerError;

    @FindBy(xpath = "//div/div[contains(text(), 'Пароль должен состоять')]")
    public WebElement passwordError;

    @FindBy(xpath = "//div/div[contains(text(), 'Пожалуйста, введите пароль')]")
    public WebElement emptyPasswordError;

    @FindBy(xpath = "//input[@autocomplete='username email']")
    public WebElement regEmailInput;

    @FindBy(xpath="//*[@id='frm']/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/table/tbody/tr[2]/td[7]/span[contains(text(), '14')]")
    public WebElement selectCheckInDate;

    @FindBy(xpath="//*[@id='frm']/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/table/tbody/tr[3]/td[6]/span")
    public WebElement selectCheckOutDate;

    @FindBy(className = "c2-month-header-monthname")
    public List<WebElement> months;

    @FindBy(className = "c2-button-further")
    public WebElement nextMonthButton;

    @FindBy(className = "district_link")
    public List <WebElement> linkList;

    private static final String WRONG_SEARCH_RESULT_EXEPTION = "Wrong search results";
    protected WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterDestinationToInput(){
        sendKeysClear(dectinationInput, "Destination", "New York", driver);
    }

    public void enterUsernameToInput(String email){
        sendKeysClear(emailInput, "Email Text Field", email, driver);
    }

    public void enterPasswordToInput(String password){
        sendKeysClear(passwordInput, "Password TextField", password, driver);
    }

    public void enterCreatePassword(String password){
        sendKeysClear(createPassword, "Create Password TextField", password, driver);
    }

    public void enterRegEmailToInput(String email){
        sendKeysClear(regEmailInput, "RegEmail TextField", email, driver);
    }

    public void clickOnCheckPriceButton() {
        clickOnElement(checkPriceButton, "Check Price Button", driver);
    }

    public void clickOnCheckInDate() {
        clickOnElement(checkInDate, "Check In Date", driver);
    }

    public void clickOnCheckOutDate() {
        clickOnElement(checkOutDate, "Check Out Date", driver);
    }

    public void clickOnSelectCheckInDate() {
        clickOnElement(selectCheckInDate, "Select Check In Date", driver);
    }

    public void clickOnSelectCheckOutDate() {
            clickOnElement(selectCheckOutDate, "Select Check Out Date", driver);
    }

    public void clickOnLogintoAccButton() {
        clickOnElement(loginToAccButton, "Login Acc Button", driver);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton, "Login Button", driver);
    }

    public void clickOnStartButton() {
        clickOnElement(startButton, "Start Button", driver);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton, "Register Button", driver);
    }

    public void enterRanEmail(){

        Random rad = new Random();
        for (int j=1; j<=1; j++ )
        {
            regEmailInput.sendKeys("email" + rad.nextInt(10000) + "@yopmail.com");
        }
    }

    public void checkLocation(String address) throws Exception {
        if (!ContainsWebElementsText(linkList, address)) {
            Log.error("Failure search");
            throw new InterruptedException(WRONG_SEARCH_RESULT_EXEPTION);
        } else {
            Log.info("Search contains the correct locations");
        }
    }

    public void clickOnNextMonthButton() {
            clickOnElement(nextMonthButton, "Next Month Button", driver);
    }

}
