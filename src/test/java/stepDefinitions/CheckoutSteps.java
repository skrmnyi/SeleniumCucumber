package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasketModalWindow;
import pages.HomePage;
import pages.SearchPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CheckoutSteps {

    public WebDriver driver;
    private final String baseUrl = "https://www.bookdepository.com/";


    @Given("I am an anonymous customer with clear cookies")
    public void launchBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @And("I open the {string}")
    public void openInitialPage(String url) {
        driver.get(baseUrl);
    }

    @And("I search for {string}")
    public void searchBook(String book) {
        HomePage homePage = new HomePage(driver);
        homePage.fillSearchItemInput(book);
    }

    @And("I am redirected to a {string}")
    public void iAmRedirectedToASearchPage(String pageValue) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchButton();
        if (pageValue.contains("Search Page")) {
            String expectedSearchUrl = "https://www.bookdepository.com/search?searchTerm=";
            Assertions.assertTrue(driver.getCurrentUrl().contains(expectedSearchUrl));
        }
    }


    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(DataTable expectedBooks) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.foundedBooksOnTheSearchPage().contains(expectedBooks.asList());
    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(DataTable filterParams) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.filterSearhResultsUsingAllFilters(filterParams.cell(0, 0).toString(), filterParams.cell(0, 1).toString(), filterParams.cell(1, 0).toString(), filterParams.cell(1, 1).toString(), filterParams.cell(2, 0).toString(), filterParams.cell(2, 1).toString(), filterParams.cell(3, 0).toString(), filterParams.cell(3, 1).toString());
    }

    @And("I click {string} button for a product with the name {string}")
    public void iClickButtonForAProductWithTheName(String buttonName, String bookName) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.addToBusketSpecificBok(bookName, buttonName).click();
    }

    @And("I select {string} in the basket pop-up")
    public void iSelectInTheBasketPopUp(String buttonName) {
        BasketModalWindow basketModalWindow = new BasketModalWindow(driver);
        basketModalWindow.selectButtonOnBasketModal(buttonName);
    }

    @And("I am redirected to the {string}")
    public void iAmRedirectedToThe(String pageValue) {
        if (pageValue.contains("Basket Page")) {
            String expecteBaskethUrl = "https://www.bookdepository.com/basket";
            Assertions.assertEquals(driver.getCurrentUrl(), expecteBaskethUrl);
        }
    }
}
