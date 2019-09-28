package pages;

/**
 * This class is pages class object factory
 */
public class PageFactory {

    /**
     * This method will be used to get ClearTripHomePage class obj
     * @return : ClearTripHomePage obj
     */
    public ClearTripHomePage getClearTripHomePageObj()
    {
        ClearTripHomePage clearTripHomePage = new ClearTripHomePage();
        return clearTripHomePage;
    }

    /**
     * This method will be used to get HotelsPage class obj
     * @return : HotelsPage obj
     */
    public HotelsPage getHotelsPageObj()
    {
        HotelsPage hotelsPage = new HotelsPage();
        return hotelsPage;
    }

    /**
     * This method will be used to get FlightsPage class obj
     * @return : FlightsPage obj
     */
    public FlightsPage getFlightsPageObj()
    {
        FlightsPage flightsPage = new FlightsPage();
        return flightsPage;
    }
}
