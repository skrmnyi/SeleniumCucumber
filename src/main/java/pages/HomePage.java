package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ConfigPage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name=\"searchTerm\"]")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@aria-label=\"Search\"]")
    private WebElement searchButton;

    public void fillSearchItemInput(String productName) {
        searchInput.sendKeys(productName);
    }
    public void clickOnSearchButton() {
        searchButton.click();
    }
}

