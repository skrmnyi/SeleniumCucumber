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
        bookElements.addAll(Arrays.asList(finbBookByDateAndName("09 Mar 2006", "Thinking in Java").getText().trim(),
                finbBookByDateAndName("14 Oct 2017", "Thinking Java Part I").getText().trim(),
                finbBookByDateAndName("04 Sep 2014", "Core Java Professional").getText().trim()));
        return bookElements;
    }

    public void filterSearhResultsUsingAllFilters(String priceFilter, String priceValue, String availabilityFilter, String availabilityValue,
                                                  String languageFilter, String languageValue, String formatFilter, String formatValue) {
        driver.findElement(By.xpath("//label[text()='" + priceFilter + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + priceFilter + "']/" +
                "parent::div/select/option[contains(text(),'" + priceValue + "')]")).click();
        driver.findElement(By.xpath("//label[text()='" + availabilityFilter + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + availabilityFilter + "']/" +
                "parent::div/select/option[contains(text(),'" + availabilityValue + "')]")).click();
        driver.findElement(By.xpath("//label[text()='" + languageFilter + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + languageFilter + "']/" +
                "parent::div/select/option[contains(text(),'" + languageValue + "')]")).click();
        driver.findElement(By.xpath("//label[text()='" + formatFilter + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + formatFilter + "']/" +
                "parent::div/select/option[contains(text(),'" + formatValue + "')]")).click();
        driver.findElement(By.xpath("//div[@class=\"form-group padded-btn-wrap\"]/button")).click();
    }

    public WebElement addToBusketSpecificBok(String book, String buttonName) {
        return driver.findElement(By.xpath("//meta[@content='" + book + "']/following-sibling::div/div" +
                "/a[contains(text(),'" + buttonName + "')]"));
    }
}
