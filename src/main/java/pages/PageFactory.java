package pages;

public class PageFactory {

    public ClearTripHomePage getClearTripHomePageObj()
    {
        ClearTripHomePage clearTripHomePage = new ClearTripHomePage();
        return clearTripHomePage;
    }

    public HotelsPage getHotelsPageObj()
    {
        HotelsPage hotelsPage = new HotelsPage();
        return hotelsPage;
    }
}
