package ru.nsu.fit.services.browser;

import java.io.File;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.nsu.fit.shared.ImageUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Browser implements Closeable {
    private WebDriver webDriver;
    private static ChromeDriverService service;
    private By inputElement;

    public Browser() {
        // create profile
        //FirefoxProfile profile = new FirefoxProfile();

        // create web driver

        System.setProperty("webdriver.chrome.driver", "C:\\verman");
        try {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("C:\\verman\\chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            webDriver = new ChromeDriver(service);

            webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Browser openPage(String url) {
        webDriver.get(url);
        return this;
    }

    public Browser waitForElement(By element) {
        return waitForElement(element, 10);
    }

    public Browser waitForElement(final By element, int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public Browser click(By element) {
        webDriver.findElement(element).click();
        return this;
    }

    public Browser typeText(By element, String text) {
        webDriver.findElement(element).sendKeys(text);
        return this;
    }

    public WebElement getElement(By element) {
        return webDriver.findElement(element);
    }

    public String getValue(By element) {
        return getElement(element).getAttribute("value");
    }

    public List<WebElement> getElements(By element) {
        return webDriver.findElements(element);
    }

    public boolean isElementPresent(By element) {
        return getElements(element).size() != 0;
    }

    public byte[] makeScreenshot() {
        try {
            return ImageUtils.toByteArray(((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void setInputElement(By inputElement){
        this.inputElement = inputElement;
    }

    public void klick_imitation(By elemnt){
        click(elemnt);
    }

    public String get_value(){
        return getValue(inputElement);
    }

    public void insert_value(String value){
        typeText(inputElement, value);
    }

    @Override
    public void close() {
        webDriver.close();
    }
}
