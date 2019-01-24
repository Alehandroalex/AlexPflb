package ru.pflb.tech.step;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static ru.pflb.tech.configuration.Configuration.TEST_ATTACHMENTS_FOLDER;

public abstract class BaseStep {

    private static final DateTimeFormatter DATE_TIME_SCREENSHOT = DateTimeFormatter.ofPattern("YYYY.MM.DD-HH.mm.ss");
    protected final Context context;
    private final File testAttachmentsFolder = new File(String.format("%s/%s-%s",
            TEST_ATTACHMENTS_FOLDER,
            LocalDateTime.now().format(DATE_TIME_SCREENSHOT), UUID.randomUUID().toString()));

    public BaseStep(Context context){
        this.context = context;
    }

    public WebDriver getDriver(){
        return this.context.getDriver();
    }

    public void takeScreenshot(String name){
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String fileName = String.format("%s-%s-%s.png", LocalDateTime.now().format(DATE_TIME_SCREENSHOT), name,
                UUID.randomUUID().toString());
        try{
            FileUtils.copyFile(scrFile, new File(testAttachmentsFolder, fileName));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void takeScreenshot(){
        takeScreenshot("screenshot");
    }

}