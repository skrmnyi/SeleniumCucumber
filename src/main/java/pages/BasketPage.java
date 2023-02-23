package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasketPage extends pages.ConfigPage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String totalValue = driver.findElement(By.xpath("//dl[@class=\"total\"]/dd")).getText();
    public String deliveryValue = driver.findElement(By.xpath("//dl[@class=\"delivery-text\"]/dd")).getText();

}
