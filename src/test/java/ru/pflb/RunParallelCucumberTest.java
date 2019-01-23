package ru.pflb;

import cucumber.api.cli.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.tech.configuration.Configuration;

public class RunParallelCucumberTest {

    private static final Logger LOGGER = LogManager.getLogger(RunParallelCucumberTest.class);

    public static void main(String[] args){
        String browsersParameter = System.getProperty("browsers", "firefox,chrome");
        String[] browsers = browsersParameter.split(",");

        for(String browser : browsers){
            new Thread(()->{
                try{
                    Configuration.setBrowser(browser);
                    Main.run(new String[]{"-g", "ru.pflb.steps", "src/test/resources/ru/pflb/features/"},
                            ClassLoader.getSystemClassLoader());
                } catch(Throwable e){
                    LOGGER.error(e);
                }
            }).start();
        }

    }

}