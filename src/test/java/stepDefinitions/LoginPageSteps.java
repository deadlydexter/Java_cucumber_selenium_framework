package stepDefinitions;

import cucumber.TestContext;
import dataProvider.LogFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;

public class LoginPageSteps {
    HomePage homePage;
    TestContext testContext;
    public LoginPageSteps(TestContext context){ testContext = context;}
    @Given("user is on the LoginPage")
    public void userIsOnTheLoginPage() {
        LogFile.info("This is the first step");
        homePage = testContext.getPageObjectManager().getHomePage();
        homePage.navigate_to_login_page();
    }

    @And("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        LogFile.info("User enters username and Password");
        homePage.enter_username();
        homePage.enter_password();

    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        homePage.click_login_btn();
    }

    @Then("user should land on the HomePage")
    public void userShouldLandOnTheHomePage() {
        homePage.validate_login();
    }
}
