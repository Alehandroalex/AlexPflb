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
import ru.pflb.tech.konfiguratin.Configuration;
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

    @Then("^should be letter \"([^\"]*)\"$")
    public void shouldBeLetter(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        assertThat(String.format("Отсутствует письмо с темой '%s'", letter.getTopic()),
                mainPage.hasRowLetterWithTopic(letter.getTopic()), equalTo(true));
        RowOfLetter letterRow = mainPage.getRowLetterByTopic(letter.getTopic());
        assertThat(letterRow.getRecipients(), containsInAnyOrder(letter.getRecipientList().toArray()));
        assertThat(letterRow.getBody(), equalTo(letter.getBody()));
    }

    @When("^open the letter \"([^\"]*)\"$")
    public void openTheLetter(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        mainPage.getRowLetterByTopic(letter.getTopic()).open();
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

    @And("^delete the letter \"([^\"]*)\"$")
    public void deleteTheLetter(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        RowOfLetter letterRow = mainPage.getRowLetterByTopic(letter.getTopic());
        letterRow.getCheckBox().click();
        mainPage.delete.click();
    }

    @And("^delete the letter in viewer$")
    public void deleteTheLetterInViewer(){
        mainPage.delete.click();
    }

    @Then("^should appears the text \"([^\"]*)\"$")
    public void shouldAppearsTheText(String text) throws Throwable{
        mainPage.getElementWithText(text).isDisplayed();
    }

    @When("^open send's page$")
    public void openSendSPage() throws Throwable{
        mainPage.sent.click();
    }

    @Then("^user's login should be correct$")
    public void userSLoginShouldBeCorrect(){
        WebElement userNameElement = mainPage.getUserNameElement();
        LOGGER.info("Expected login: '{}', actual login: '{}'", userNameElement.getText(), Configuration.LOGIN);
        assertThat(userNameElement.getText(), equalTo(Configuration.LOGIN));
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