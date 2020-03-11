package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"stepDefination"},
				plugin={"html:target/cucumber-html-report"})
public class TestRunner {
	

   
}
