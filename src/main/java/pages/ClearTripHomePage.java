package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonUtils;

/**
 * Class for clear trip home page
 */
public class ClearTripHomePage implements ClearTripHomePageLocators{

    CommonUtils utils = new CommonUtils();

    @FindBy(linkText = YourTripsLinktext)
    public static WebElement yourTripsLink;

    @FindBy(id = SignInButtonId)
    public static WebElement signInButton;

    @FindBy(id = SignInSubmitButtonId)
    public static WebElement signInSubmitButton;

    @FindBy(id = LoginErrorDivId)
    public static WebElement loginErrorDiv;

    @FindBy(id = UserNameTextBoxId)
    public static WebElement userNameTextBox;

    @FindBy(id = PasswordTextBoxId)
    public static WebElement passwordTextBox;

    @FindBy(id = LoginFormFrameId)
    public static WebElement loginFormFrame;

    /**
     * This method will be used to landing to clear trip home page
     * @param driver: Webdriver Instance
     */
    public void landToHomePage(WebDriver driver)
    {
        driver.get(utils.getProperty("clearTripLandingPage"));
        driver.manage().window().maximize();
        utils.waitForElementVisible(driver, yourTripsLink);
    }

    /**
     * This method will be used to login to clear trip
     */
    public void login(WebDriver driver, String userName, String password)
    {
        yourTripsLink.click();
        signInButton.click();
        utils.waitForElementVisible(driver, loginFormFrame);
        driver.switchTo().frame(loginFormFrame);
        utils.waitForElementVisible(driver, userNameTextBox);
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);

        signInSubmitButton.click();
    }



}
