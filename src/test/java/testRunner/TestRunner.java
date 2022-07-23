package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;



@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(
        features="src/test/java/features/SwiggyFeatures.feature",
        glue="stepDefinitions",
        plugin = {"pretty","html:target/cucumber-report1.html"},
        monochrome=true
        )

public class TestRunner {
	
	
	

}
