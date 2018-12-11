package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import ru.pflb.pages.MainPage;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class MainPageSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(MainPageSteps.class);

    MainPage mainPage;

    public MainPageSteps(Context context){
        super(context);
        LOGGER.debug("MainPageSteps is created");
        mainPage = context.getPageObjectManager().getMainPage();
    }

    @When("^click button write letter$")
    public void clickButtonWriteLetter() throws Throwable{
        mainPage.getWriteLetterButton().click();
    }

    @Then("^login \"([^\"]*)\" appears near avatar$")
    public void loginAppearsNearAvatar(String login) throws Throwable{
        WebElement userNameElement = mainPage.getUserNameElement();
        assertThat(userNameElement.isDisplayed(), equalTo(true));
        assertThat(userNameElement.getText(), equalTo(login));
    }

    @And("^click button draft$")
    public void clickButtonDraft() throws Throwable{
        mainPage.draft.click();
        if(mainPage.saveWindow.isDisplayed())
            mainPage.saveAndGo.click();
    }

    @And("^recipient should starts with \"([^\"]*)\"$")
    public void recipientStartsTo(String recipient) throws Throwable{
        do{
            mainPage.refresh.click();
        }
        while(! mainPage.newLetter.isDisplayed());
        assertThat(recipient, startsWith(mainPage.recipient.getText()));
    }

    @And("^topic should starts with \"([^\"]*)\"$")
    public void topicStartsWith(String topic) throws Throwable{
        assertThat(mainPage.topic.getText(), equalTo(topic));
    }

    @And("^body should starts with \"([^\"]*)\"$")
    public void bodyEqualsTo(String body) throws Throwable{
        assertThat(body, startsWith(mainPage.body.getText()));
    }

    @And("^delete letter$")
    public void deleteLetter() throws Throwable{
        mainPage.checkbox.click();
        mainPage.delete.click();
    }

    @When("^click to user avatar$")
    public void clickToUserAvatar() throws Throwable{
        mainPage.userAvatar.click();
    }

    @And("^click exit services Yandex$")
    public void clickExitServicesYandex() throws Throwable{
        mainPage.logOut.click();
    }
}