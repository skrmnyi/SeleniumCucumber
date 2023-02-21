package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class SearchPage extends ConfigPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[@class=\'title\']/a'")
    private List<WebElement> searchResultItems;

    public List<String> getSearchResultItems() {
        List<String> searchResultItem = searchResultItems.stream().map(eachItem -> eachItem.getText().trim()).collect(Collectors.toList());
        return searchResultItem;
    }
}
