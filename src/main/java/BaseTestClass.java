import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Base class for all test classes.
 */
public class BaseTestClass {

    public WebDriver driver;

    /**
     * This method will be used to test initialize
     */
    @BeforeTest
    public void testInitialize()
    {
        setDriverPath();
        driver = new ChromeDriver();
    }

    /**
     * This method will be used for test cleanup
     */
    @AfterTest
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
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}
