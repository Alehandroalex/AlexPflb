package ru.pflb;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, glue = {"ru.pflb.steps"}, tags = "@One")
public class RunCucumberTest {

}