package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends ConfigPage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailAndPhone(String email, String phone) {
        driver.findElement(By.xpath("//input[@name=\"emailAddress\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name=\"delivery-telephone\"]")).sendKeys(phone);
    }

    public String orderSummaryValues(String fieldName) {
        String temp = driver.findElement(By.xpath("//strong[text()='" + fieldName + "']/parent::dt/following-sibling::dd")).getText();
        return temp;
    }


    private WebElement fullName = driver.findElement(By.xpath("//input[@name=\"delivery-fullName\"]"));
    private WebElement manualEntryButton = driver.findElement(By.xpath("//button[@name=\"manualEntryButton\"]"));
    private WebElement addresLine1 = driver.findElement(By.xpath("//input[@name=\"delivery-addressLine1\"]"));
    private WebElement addressLine2 = driver.findElement(By.xpath("//input[@name=\"delivery-addressLine2\"]"));
    private WebElement city = driver.findElement(By.xpath("//input[@id=\"delivery-city\"]"));
    private WebElement region = driver.findElement(By.xpath("//input[@id=\"delivery-county\"]"));
    private WebElement postCode = driver.findElement(By.xpath("//input[@id=\"delivery-postCode\"]"));

    public void setCountry(String countryValue) {
        driver.findElement(By.xpath("//a[@class='option-link'][contains(text(),'"+countryValue+"')]")).click();
    }
    public void clickOnManualEntryButton() {
        manualEntryButton.click();
    }


    public void fillDeliveryData(String fullNameValue, String address1Value, String address2Value, String cityValue, String regionValue, String postCodeValue) {
        fullName.sendKeys(fullNameValue);
        addresLine1.sendKeys(address1Value);
        addressLine2.sendKeys(address2Value);
        city.sendKeys(cityValue);
        region.sendKeys(regionValue);
        postCode.sendKeys(postCodeValue);
    }
}
