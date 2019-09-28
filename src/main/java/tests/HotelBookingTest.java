package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClearTripHomePage;
import pages.HotelsPage;
import pages.PageFactory;

public class HotelBookingTest extends BaseTestClass{

    PageFactory pageFactory = new PageFactory();

    @Test
    public void shouldBeAbleToSearchForHotels() {
        try {
            ClearTripHomePage.hotelLink.click();
            pageFactory.getHotelsPageObj().search(driver, "Indiranagar, Bangalore", HotelsPage.TravellersDetails.ROOM1ADULT1);
            String searchHeaderLabelText = HotelsPage.searchHeaderLabel.getText();
            String showingHotelsAroundHeaderText = HotelsPage.showingHotelsAroundHeader.getText();
            Assert.assertTrue(searchHeaderLabelText.contains("Bangalore"));
            Assert.assertTrue(searchHeaderLabelText.contains("1 room, 1 adult"));
            Assert.assertTrue(showingHotelsAroundHeaderText.contains("Showing hotels around"));
            Assert.assertTrue(showingHotelsAroundHeaderText.contains("Indiranagar"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()); //We can log the exception message instead printing
            Assert.fail("TC-Failed -" + e.getMessage());
        }
    }
}
