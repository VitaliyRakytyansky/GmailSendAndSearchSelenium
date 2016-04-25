package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Winterfall on 21.04.2016.
 */
public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public static WebElement assertThat(ExpectedCondition condition, int timeout) {
        return (new WebDriverWait(getWebDriver(), timeout).until(condition));
    }

    public static WebElement assertThat(ExpectedCondition condition){
        return assertThat(condition, 4);
    }

    public static WebElement $(String cssSelector){
        return $(byCss(cssSelector));
    }

    public static WebElement $(By locator){
        return assertThat(visibilityOfElementLocated(locator));
    }

    public static WebElement $(WebElement element){
        return assertThat(visibilityOf(element));
    }

    public static By byCss(String cssSelector){
        return By.cssSelector(cssSelector);
    }

    public static By byText(String text) {
        return By.xpath(".//*[contains(text(),'" + text + "')]");
    }

    public void open(){
        getWebDriver().get("http://gmail.com");
    }

}
