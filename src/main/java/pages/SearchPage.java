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


    public void filterSearhResultsUsingAllFilters(String filterName1, String filterValue1, String filterName2, String filterValue2,
                                                  String filterName3, String filterValue3, String filterName4, String filterValue4) {
        driver.findElement(By.xpath("//label[text()='" + filterName1 + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName1 + "']/" +
                "parent::div/select/option[contains(text(),'" + filterValue1 + "')]")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName2 + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName2 + "']/" +
                "parent::div/select/option[contains(text(),'" + filterValue2 + "')]")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName3 + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName3 + "']/" +
                "parent::div/select/option[contains(text(),'" + filterValue3 + "')]")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName4 + "']/parent::div/select")).click();
        driver.findElement(By.xpath("//label[text()='" + filterName4 + "']/" +
                "parent::div/select/option[contains(text(),'" + filterValue4 + "')]")).click();
        driver.findElement(By.xpath("//div[@class=\"form-group padded-btn-wrap\"]/button")).click();
    }

    public WebElement addToBusketSpecificBok(String book, String buttonName) {
        return driver.findElement(By.xpath("//meta[@content='" + book + "']/following-sibling::div/div" +
                "/a[contains(text(),'" + buttonName + "')]"));
    }
}

