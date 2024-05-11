package StepDefinitions;

import Pages.CartPage;
import Pages.Checkout_Page;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckoutStepDef {
    Checkout_Page checkoutPage;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(Initiate.driver, timeout);
    @Given("initiate checkout")
    public void initCheckout() throws InterruptedException {
        checkoutPage=new Checkout_Page(Initiate.driver);
        homePage=new HomePage(Initiate.driver);
        loginPage =new LoginPage(Initiate.driver);
        cartPage=new CartPage(Initiate.driver);
        loginPage.loginStep();

    }
    @When("user navigates to cart page")
    public void openCart() {
        cartPage.openCart();
    }
    @When("user confirm the terms and click checkout button")
    public void checkout() throws InterruptedException {
        cartPage.checkout();
    }
    @And("^select the country \"(.*)\", city \"(.*)\", address1 \"(.*)\", zip \"(.*)\", number \"(.*)\" and  click Continue$")
    public void sendAddressInfo(String country , String city , String address , String zip , String number ) throws InterruptedException {
        Thread.sleep(2000);
        checkoutPage.selectCountry(country);
        Thread.sleep(2000);
        checkoutPage.enterCity().sendKeys(city);
        checkoutPage.enterAddress().sendKeys(address);
        checkoutPage.enterZip().sendKeys(zip);
        checkoutPage.enterNumber().sendKeys(number);
        checkoutPage.clickContinue();
    }
    @And("select the next day air shipping methode and click continue")
    public void selectShippingMethode() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("shippingoption_0")));
        checkoutPage.selectShippingMethode();
    }
    @And("select the check payment method and click continue")
    public void selectPayment() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_0")));
        checkoutPage.selectCheckPayment();
    }
    @And("^check the order email \"(.*)\", number \"(.*)\" and click confirm$")
    public void confirmOrder(String mail , String number) throws InterruptedException {
        checkoutPage.clickConfirm();
    }
    @Then("the order is placed successfully")
    public void checkOrder(){
        SoftAssert soft =new SoftAssert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[1]/strong")));
        String actual = checkoutPage.getOrderMsg();
        String expected = "Your order has been successfully processed!";
        soft.assertEquals(actual,expected,"order is successfully placed");
        soft.assertAll();
    }

}
