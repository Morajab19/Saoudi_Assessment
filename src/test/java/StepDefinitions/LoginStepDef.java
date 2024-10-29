package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddToCartStepDef {

    LoginPage loginPage;
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(Initiate.driver, timeout);
    @Given("user navigates to Login page")
    public void initCart() throws InterruptedException {
        loginPage = new LoginPage(Initiate.driver);    }

    @When("^user enter username \"(.*)\" and enter password \"(.*)\"$")
    public void typeValid(String user , String pass){
        loginPage.enterEmail().sendKeys(user);
        loginPage.enterPassword().sendKeys(pass);
    }
    @And("user click login")
    public void clickLogin(){
        loginPage.clickLogin().click();
    }
    @Then("a div containing text: Swag Labs is visible.")
    public void checkVisable(){
        Assert.assertEquals("Swag Labs" , loginPage.HeaderMessage().getText());
    }
    @Then("a div with clas containing a message Epic sadface: Username and password do not match any user in this service is visible.")
    public void checkVisableErr(){
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service" , loginPage.LoginMessage().getText());
    }

}
