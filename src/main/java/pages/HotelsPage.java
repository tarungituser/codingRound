package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonUtils;

public class HotelsPage implements HotelsPageLocators{

    CommonUtils utils = new CommonUtils();

    public enum TravellersDetails
    {
        ROOM1ADULT1,
        ROOM1ADULTS2,
        ROOMS2ADULTS4,
        MORETRAVELLERS
    }

    /**
     * This method will be used to get traveller details using enum as parameter
     * @param travellersDetails : Travellers Details as enum
     * @return : Travellers Details as String
     */
    private String getTravellerDetails(TravellersDetails travellersDetails)
    {
        switch (travellersDetails)
        {
            case ROOM1ADULT1:
                return "1 room, 1 adult";
            case ROOM1ADULTS2:
                return "1 room, 2 adults";
            case ROOMS2ADULTS4:
                return "2 rooms, 4 adults";
            case MORETRAVELLERS:
                return "More travellers...";
        }

        return null;
    }

    @FindBy(id = LocalityTextBoxId)
    public static WebElement localityTextBox;

    @FindBy(id = SearchButtonId)
    public static WebElement searchButton;

    @FindBy(id = TravellerSelectionId)
    public static WebElement travellerSelection;

    @FindBy(css = ShowingHotelsAroundHeaderCss)
    public static WebElement showingHotelsAroundHeader;

    @FindBy(id = SearchHeaderLabelId)
    public static WebElement searchHeaderLabel;

    @FindBy(id = WhereAutoOptionsListId)
    public static WebElement whereAutoOptionsList;



    /**
     * This method will be used to search hotels
     * @param driver : Webdriver Instance
     * @param hotelLocation : Hotel Location as String
     * @param travellersDetails : Travellers Details
     * @throws InterruptedException
     */
    public void search(WebDriver driver, String hotelLocation, TravellersDetails travellersDetails) throws InterruptedException {
        utils.waitForElementVisible(driver, localityTextBox);
        localityTextBox.clear();
        localityTextBox.sendKeys(hotelLocation);
        utils.waitForElementVisible(driver, whereAutoOptionsList);
        localityTextBox.sendKeys(Keys.RETURN);
        new Select(travellerSelection).selectByVisibleText(getTravellerDetails(travellersDetails));
        searchButton.click();
        utils.waitForElementVisible(driver, showingHotelsAroundHeader);
    }
}
