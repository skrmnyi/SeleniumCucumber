package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

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

    @And("I search for an item with name {productName}")
    public void searchBook() {
        homePage.fillSearchItemUput("Thinking in Java”");
    }

    @And("I am redirected to a “Search Page”")
    public void redirectToSearchPage() {
        homePage.clickOnSearchButton();
    }

    @Given("Search results contain the following products")
    public void search_results_contain_the_following_products(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }


}
