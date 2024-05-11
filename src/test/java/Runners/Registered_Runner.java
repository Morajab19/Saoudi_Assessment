package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features ={ "src/main/resources/Features/F1Register.feature",
        "src/main/resources/Features/F2AddToCart.feature","src/main/resources/Features/F3Checkout.feature"},
        glue = "StepDefinitions")
public class Registered_Runner {

}
