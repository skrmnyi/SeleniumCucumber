package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract class ConfigPage {
    protected WebDriver driver;
    public ConfigPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        this.driver = driver;
    }


}
