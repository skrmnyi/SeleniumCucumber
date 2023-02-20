package pageObjects;

import org.openqa.selenium.WebDriver;

abstract class ConfigPage {
    protected WebDriver driver;

    public ConfigPage(WebDriver driver) {
        this.driver = driver;
    }
}

