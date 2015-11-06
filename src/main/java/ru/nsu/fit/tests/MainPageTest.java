package ru.nsu.fit.tests;

import org.openqa.selenium.By;
import ru.nsu.fit.services.browser.Browser;
import ru.nsu.fit.services.browser.BrowserService;
import ru.nsu.fit.shared.AllureUtils;


public class MainPageTest {
    private static final String PAGE_URL = "http://testmethods.tmweb.ru/";
    private Browser browser = null;
    private static final By inputElement = By.xpath("//input[@type='text' and @name='Input']");
    private static final By equalElement = By.xpath("//input[@type='button' and @name='DoIt']");

    public void start_test(){
        Browser browser = BrowserService.openNewBrowser();
        browser.openPage(PAGE_URL);
    }

    public void insert_value(String value){
        browser.typeText(inputElement, value);
    }

    public void klick_imitation(){
        browser.click(equalElement);
    }

    public String get_value(){
        return browser.getValue(inputElement);
    }

    public void makeScreen(String text){
        AllureUtils.saveImageAttach(text, browser.makeScreenshot());
    }

    public void addTextLog(String text){
        AllureUtils.saveTextLog(text);
    }
}
