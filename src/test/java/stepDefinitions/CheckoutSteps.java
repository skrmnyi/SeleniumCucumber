package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CheckoutSteps {
    private static WebDriver driver;
    private final static String baseUrl = "https://www.bookdepository.com/";

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
        if (pageValue.contains(pageValue)) {
            String expectedSearchUrl = "https://www.bookdepository.com/search?searchTerm=";
            Assertions.assertTrue(driver.getCurrentUrl().contains(expectedSearchUrl));
        }
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(DataTable expectedBooks) {
        SearchPage searchPage = new SearchPage(driver);
        Assertions.assertEquals(searchPage.foundedBooksOnTheSearchPage(), (expectedBooks).asList());
    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(DataTable filterParams) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.filterSearhResultsUsingAllFilters(filterParams.cell(0, 0),
                filterParams.cell(0, 1), filterParams.cell(1, 0),
                filterParams.cell(1, 1), filterParams.cell(2, 0),
                filterParams.cell(2, 1), filterParams.cell(3, 0),
                filterParams.cell(3, 1));
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
            String expectedBaskethUrl = "https://www.bookdepository.com/basket";
            Assertions.assertTrue(driver.getCurrentUrl().contains(expectedBaskethUrl));
        }
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(DataTable orderCostData) {
        List<Map<String, String>> orderSummary = orderCostData.asMaps();
        BasketPage basketPage = new BasketPage(driver);
        Assertions.assertEquals(orderSummary.get(0).get("Delivery cost"), basketPage.deliveryValue);
        Assertions.assertEquals(orderSummary.get(0).get("Total"), basketPage.totalValue);
    }

    @And("I click ‘Checkout’ button on ‘Basket’ page")
    public void iClickCheckoutButtonOnBasketPage() {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.clickOnCheckOutButton();
    }

    @And("I checkout as a new customer with email {string} and {string} phone number")
    public void iCheckoutAsANewCustomerWithEmailAndPhoneNumber(String email, String phone) {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillEmailAndPhone(email, phone);
    }

    @And("I fill delivery address information manually:")
    public void iFillDeliveryAdressInformationManually(DataTable checkoutValues) {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillDeliveryData(checkoutValues.cell(1, 0));
        paymentPage.setCountry(checkoutValues.cell(1, 1));
        paymentPage.clickOnManualFillingAddressButton();
        paymentPage.fillDeliveryData(checkoutValues.cell(1, 2), checkoutValues.cell(1, 3),
                checkoutValues.cell(1, 4),
                checkoutValues.cell(1, 5), checkoutValues.cell(1, 6));
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(DataTable checkoutValues) {
        List<Map<String, String>> orderSummaryData = checkoutValues.asMaps();
        PaymentPage paymentPage = new PaymentPage(driver);
        Assertions.assertEquals(paymentPage.orderSummaryValues("Sub-total"), orderSummaryData.get(0).get("Sub-total"));
        Assertions.assertEquals(paymentPage.orderSummaryValues("Delivery"), orderSummaryData.get(0).get("Delivery"));
        Assertions.assertEquals(paymentPage.orderSummaryValues("VAT"), orderSummaryData.get(0).get("Vat"));
        Assertions.assertEquals(paymentPage.orderSummaryValues("Total"), orderSummaryData.get(0).get("Total"));
    }

    @And("{string} message displayed once click on Buy Now button")
    public void messageDisplayedOnceClickOnBuyNowButton(String warningMessage) {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickOnBuyButton();
        Assertions.assertTrue(paymentPage.checkWarningMessage().toString().contains(warningMessage));
    }

    @And("‘Delivery Adress’ is the same as Payment checkbox is enabled")
    public void deliveryAdressIsTheSameAsPaymentCheckboxIsEnabled() throws InterruptedException {
        PaymentPage paymentPage = new PaymentPage(driver);
        Assertions.assertTrue(driver.findElement(paymentPage.useSameAddressCheckbox).isEnabled());
        TimeUnit.SECONDS.sleep(2);
    }

    @And("I enter my card details")
    public void iEnterMyCardDetails(DataTable cardDetails) {
        Map<String, String> paymentDetails = cardDetails.asMap();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillCardNumberField(paymentDetails.get("cardNumber"));
        paymentPage.fillCardNumberField(paymentDetails.get("ExpiryDateMMY/YY"));
        paymentPage.fillCardNumberField(paymentDetails.get("Cvv"));

        driver.quit();
    }
}
