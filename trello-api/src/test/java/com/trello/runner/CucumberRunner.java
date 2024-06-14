package com.trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber Runner.
 */
@CucumberOptions(
        plugin = {"pretty", "json:reports/cucumber.json",
                "junit:reports/cucumber.xml",
                "html:reports/cucumber-html-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources"},
        glue = {"com.trello"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}