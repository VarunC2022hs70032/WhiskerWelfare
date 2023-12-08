package com.sap.it.qe.pets.StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"StepDefinitions"},
        monochrome = true,
        plugin = { "pretty", "json:target/reports/cucumber.json"},
        tags="@smokeTest")
public class TestRunner {

}
