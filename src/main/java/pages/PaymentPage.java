package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//input[@name=\"delivery-fullName\"]")
    private WebElement fullName;

    @FindBy(xpath = "//input[@name=\"delivery-addressLine1\"]")
    private WebElement addresLine1;
    @FindBy(xpath = "//input[@name=\"delivery-addressLine2\"]")
    private WebElement addressLine2;
    @FindBy(xpath = "//input[@id=\"delivery-city\"]")
    private WebElement city;
    @FindBy(xpath = "//input[@id=\"delivery-county\"]")
    private WebElement region;
    @FindBy(xpath = "//input[@id=\"delivery-postCode\"]")
    private WebElement postCode;
    @FindBy(id = "buyNowButton")
    private WebElement buyNowButton;

    @FindBy(id = "delivery-manualEntryDeliveryAddress")
    private WebElement manualEntryButton;

    public void setCountry(String countryValue) {
        driver.findElement(By.xpath("//a[@class='option-link'][contains(text(),'" + countryValue + "')]")).click();
    }

    public void clickOnManualEntryButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", manualEntryButton);
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
