package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTestClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {

    private int timeOut = 20;

    /**
     * This method will be used to get propert value from testsetting.properties file
     * @param property - Property Key as String
     * @return - Property value as String
     */
    public String getProperty(String property)
    {
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(new FileInputStream("testsettings.properties"));

            //get the property value and return it
            return prop.getProperty(property);

        }
        catch (IOException ex) {
            throw new RuntimeException("Error in GetProperty Method.  Error :  " + ex.getMessage());
        }
    }

    /**
     * This method will be used to explicit wait for web element
     * @param element
     */
    public void waitForElementVisible(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
