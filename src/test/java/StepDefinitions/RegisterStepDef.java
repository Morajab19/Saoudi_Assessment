package StepDefinitions;

import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class RegisterStepDef {

    RegisterPage registerPage;

    @Given("user navigates to registration page")
    public void openRegister(){
        registerPage = new RegisterPage(Initiate.driver);
        Initiate.driver.findElement(By.className("ico-register")).click();
    }
    @When("^user choose gender \"(.*)\" , enter firstname \"(.*)\" and enter lastname \"(.*)\"$")
    public void enterGender_fullName( String gen , String fname , String lname){
        registerPage.selectGender(gen);
        registerPage.enterFirstname().sendKeys(fname);
        registerPage.enterLastname().sendKeys(lname);
    }
    @And("^user enter date of birth day \"(.*)\" month \"(.*)\" year \"(.*)\"$")
    public void enterBDate(String day , String month , String year){
        registerPage.enterBirthdate(day,month,year);
    }
    @And("^user enter email \"(.*)\" , password \"(.*)\" and confirm with \"(.*)\"$")
    public void enterMail_pass(String email , String pass , String confirm){
        registerPage.enterEmail().sendKeys(email);
        registerPage.enterPassword().sendKeys(pass);
        registerPage.confirmPassword().sendKeys(confirm);
    }
    @And("click on register button")
    public void clickRegister(){
        registerPage.clickRegister();
    }
    @Then("user is registered successfully message appears")
    public void userMsg(){
        SoftAssert soft = new SoftAssert();
        String actual = registerPage.confimaationMsg();
        String expected = "Your registration completed";
        soft.assertEquals(actual,expected,"registration completed msg");
        soft.assertAll();
    }
}
