package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pojo.FlightSearchDetails;
import utilities.CommonUtils;

public class FlightsPage implements FlightsPageLocators{

    CommonUtils utils = new CommonUtils();

    @FindBy(id = OneWayRadioButtonId)
    public static WebElement oneWayRadioButton;

    @FindBy(id = FromTextboxId)
    public static WebElement fromTextbox;

    @FindBy(id = ToTextboxId)
    public static WebElement toTextbox;

    @FindBy(css = DepartOnDatePickerCss)
    public static WebElement departsOnDatePicker;

    @FindBy(id = SearchButtonId)
    public static WebElement searchButton;

    @FindBy(id = FromAutoOptionsListId)
    public static WebElement fromAutoOptionsList;

    @FindBy(id = ToAutoOptionsListId)
    public static WebElement toAutoOptionsList;

    @FindBy(className = SearchSummaryClassName)
    public static WebElement searchSummary;

    /**
     * This method will be used to get xpath for date
     * @param departsOnDate : departs on date, format: date/month
     * @return : xpath as String
     */
    private String getDepartsDateXpath(String departsOnDate)
    {
        String[] date = departsOnDate.split("/");
        String dateNumber = date[0];
        String monthNumber = String.valueOf(Integer.parseInt(date[1]) -1);
        return "//td[@data-month='" + monthNumber + "'and@data-handler='selectDay']/a[text()='" + dateNumber + "']";
    }


    /**
     * This method will be used to search one way flight
     * @param driver : Webdriver instance
     * @param flightSearchDetails : flight search details obj
     */
    public void searchOneWay(WebDriver driver, FlightSearchDetails flightSearchDetails){
        utils.waitForElementVisible(driver, oneWayRadioButton);
        oneWayRadioButton.click();
        fromTextbox.clear();
        fromTextbox.sendKeys(flightSearchDetails.getFromAirport());
        utils.waitForElementVisible(driver, fromAutoOptionsList);
        fromTextbox.sendKeys(Keys.RETURN);
        toTextbox.clear();
        toTextbox.sendKeys(flightSearchDetails.getToAirport());
        utils.waitForElementVisible(driver, toAutoOptionsList);
        toTextbox.sendKeys(Keys.RETURN);
        driver.findElement(By.xpath(getDepartsDateXpath(flightSearchDetails.getDepartsOnDate()))).click();
        searchButton.click();
        utils.waitForElementVisible(driver, searchSummary);
    }
}
