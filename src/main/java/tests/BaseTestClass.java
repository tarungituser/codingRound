package tests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ClearTripHomePage;
import pages.FlightsPage;
import pages.HotelsPage;
import utilities.CommonUtils;
import static pages.ClearTripHomePage.yourTripsLink;

/**
 * Base class for all test classes.
 */
public class BaseTestClass {

    public WebDriver driver;

    CommonUtils utils = new CommonUtils();

    /**
     * This method will be used to test initialize
     */
    @BeforeMethod
    public void testInitialize()
    {
        setDriverPath();
        driver = new ChromeDriver();
        PageFactory.initElements(driver, ClearTripHomePage.class);
        PageFactory.initElements(driver, HotelsPage.class);
        PageFactory.initElements(driver, FlightsPage.class);
        driver.get(utils.getProperty("clearTripLandingPage"));
        driver.manage().window().maximize();
        utils.waitForElementVisible(driver, yourTripsLink);

    }

    /**
     * This method will be used for test cleanup
     */
    @AfterMethod
    public void testCleanUp()
    {
        driver.quit();
    }

    /**
     * This method will be used to set driver path according to platform
     */
    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriverv77.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}
