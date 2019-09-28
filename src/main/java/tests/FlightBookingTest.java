package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.PageFactory;
import pages.pojo.FlightSearchDetails;

public class FlightBookingTest extends BaseTestClass{

    PageFactory pageFactory = new PageFactory();

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        try {

            FlightSearchDetails flightSearchDetails = new FlightSearchDetails();
            flightSearchDetails.setFromAirport("Bangalore");
            flightSearchDetails.setToAirport("Delhi");
            flightSearchDetails.setDepartsOnDate("10/10"); //Date/Month

            pageFactory.getFlightsPageObj().searchOneWay(driver, flightSearchDetails);
            Assert.assertTrue(FlightsPage.searchSummary.isDisplayed());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()); //We can log the exception message instead printing
            Assert.fail("TC-Failed -" + e.getMessage());
        }

    }
}
