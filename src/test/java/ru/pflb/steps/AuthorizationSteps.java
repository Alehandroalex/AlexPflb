package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

public class AuthorizationSteps extends BaseStep {

    AuthorizationPage authorizationPage;

    public AuthorizationSteps(Context context){
        super(context);
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
        authorizationPage.passwordField.sendKeys(password);
    }

    @And("^click button enter to mail$")
    public void clickButtonEnterToMail() throws Throwable{
        authorizationPage.enterToMail.click();
    }

}
