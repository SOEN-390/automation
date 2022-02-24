package CovidTracker.testsDefinition;

import CovidTracker.dataFiles.LoginReader;
import cucumber.TestContent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.login.LoginWithEmail;

import java.io.IOException;

public class LoginWithEmailPageSteps {
    TestContent testContent;
    LoginWithEmail tester;
    LoginReader loginReader = new LoginReader();
//    HomePage homeTester;

    public LoginWithEmailPageSteps(TestContent test){
        testContent = test;
        tester = testContent.getPageObjectControl().getLoginWithEmailPage();
    }

    @Given("Person launched the login page")
    public void personLaunchedTheLoginPage() {

        tester.launchLoginPage();
    }

    @When("Person enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws IOException {
        tester.enterEmail(email);
        tester.enterPassword(password);
    }

    @When("Person enters valid Email and Password")
    public void user_enters_valid_email_and_password() throws IOException {
        String[] loginCred = loginReader.readLoginData("src/test/java/CovidTracker/dataFiles/loginData.csv", 1);

        tester.enterEmail(loginCred[0]);
        tester.enterPassword(loginCred[1]);
    }

    @When("Person enters invalid Email and Password from line {int}")
    public void user_enters_invalid_email_and_password(int line) throws IOException {
        String[] loginCred = loginReader.readLoginData("src/test/java/CovidTracker/dataFiles/wrongLoginData.csv", line);

        tester.enterEmail(loginCred[0]);
        tester.enterPassword(loginCred[1]);
    }

    @When("Person clicks on the Login button")
    public void clicks_on_the_login_button() {
        tester.clickOnLoginBtn();

//        testContent.getWebDriverControl().waitForPageBeLoadedCompletely();
    }

//    @Then("Home page is displayed")
//    public void home_page_is_displayed() {
//        Assert.assertTrue(homeTester.isHomeDiplayed());
//    }

    @Then("Error message is displayed")
    public void error_message_is_displayed() {
        Assert.assertTrue(tester.isErrorDisplayed());
    }



    @When("User changes screen resolution to {string}")
    public void user_changes_screen_resolution_to(String screenType) {
        testContent.getWebDriverControl().setWindowSizeByType(screenType);
    }


}
