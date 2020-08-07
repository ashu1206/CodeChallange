package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"pretty", "html:target/cucumber_html_report", "json:target/cucumber.json", "junit:target/cucumber_junit/cucumber_junit.xml"},
		features = "src/test/java",
		tags= {"@runall"},
		glue = {"stepDefinition"},
		monochrome= true,
		dryRun=false,
		strict = true
		)

public class TestRunner {

}
