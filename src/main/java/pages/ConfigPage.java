package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class ConfigPage {
    protected WebDriver driver;
    public ConfigPage(WebDriver driver) {
        this.driver = driver;
    }
    public void smartWaiter(int pageLoadParameter) {
        new WebDriverWait(driver, pageLoadParameter).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
