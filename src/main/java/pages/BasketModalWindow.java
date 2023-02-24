package pages;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BasketModalWindow extends ConfigPage {
    public BasketModalWindow(WebDriver driver) {
        super(driver);
    }

    public void selectButtonOnBasketModal(String buttonName) {
        driver.findElement(By.xpath("//span[@id=\"basket-total-cost\"]" +
                "/following::a[@data-default-localized-pattern='" + buttonName + "']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
