package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchPage extends ConfigPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement finbBookByDateAndName(String date, String name) {
        return driver.findElement(By.xpath("//div[@class='item-info']/p[contains(text(),'" + date + "')]" +
                "/parent::div/h3/a[contains(text(),'" + name + "')]"));
    }

    public List<String> foundedBooksOnTheSearchPage() {
        List<String> bookElements = new ArrayList<>();
        bookElements.addAll(Arrays.asList(finbBookByDateAndName("10 Feb 2006", "Thinking in Java").getText().trim(),
                finbBookByDateAndName("14 Oct 2017", "Thinking Java Part I").getText().trim(),
                finbBookByDateAndName("04 Sep 2014", "Core Java Professional").getText().trim()));
        return bookElements;
    }

    @FindBy(xpath = "//select[@id=\"filterPrice\"]")
    private WebElement filterPriceRangeDropDown;

    @FindBy(xpath = "//select[@id=\"filterPrice\"]/option[contains(text(),'30 € +')]")
    private WebElement filterPriceRangeDropDownValue;

    @FindBy(xpath = "//select[@id=\"filterAvailability\"]")
    private WebElement filterAvailabilityDropDown;

    @FindBy(xpath = "//select[@id=\"filterLang\"]")
    private WebElement filterLanguageDropDown;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"][contains(text(),'Refine results')]")
    private WebElement refineResultsButton;

    public void filterSearhResultsByParameters(String filterDropDown, String filterDropDownValue) {
        driver.findElement(By.xpath("//label[text()='" + filterDropDown + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + filterDropDown + "']/" +
                "parent::div/select/option[contains(text(),'"+filterDropDownValue+"')]")).click();


    }
}
