
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.sql.DriverManager.getDriver;

public class PaymentPage extends ConfigPage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String orderSummaryValues(String fieldName) {
        String temp = driver.findElement(By.xpath("//strong[text()='" + fieldName + "']/parent::dt/following-sibling::dd")).getText();
        return temp;
    }


    private By fullNameInput = By.xpath("//input[@name=\"delivery-fullName\"]");
    private By addressLine1 = By.xpath("//input[@name=\"delivery-addressLine1\"]");
    private By addressLine2 = By.xpath("//input[@name=\"delivery-addressLine2\"]");

    private By city = By.xpath("//input[@id=\"delivery-city\"]");

    private By region = By.xpath("//input[@id=\"delivery-county\"]");

    private By postCode = By.xpath("//input[@id=\"delivery-postCode\"]");

    static public By buyNowButton = By.xpath("//button[@id=\"buyNowButton\"]");
    static public By useSameAddressCheckbox = By.xpath("//label[@class=\"checker\"]");


    private By manualEntryButton = By.xpath("//button[@name=\"manualEntryButton\"]");
    private By errorMessage = By.xpath("//div[@class=\"buynow-error-msg\"][contains(text(),'Please enter your card number')]");

    public void fillEmailAndPhone(String email, String phone) {
        driver.findElement(By.xpath("//input[@name=\"emailAddress\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name=\"delivery-telephone\"]")).sendKeys(phone);
    }

    public void fillDeliveryData(String fullNameValue) {
        driver.findElement(fullNameInput).sendKeys(fullNameValue);
    }

    public void setCountry(String countryValue) {
        driver.findElement(By.xpath("//span[@name=\"deliveryCountry\"]")).click();
        driver.findElement(By.xpath("//a[@class='option-link'][contains(text(),'" + countryValue + "')]")).click();
    }

    public void fillDeliveryData(String address1Value, String address2Value, String cityValue, String regionValue, String postCodeValue) {
        driver.findElement(manualEntryButton).click();
        driver.findElement(addressLine1).sendKeys(address1Value);
        driver.findElement(addressLine2).sendKeys(address2Value);
        driver.findElement(city).sendKeys(cityValue);
        driver.findElement(region).sendKeys(regionValue);
        driver.findElement(postCode).sendKeys(postCodeValue);
    }

    public void clickOnBuyButton() {
        driver.findElement(buyNowButton).sendKeys(Keys.DOWN);
        driver.findElement(buyNowButton).click();
    }

    public By checkWarningMessage() {
        driver.findElement(errorMessage).getText();
        return this.errorMessage;
    }

    public static By cardName = By.xpath("//input[@autocomplete=\"cc-number\"][@type=\"tel\"]");
    public static By expDate = By.xpath("//input[@autocomplete=\"cc-exp\"]");
    public static By cvv = By.xpath("//input[@autocomplete=\"cc-csc\"][@type=\"tel\"]");


    public void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.name("braintree-hosted-field-number")));
    }

    public void fillCardNumberField(String cardNumber, String expirationDate, String cvvPass) {

        switchToIFrame();
        driver.findElement(cardName).sendKeys(cardNumber);
        switchToIFrame();
        driver.findElement(expDate).sendKeys(expirationDate);
        driver.findElement(cvv).sendKeys(cvvPass);
        switchToDefault();
    }


    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
