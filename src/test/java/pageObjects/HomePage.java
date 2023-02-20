package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ConfigPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private WebElement searchInput = driver.findElement(By.xpath("//input[@name=\"searchTerm\"]"));
    private WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label=\"Search\"]"));

    public void fillSearchItemUput(String productName) {
        searchInput.sendKeys(productName);

    }
    public void clickOnSearchButton() {
        searchButton.click();
    }
}

