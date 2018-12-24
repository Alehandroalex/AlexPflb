package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.models.Letter;
import ru.pflb.pages.LetterEditorPage;
import ru.pflb.pages.LetterViewerPage;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class LetterPageSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(LetterPageSteps.class);

    private LetterEditorPage letterEditorPage;
    private LetterViewerPage letterViewerPage;

    public LetterPageSteps(Context context){
        super(context);
        LOGGER.debug("LetterPageSteps is created");
        letterEditorPage = new LetterEditorPage(getDriver());
        letterViewerPage = new LetterViewerPage(getDriver());
    }

    @And("^add letter's \"([^\"]*)\" recipient \"([^\"]*)\"$")
    public void addLetterSRecipient(String letterAlias, String recipient){
        Letter letter = context.getLetter(letterAlias);
        if(letter.getRecipientList().size() > 0){
            letterEditorPage.recipientField.sendKeys(" ");
        }
        letterEditorPage.recipientField.sendKeys(recipient);
        letter.addRecipient(recipient);
    }

    @And("^set letter's \"([^\"]*)\" topic to \"([^\"]*)\"$")
    public void setLetterSTopicTo(String letterAlias, String topic){
        Letter letter = context.getLetter(letterAlias);
        letterEditorPage.topicField.sendKeys(topic);
        letter.setTopic(topic);
    }

    @And("^set letter's \"([^\"]*)\" body to \"([^\"]*)\"$")
    public void setLetterSBodyTo(String letterAlias, String body){
        Letter letter = context.getLetter(letterAlias);
        letterEditorPage.bodyField.sendKeys(body);
        letter.setBody(body);
    }

    @Then("^recipients in editor should be as in \"([^\"]*)\"$")
    public void recipientsInEditorShouldBeAsIn(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected recipient of letter: '{}', actual recipient of letter: '{}'", letterEditorPage.getRecipients(), letter.getRecipientList().toArray());
        assertThat(letterEditorPage.getRecipients(), containsInAnyOrder(letter.getRecipientList().toArray()));
    }

    @And("^topic in editor should be as in \"([^\"]*)\"$")
    public void topicInEditorShouldBeAsIn(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected topic of letter: '{}', actual topic of letter: '{}'", letterEditorPage.topicField.getText(), letter.getTopic());
        assertThat(letterEditorPage.topicField.getAttribute("value"), equalTo(letter.getTopic()));
    }

    @And("^body in editor should be as in \"([^\"]*)\"$")
    public void bodyInEditorShouldBeAsIn(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected body of letter: '{}', actual body of letter: '{}'", letterEditorPage.bodyField.getText(), letter.getBody());
        assertThat(letterEditorPage.bodyField.getAttribute("value"), startsWith(letter.getBody()));
    }

    @Then("^recipients in viewer should be as in \"([^\"]*)\"$")
    public void recipientsInViewerShouldBeAsIn(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected recipient of letter: '{}', actual recipient of letter: '{}'", letterViewerPage.getRecipients(), letter.getRecipientList().toArray());
        assertThat(letterViewerPage.getRecipients(), containsInAnyOrder(letter.getRecipientList().toArray()));
    }

    @And("^topic in viewer should be as in \"([^\"]*)\"$")
    public void topicInViewerShouldBeAsIn(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected topic of letter: '{}', actual topic of letter: '{}'", letterViewerPage.topic.getText(), letter.getTopic());
        assertThat(letterViewerPage.topic.getText(), equalTo(letter.getTopic()));
    }

    @And("^body in viewer should be as in \"([^\"]*)\"$")
    public void bodyInViewerShouldBeAsIn(String letterAlias){
        Letter letter = context.getLetter(letterAlias);
        LOGGER.info("Expected body of letter: '{}', actual body of letter: '{}'", letterViewerPage.body.getText(), letter.getBody());
        assertThat(letterViewerPage.body.getText(), equalTo(letter.getBody()));
    }

    @Then("^close the letter$")
    public void closeTheLetter(){
        //TODO Screenshot
        letterEditorPage.closeLetter.click();
    }


    @And("^send the letter$")
    public void sendTheLetter(){
        //TODO Screenshot
        letterEditorPage.sentLetter.click();
    }

    @When("^recipient should equals to \"([^\"]*)\"$")
    public void recipientShouldEqualsTo(String recipient){
        LOGGER.info("Expected recipient: '{}', actual recipient of letter: '{}'", recipient, letterEditorPage.recipientField.getText());
        assertEquals(recipient, letterEditorPage.recipientField.getText());
    }

    @And("^topic should equals to \"([^\"]*)\"$")
    public void topicShouldEqualsTo(String topic){
        LOGGER.info("Expected topic of letter: '{}', actual topic of letter: '{}'", topic, letterEditorPage.topicField.getText());
        assertEquals(topic, letterEditorPage.topicField.getText());
    }

    @And("^body should equals to \"([^\"]*)\"$")
    public void bodyShouldEqualsTo(String body){
        LOGGER.info("Expected body of letter: '{}', actual body of letter: '{}'", body, letterEditorPage.bodyField.getText());
        assertEquals(body, letterEditorPage.bodyField.getText());
    }

}