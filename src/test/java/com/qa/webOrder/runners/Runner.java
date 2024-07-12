package com.qa.webOrder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/qa/webOrder/stepDefinitions",
        dryRun = false,
        tags = "@regressionWebOrder",
        plugin = {"pretty", "html:target/uiReport.html","rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}
)

public class Runner {

}
