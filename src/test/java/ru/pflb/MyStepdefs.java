package ru.pflb;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.LetterPage;
import ru.pflb.pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class MyStepdefs {

    WebDriver driver;
    AuthorizationPage authorizationPage;
    MainPage mainPage;
    LetterPage letterPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", MyStepdefs.class.getResource("geckodriver.exe").getFile());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
        letterPage = new LetterPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @When("^click button write letter$")
    public void clickButtonWriteLetter() throws Throwable{
        mainPage.getWriteLetterButton().click();
    }

    @Then("^write email recipient \"([^\"]*)\"$")
    public void writeEmailRecipient(String recipient) throws Throwable{
        letterPage.recipient.sendKeys(recipient);
    }

    @And("^write message subject topic \"([^\"]*)\"$")
    public void writeMessageSubjectTopic(String topic) throws Throwable{
        letterPage.topicField.sendKeys(topic);
    }

    @And("^write text \"([^\"]*)\"$")
    public void writeText(String text) throws Throwable{
        letterPage.bodyOfLetter.sendKeys(text);
    }

//    @And("^wait \"([^\"]*)\" seconds$")
//    public void waitSeconds(int wait) throws Throwable{
//        TimeUnit.SECONDS.sleep(wait);
//    }

    @And("^click button draft$")
    public void clickButtonDraft() throws Throwable{
        mainPage.draft.click();
        if(mainPage.saveWindow.isDisplayed())
            mainPage.saveAndGo.click();
    }

    @And("^recipient starts with \"([^\"]*)\"$")
    public void recipientEqualsTo(String recepient) throws Throwable{
        do{
            mainPage.refresh.click();
        }
        while(!mainPage.newLetter.isDisplayed());
        assertThat(recepient, startsWith(mainPage.recipient.getText()));
    }

    @And("^topic equals to \"([^\"]*)\"$")
    public void topicEqualsTo(String topic) throws Throwable{
        assertThat(mainPage.topic.getText(), equalTo(topic));
    }

    @And("^body starts with \"([^\"]*)\"$")
    public void bodyEqualsTo(String body) throws Throwable{
        assertThat(body, startsWith(mainPage.body.getText()));
    }

    @And("^click checkbox and click remove$")
    public void clickCheckbox() throws Throwable{
        mainPage.checkbox.click();
        mainPage.delete.click();
    }
}
