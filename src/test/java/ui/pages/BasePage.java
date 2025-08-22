package ui.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.Driver;

import java.time.Duration;
import java.util.function.Function;

public abstract class BasePage implements Page {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;
    protected Faker faker;

    protected BasePage() {
        this.driver  = Driver.getDriver();                // Inheritance + Encapsulation
        this.wait    = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        this.faker = new Faker();
    }

    // ---------- Common wait helpers ----------
    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitGone(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected <V> V waitUntil(Function<? super WebDriver, V> condition) {
        return wait.until(condition);
    }

    // ---------- Common element actions ----------
    protected void click(By locator) {
        waitClickable(locator).click();
    }

    protected void type(By locator, CharSequence text) {
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String text(By locator) {
        return waitVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ---------- Navigation ----------
    protected void goTo(String url) {
        driver.navigate().to(url);
    }
}
