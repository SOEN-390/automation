package controls;

import enums.EnvType;
import enums.BrowserType;
import org.mozilla.javascript.tools.debugger.Dim;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class WebDriverControl {
    private WebDriver driver;
    private static BrowserType browserType;
    private static EnvType envType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private int width, height;
    private boolean maximaze = false;

    public WebDriverControl() {
        browserType = FileReaderControl.getInstance().getConfigReader().getBrowserType();
        envType = FileReaderControl.getInstance().getConfigReader().getEnvType();
    }

    public WebDriver getDriver() {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (envType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {

        throw new RuntimeException("Remote WebDriver is not implemented yet");
    }

    private WebDriver createLocalDriver() {
        switch (browserType) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:

                System.setProperty(CHROME_DRIVER_PROPERTY,FileReaderControl.getInstance().getConfigReader().getDriverDir()+"/chromedriver");
                ChromeOptions capability = new ChromeOptions();
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
                driver = new ChromeDriver(capability);
                driver.manage().deleteAllCookies();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
        }

        if (FileReaderControl.getInstance().getConfigReader().getWindowSize())
            driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

    public WebDriver setWindowSizeByType(String screenType){

        switch (screenType.toLowerCase()){

            case "ipad":
                driver.manage().window().setSize(new Dimension(768, 1024));
                driver.navigate().refresh();
                break;

            case "ipadpro":
                driver.manage().window().setSize(new Dimension(1024, 1336));
                driver.navigate().refresh();
                break;

            case "desktop":
                driver.manage().window().maximize();
                driver.navigate().refresh();
                break;

            case "surfaceduo":
                driver.manage().window().setSize(new Dimension(540, 720));
                driver.navigate().refresh();
                break;


            default:
                throw new IllegalArgumentException("Invalid screen type: " + screenType);
        }


        return driver;


    }



}
