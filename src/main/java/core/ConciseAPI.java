package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Winterfall on 21.04.2016.
 */
public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public <V> V assertThat(ExpectedCondition<V> condition, int timeout) {
        return (new WebDriverWait(getWebDriver(), timeout).until(condition));
    }

    public WebElement $(By locator) {
        return assertThat(visibilityOfElementLocated(locator));
    }

    public WebElement $(String cssSelector) {
        return $(byCss(cssSelector));
    }

    public By byCss(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public By byExactText(String text) {
        return By.xpath(".//*[text()='" + text + "']");
    }

    public By byText(String text) {
        return By.xpath(".//*[contains(text(),'" + text + "')]");
    }

    public void open(String url) {
        getWebDriver().get(url);
    }
}


