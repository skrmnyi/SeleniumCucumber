package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CheckoutSteps {

    public WebDriver driver;

    final String baseUrl = "https://www.bookdepository.com/";
    final String searchUrl = "https://www.bookdepository.com/search?searchTerm=";

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
    public void iAmRedirectedToASearchPage(String searchUrl) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchButton();
        driver.getPageSource().contains(searchUrl);
    }


    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(DataTable expectedBooks) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.foundedBooksOnTheSearchPage().contains(expectedBooks.asList());
    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(DataTable filterParams) {
        SearchPage searchPage = new SearchPage(driver);
//        searchPage.filterSearhResultsByParameters(filterParams.cell(0, 0).toString(),
//                filterParams.cell(0, 1).toString());
//        searchPage.filterSearhResultsByParameters(filterParams.cell(1, 0).toString(),
//                filterParams.cell(1, 1).toString());
//        searchPage.filterSearhResultsByParameters(filterParams.cell(2, 0).toString(),
//                filterParams.cell(2, 1).toString());
//        searchPage.filterSearhResultsByParameters(filterParams.cell(3, 0).toString(),
//                filterParams.cell(3, 1).toString());

        searchPage.filterSearhResultsUsingAllFilters(filterParams.cell(0, 0).toString(),
                filterParams.cell(0, 1).toString(), filterParams.cell(1, 0).toString(),
                filterParams.cell(1, 1).toString(), filterParams.cell(2, 0).toString(),
                filterParams.cell(2, 1).toString(), filterParams.cell(3, 0).toString(),
                filterParams.cell(3, 1).toString());
    }


}




