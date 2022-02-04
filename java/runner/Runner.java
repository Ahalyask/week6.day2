package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import steps.BaseClass;


@CucumberOptions(features="src/main/java/feature/CreateLead.feature"
				, glue="steps"
				, monochrome = true
				, dryRun = false
				, snippets = SnippetType.CAMELCASE
				,publish = true
				, tags = "@Smoke or @Regression")
public class Runner extends BaseClass{

}
