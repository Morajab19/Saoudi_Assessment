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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class GuestCheckoutStepDef {
    Checkout_Page checkoutPage;
    HomePage homePage;
    LoginPage loginPage;
    CartPage cartPage;
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(Initiate.driver, timeout);

    @Given("initiate guest checkout feature")
    public void initGuest(){
        homePage =new HomePage(Initiate.driver);
        cartPage = new CartPage(Initiate.driver);
        loginPage = new LoginPage(Initiate.driver);
        checkoutPage = new Checkout_Page(Initiate.driver);
    }
    @When("^guest enters the product name \"(.*)\"$")
    public void typeSearch(String item){
        homePage.enterItemToSearch().sendKeys(item);
    }
    @And("Clicks on search button")
    public void clickSearch() throws InterruptedException {
        homePage.clickSearch();
    }
    @When("Guest scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button")
    public void chooseItem() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)Initiate.driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        homePage.clickHomeAddToCart();
    }
    @And("^enters quantity of \"(.*)\" and click on ADD TO CART Button and open cart$")
    public void enterQuantity(String q)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_enteredQuantity_4")));
        homePage.enterQuantity().clear();
        homePage.enterQuantity().sendKeys(q);
        homePage.clickProductAddToCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]")));
        cartPage.closeNotification();
        cartPage.openCart();
    }
    @And("guest confirm the terms and click checkout button")
    public void checkout() throws InterruptedException {
        cartPage.checkout();
    }
    @And("choose to continue as a guest")
    public void guestLogin(){
        loginPage.guestLogin();
    }
    @And("^type the first name \"(.*)\", last name \"(.*)\", and the email \"(.*)\"$")
    public void sendPersonalInfo(String fname , String lname , String mail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_FirstName")));
        checkoutPage.enterFirstName().sendKeys(fname);
        checkoutPage.enterLastName().sendKeys(lname);
        checkoutPage.enterEmail().sendKeys(mail);
    }
    @And("^selects the country \"(.*)\", city \"(.*)\", address1 \"(.*)\", zip \"(.*)\", number \"(.*)\" and  click Continue$")
    public void sendAddressInfo(String country , String city , String address , String zip , String number ) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_CountryId")));
        checkoutPage.selectCountry(country);
        checkoutPage.enterCity().sendKeys(city);
        checkoutPage.enterAddress().sendKeys(address);
        checkoutPage.enterZip().sendKeys(zip);
        checkoutPage.enterNumber().sendKeys(number);
        checkoutPage.clickContinue();
    }
    @And("selects the next day air shipping methode and click continue")
    public void selectShippingMethode(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("shippingoption_0")));
        checkoutPage.selectShippingMethode();
    }
    @And("selects the check payment method and click continue")
    public void selectPayment() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_0")));
        checkoutPage.selectCheckPayment();
    }
    @And("^checks the order email \"(.*)\", number \"(.*)\" and click confirm$")
    public void confirmOrder(String mail , String number) throws InterruptedException {
        checkoutPage.clickConfirm();
    }
    @Then("the guest order is placed successfully")
    public void checkOrder(){
        SoftAssert soft =new SoftAssert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[1]/strong")));
        String actual = checkoutPage.getOrderMsg();
        String expected = "Your order has been successfully processed!";
        soft.assertEquals(actual,expected,"order is successfully placed");
        soft.assertAll();
    }

}
