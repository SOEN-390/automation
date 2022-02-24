package pageObjects.login;

import controls.FileReaderControl;
import galen.locators.LocatorMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginWithEmail {
    WebDriver driver;
    LocatorMap element;
    Map<String, Pair<String, String>> galenLocators;

    public LoginWithEmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        element = new LocatorMap(driver);
    }

    @FindBy(xpath = "//*[@id='email']/input")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[@id='password']/input")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@id='main']/ion-app/ion-content/div/ion-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[contains(text(),'problem')]")
    private WebElement errorMessage;


    public Map<String, Pair <String, String>> getLocators(){
        galenLocators = new HashMap<>();
        galenLocators.put("emailInputField", element.getLocator(emailInputField));
        galenLocators.put("passwordInputField", element.getLocator(passwordInputField));
        galenLocators.put("loginBtn", element.getLocator(loginBtn));
        galenLocators.put("errorMessage", element.getLocator(errorMessage));
        return galenLocators;

    }

    public WebElement getEmailInputField() {
        return emailInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }



    public String getLayoutSpec() {
        String baseFolder = this.getClass().getPackage().getName().replace(".", File.separator);
        String specPath = "src" + File.separator + "main" + File.separator + "java" + File.separator + baseFolder + File.separator + "LoginWithEmail.gspec";
        File file = new File(specPath);
        return file.getAbsolutePath();
    }

    public void enterEmail(String email){
        emailInputField.sendKeys(email);
    }

    public void enterPassword(String password){

        passwordInputField.sendKeys(password);
    }

    public void clickOnLoginBtn(){

        loginBtn.submit();
        //Wait.pageBeLoadedCompletely(driver);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }

    public Boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch(Exception exception){
            throw new RuntimeException("Something went wrong, the element I expected to check is not in the DOM:" + errorMessage);
        }
    }

    public void launchLoginPage() {
        driver.get(FileReaderControl.getInstance().getConfigReader().getApplicationUrl());
        //driver.Wait.forThePageCompletelyLoaded();
    }


}
