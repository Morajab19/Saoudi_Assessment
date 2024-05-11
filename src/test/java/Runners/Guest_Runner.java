package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/main/resources/Features/GuestCheckout.feature",
        glue = "StepDefinitions")
public class Guest_Runner {
}
