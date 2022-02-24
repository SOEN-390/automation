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

    @FindBy(xpath = "//aside/img[@alt]")
    private WebElement theLogo;

    @FindBy(xpath = "//header/div[@title]")
    private WebElement theUserIcon;

    @FindBy(css = "a[href*='/users']")
    private WebElement usersSiteMenu;

    @FindBy(css = "a[href*='/readers']" )
    private WebElement readersSiteMenu;

    @FindBy(css = "a[href*='/access-levels']" )
    private WebElement accLevelSiteMenu;

    @FindBy(css = "a[href*='/access-event']" )
    private WebElement monitoringSiteMenu;

    public Map<String, Pair<String, String>> getLocators(){
        locatorsList = new HashMap<>();
        locatorsList.put("theLogo", element.getLocator(theLogo));
        locatorsList.put("theUserIcon", element.getLocator(theUserIcon));
        locatorsList.put("usersSiteMenu", element.getLocator(usersSiteMenu));
        locatorsList.put("readersSiteMenu", element.getLocator(readersSiteMenu));
        locatorsList.put("accLevelSiteMenu", element.getLocator(accLevelSiteMenu));
        locatorsList.put("monitoringSiteMenu", element.getLocator(monitoringSiteMenu));

        return locatorsList;
    }

    public Boolean isUserIconDisplayed(){
        return theUserIcon.isDisplayed();
    }

    public void clickOnUserInSideMenu(){
        usersSiteMenu.click();
        driver.manage().timeouts().implicitlyWait(3,  TimeUnit.SECONDS);
    }

    public Boolean isUserMenuClickable(){
        return usersSiteMenu.isEnabled();
    }

    public Boolean isReaderMenuClickable(){
        return readersSiteMenu.isEnabled();
    }

    public Boolean isAccLevelMenuClickable(){
        return accLevelSiteMenu.isEnabled();
    }

    public Boolean isMonitoringMenuClickable(){
        return monitoringSiteMenu.isEnabled();
    }


}
