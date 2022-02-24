/*
The goal of PageObjectControl class is to avoid creating of the same object's page
again and again in the case of multiple test definition execution but to use a single
object in all (running) tests definition file (see folder testsDefinition package)
 EACH NEW PAGE OBJECT HAS TO BE ADDED HERE
 */

package controls;

import org.openqa.selenium.WebDriver;
import pageObjects.CommonElements;
import pageObjects.login.LoginWithEmail;


public class PageObjectControl {
    private WebDriver driver;
    private CommonElements commonElementsPage;
    private LoginWithEmail loginWithEmail;



    public PageObjectControl(WebDriver driver){
        this.driver = driver;
    }

    public PageObjectControl(){}

    public CommonElements getHomePage(){
        return (commonElementsPage == null) ? commonElementsPage = new CommonElements(driver) : commonElementsPage;
    }

    public LoginWithEmail getLoginWithEmailPage(){
        return (loginWithEmail == null) ? loginWithEmail = new LoginWithEmail(driver) : loginWithEmail;

    }


}
