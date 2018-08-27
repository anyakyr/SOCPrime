package bookingTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.Constants;

import static utility.services.ManageUrlService.getDirectlyURL;
import static utility.services.ReportService.assertTrue;
import static utility.services.WebElementService.elementIsDisplayed;

/**
 * Created by Anya on 23.08.2018.
 */
public class Booking_001_SearchTest extends BaseTest{
    @Test
    public void test_001() throws Exception {
        //Go to landing page.
        getDirectlyURL(Constants.URL,driver);

        //Verify that page has all necessary components.
        assertTrue(elementIsDisplayed(bookingPage.dectinationInput,"Destination TextField"),
                "Destination TextField is NOT displayed");

        assertTrue(elementIsDisplayed(bookingPage.checkInDate,"Check In Date"),
                "Check In Date is NOT displayed");
        assertTrue(elementIsDisplayed(bookingPage.checkOutDate,"Check  Date"),
                "Check Out Date is NOT displayed");
        assertTrue(elementIsDisplayed(bookingPage.checkPriceButton,"Check Price Button"),
                "Check Price Button is NOT displayed");

        bookingPage.enterDestinationToInput();

        bookingPage.clickOnCheckInDate();
        bookingPage.clickOnNextMonthButton();
        bookingPage.clickOnSelectCheckInDate();
        bookingPage.clickOnSelectCheckOutDate();
        bookingPage.clickOnCheckPriceButton();

        bookingPage.checkLocation("Нью-Йорк");
    }
}
