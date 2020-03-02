package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles", glue="stepDefinitionsupplier",dryRun=false,plugin={"html:target/cucumber.reports"})
public class Loginsupp {

}
