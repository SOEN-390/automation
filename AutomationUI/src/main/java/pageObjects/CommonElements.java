package pageObjects;

import galen.locators.LocatorMap;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CommonElements {
    WebDriver driver;
    Map<String, Pair<String, String>> locatorsList;
    LocatorMap element;

    public CommonElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        element = new LocatorMap(driver);
    }

}
