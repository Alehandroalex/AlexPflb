package ru.pflb.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import ru.pflb.models.Letter;
import ru.pflb.pages.main.MainPage;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

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

    @And("^create letter \"([^\"]*)\"$")
    public void createLetter(String letterAlias) throws Throwable{
        mainPage.getWriteLetterButton().click();
        context.addLetter(letterAlias, new Letter());
    }

    @And("^open drafts' page$")
    public void openDraftsPage() throws Throwable{
        mainPage.draft.click();
        if(mainPage.saveWindow.isDisplayed())
            mainPage.saveAndGo.click();
    }

    @Then("^wait for appearance of letter \"([^\"]*)\"$")
    public void waitForAppearanceOfLetter(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        do{
            mainPage.refresh.click();
        }
        while(! mainPage.hasRowLetterWithTopic(letter.getTopic()));
    }

    @And("^recipient should starts with \"([^\"]*)\"$")
    public void recipientStartsTo(String recipient) throws Throwable{
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

    @And("^delete the letter$")
    public void deleteTheLetter() throws Throwable{
        mainPage.checkbox.click();
        mainPage.delete.click();
    }

    @Then("^appears text \"([^\"]*)\"$")
    public void appearsText(String arg0) throws Throwable{
        mainPage.getLetterWasSent().isDisplayed();
    }

    @When("^click button send letters$")
    public void clickButtonSendLetters() throws Throwable{
        mainPage.sent.click();
    }

    @Then("^open the letter with topic \"([^\"]*)\"$")
    public void openTheLetterWithTopic(String topic) throws Throwable{
        mainPage.getRowLetterByTopic(topic).open();
    }

    @Then("^user's login should be \"([^\"]*)\"$")
    public void userSLoginShouldBe(String login){
        WebElement userNameElement = mainPage.getUserNameElement();
        assertThat(userNameElement.getText(), equalTo(login));
    }

    @When("^exit from user account$")
    public void exitFromUserAccount(){
        mainPage.getUserMenu().clickLogoutButton();
    }
}