package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasketModalWindow extends ConfigPage {
    public BasketModalWindow(WebDriver driver) {
        super(driver);
    }

    public void selectButtonOnBasketModal(String buttonName) {
        driver.findElement(By.xpath("//span[@id=\"basket-total-cost\"]" +
                "/following::a[@data-default-localized-pattern='" + buttonName + "']")).click();
        smartWaiter(3);
    }
}

