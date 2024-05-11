package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddToCartStepDef {
    CartPage cartPage;
    HomePage homePage;
    LoginPage loginPage;
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(Initiate.driver, timeout);
    @Given("initiate add item to cart feature")
    public void initCart() throws InterruptedException {
        homePage =new HomePage(Initiate.driver);
        cartPage = new CartPage(Initiate.driver);
        loginPage = new LoginPage(Initiate.driver);
        loginPage.loginStep();
    }

    @When("^user enters the product name \"(.*)\"$")
    public void typeSearch(String item){
        homePage.enterItemToSearch().sendKeys(item);
    }
    @And("Click on search button")
    public void clickSearch(){
        homePage.clickSearch();
    }
    @When("user scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button")
    public void chooseItem() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)Initiate.driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[1]")));
        homePage.clickHomeAddToCart();
    }
    @And("^enter quantity of \"(.*)\" and click on ADD TO CART Button and open cart$")
    public void enterQuantity(String q) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_enteredQuantity_4")));
        homePage.enterQuantity().clear();
        homePage.enterQuantity().sendKeys(q);
        homePage.clickProductAddToCart();
    }
    @Then("^the product \"(.*)\" is added successfully to the cart$")
    public void checkProductAdded(String productName) throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        String actual = homePage.getCartNotification();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]")));
        cartPage.closeNotification();
        cartPage.openCart();
        Thread.sleep(1000);
        soft.assertTrue(cartPage.itemsInCart(productName));
        System.out.println(cartPage.itemsInCart("Apple MacBook Pro 13-inch"));
        soft.assertAll();
    }


}
