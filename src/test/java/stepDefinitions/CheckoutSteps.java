package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


public class CheckoutSteps {
    WebDriver driver;
    HomePage homePage = new HomePage(driver);

    @Given("I am an anonymous customer with clear cookies")
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @And("I open the “Initial home page”")
    public void openHomePage() {
        driver.get("https://www.bookdepository.com");
    }

    @And("I search for “Thinking in Java”")
    public void searchBook() {
        homePage.fillSearchItemUput("Thinking in Java”");
    }

    @And("I am redirected to a “Search Page”")
    public void redirectToSearchPage() {
        homePage.clickOnSearchButton();
    }

    @And("Search results contain the following products")
    public void checkSearchResults() {
        List<String> expectedItemsResult = new ArrayList<>();
        SearchPage searchPage = new SearchPage(driver);
        List<String> expectedBooks = new ArrayList<>();
        expectedBooks.addAll(Arrays.asList("Thinking Java", "Thinking Java Part I", "Core Java Professional"));
        Assertions.assertEquals(expectedBooks, searchPage.getSearchResultItems());

    }
}

