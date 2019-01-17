package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import ru.pflb.models.Letter;
import ru.pflb.pages.main.MainPage;
import ru.pflb.pages.main.RowOfLetter;
import ru.pflb.tech.configuratin.Configuration;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class MainPageSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(MainPageSteps.class);

    private MainPage mainPage;

    public MainPageSteps(Context context){
        super(context);
        LOGGER.debug("MainPageSteps is created");
        mainPage = new MainPage(getDriver());
    }

    @And("^create letter \"([^\"]*)\"$")
    public void createLetter(String letterAlias){
        mainPage.getWriteLetterButton().click();
        context.addLetter(letterAlias, new Letter());
    }

    @And("^open the drafts' page$")
    public void openTHeDraftsPage(){
        mainPage.draft.click();
        //TODO Screenshot
        if(mainPage.saveWindow.isDisplayed()){
            mainPage.saveAndGo.click();
        }
    }

    @When("^click drafts' page$")
    public void clickDraftsPage(){
        mainPage.draft.click();
    }

    @Then("^wait for appearance of letter \"([^\"]*)\"$")
    public void waitForAppearanceOfLetter(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        do{
            mainPage.refresh.click();
        }
        while(! mainPage.hasRowLetterWithTopic(letter.getTopic()));
    }

    @Then("^should be letter \"([^\"]*)\"$")
    public void shouldBeLetter(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected topic: '{}', actual topic: '{}'", letter.getTopic(), mainPage.hasRowLetterWithTopic(letter.getTopic()));
        assertThat(String.format("Отсутствует письмо с темой '%s'", letter.getTopic()),
                mainPage.hasRowLetterWithTopic(letter.getTopic()), equalTo(true));
        RowOfLetter letterRow = mainPage.getRowLetterByTopic(letter.getTopic());
        LOGGER.info("Expected recipient: '{}', actual recipient: '{}'", letterRow.getRecipients(), letter.getRecipientList().toArray());
        assertThat(letterRow.getRecipients(), containsInAnyOrder(letter.getRecipientList().toArray()));
        LOGGER.info("Expected body: '{}', actual body: '{}'", letterRow.getBody(), letter.getBody());
        assertThat(letterRow.getBody(), equalTo(letter.getBody()));
    }

    @When("^open the letter \"([^\"]*)\"$")
    public void openTheLetter(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        //TODO Screenshot
        mainPage.getRowLetterByTopic(letter.getTopic()).open();
    }

    @And("^recipient should starts with \"([^\"]*)\"$")
    public void recipientStartsTo(String recipient){
        LOGGER.info("Expected recipient: '{}', actual recipient: '{}'", recipient, mainPage.recipient.getText());
        assertThat(recipient, startsWith(mainPage.recipient.getText()));
    }

    @And("^topic should starts with \"([^\"]*)\"$")
    public void topicStartsWith(String topic){
        LOGGER.info("Expected topic: '{}', actual topic: '{}'", mainPage.topic.getText(), topic);
        assertThat(mainPage.topic.getText(), equalTo(topic));
    }

    @And("^body should starts with \"([^\"]*)\"$")
    public void bodyEqualsTo(String body){
        LOGGER.info("Expected body: '{}', actual body: '{}'", body, mainPage.body.getText());
        assertThat(body, startsWith(mainPage.body.getText()));
    }

    @And("^delete the letter \"([^\"]*)\"$")
    public void deleteTheLetter(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        RowOfLetter letterRow = mainPage.getRowLetterByTopic(letter.getTopic());
        //TODO Screenshot
        letterRow.getCheckBox().click();
        mainPage.delete.click();
    }

    @And("^delete the letter in viewer$")
    public void deleteTheLetterInViewer(){
        //TODO Screenshot
        mainPage.delete.click();
    }

    @When("^open the page of sent letters$")
    public void openThePageOfSentLetters(){
        //TODO Screenshot
        mainPage.sent.click();
    }

    @Then("^user's login should be correct$")
    public void userSLoginShouldBeCorrect(){
        WebElement userNameElement = mainPage.getUserNameElement();
        LOGGER.info("Expected login: '{}', actual login: '{}'", Configuration.LOGIN, userNameElement.getText());
        assertThat(Configuration.LOGIN, equalTo(userNameElement.getText()));
    }

    @When("^exit from user account$")
    public void exitFromUserAccount(){
        //TODO Screenshot
        mainPage.getUserMenu().clickLogoutButton();
    }
}