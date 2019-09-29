package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.PageFactory;
import pages.pojo.FlightSearchDetails;
import utilities.CSVAnnotation;
import utilities.GenericDataProvider;

import java.util.Map;

public class FlightBookingTest extends BaseTestClass{

    PageFactory pageFactory = new PageFactory();

    @Test(groups = {"smoke,regression"},
            description = "This test case checks the one way flight search.",
            dataProvider = "dataproviderForTestCase",
            dataProviderClass = GenericDataProvider.class)
    @CSVAnnotation.CSVFileParameters(delimiter = "###", path = "testdata/flightsearch.csv")
    public void testThatResultsAppearForAOneWayJourney(int rowNo, Map<String,String> testData) {
        try {

            FlightSearchDetails flightSearchDetails = new FlightSearchDetails();
            flightSearchDetails.setFromAirport(testData.get("from"));
            flightSearchDetails.setToAirport(testData.get("to"));
            flightSearchDetails.setDepartsOnDate(testData.get("date")); //Date/Month

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
