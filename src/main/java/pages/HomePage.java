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
    @FindBy(how= How.ID, using="book-search-form")
    private WebElement searchInput;

    @FindBy(how=How.ID, using="inline-search-submit")
    WebElement logUser;

    @FindBy(xpath = "//button[@aria-label=\"Search\"]")
    private WebElement searchButton;

    public void fillSearchItemUput(String productName) {
        searchInput.sendKeys(productName);

    }
    public void clickOnSearchButton() {
        searchButton.click();
    }
}

