package ru.pflb;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

import static ru.pflb.tech.configuration.Configuration.TEST_ATTACHMENTS_FOLDER;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, glue = {"ru.pflb.steps"})
public class RunCucumberTest {

    @BeforeClass
    public static void deleteScreenshot() throws IOException{
        FileUtils.cleanDirectory(new File(TEST_ATTACHMENTS_FOLDER));
    }

}