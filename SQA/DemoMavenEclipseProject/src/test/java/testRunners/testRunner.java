package testRunners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Chamodi\\eclipse-workspace\\SQA\\DemoMavenEclipseProject\\resources\\features\\WelcomePage.feature",glue="stepDefinitions")
public class testRunner {

}


