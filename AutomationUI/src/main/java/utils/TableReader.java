package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class TableReader {
    WebDriver driver;

    public TableReader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
