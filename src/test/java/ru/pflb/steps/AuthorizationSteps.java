package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.HomePage;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

public class AuthorizationSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(AuthorizationSteps.class);

    AuthorizationPage authorizationPage;
    HomePage homePage;

    public AuthorizationSteps(Context context){
        super(context);
        LOGGER.debug("AuthorizationSteps is created");
        authorizationPage = context.getPageObjectManager().getAuthorizationPage();
    }

    @Given("^go to \"([^\"]*)\"$")
    public void goTo(String url) throws Throwable{
        getDriver().get(url);
    }

    @When("^click button enter$")
    public void clickButtonEnter() throws Throwable{
        authorizationPage.enterButton.click();
    }

    @And("^write login \"([^\"]*)\"$")
    public void writeLogin(String login) throws Throwable{
        authorizationPage.loginField.sendKeys(login);
    }

    @And("^write password \"([^\"]*)\"$")
    public void writePassword(String password) throws Throwable{
        if(! authorizationPage.passwordField.isDisplayed()){
            authorizationPage.enter.click();
        }
        authorizationPage.passwordField.sendKeys(password);
    }

    @And("^click button enter to mail$")
    public void clickButtonEnterToMail() throws Throwable{
        authorizationPage.enter.click();
    }

    @Then("^login \"([^\"]*)\" missing on screen$")
    public void loginMissingOnScreen(String arg0) throws Throwable{
        homePage.getToGetMail().isDisplayed();
    }
}