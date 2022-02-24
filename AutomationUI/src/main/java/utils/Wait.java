package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wait {

    public static void  untilPageLoadedCompletely(WebDriver driver){

        int timer = 0;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (!js.executeScript("return document.readyState").toString().equals("complete") && (timer < 6)){
            timer++;
            try {
                //Thread.sleep(1000);
                driver.manage().timeouts().implicitlyWait(1, SECONDS);
            }
            //catch (InterruptedException e) { e.printStackTrace(); }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (js.executeScript("return document.readyState").toString().equals("complete"))
            System.out.println("Page is ready to test...");
        else
            throw new WebDriverException("Page is not ready to test, it was waiting for 5 seconds to get the page fully loaded.");

    }

//    public static void untilElementPresent(WebDriver driver, WebElement element){
//        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//        wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
//    }

}
