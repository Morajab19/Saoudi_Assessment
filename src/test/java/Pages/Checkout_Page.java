package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Checkout_Page {
    WebDriver driver;

    public Checkout_Page(WebDriver driver){this.driver=driver;}

    public void selectCountry(String country){
        Select select = new Select(driver.findElement(By.name("BillingNewAddress.CountryId")));
        select.selectByVisibleText(country);
    }
    public WebElement enterCity(){return driver.findElement(By.id("BillingNewAddress_City"));}

    public WebElement enterAddress(){return driver.findElement(By.id("BillingNewAddress_Address1"));}

    public WebElement enterZip(){return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));}

    public WebElement enterNumber(){return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));}
    public WebElement enterFirstName(){return driver.findElement(By.id("BillingNewAddress_FirstName"));}
    public WebElement enterLastName(){return driver.findElement(By.id("BillingNewAddress_LastName"));}
    public WebElement enterEmail(){return driver.findElement(By.id("BillingNewAddress_Email"));}


    public void clickContinue(){driver.findElement(By.name("save")).click();}

    public void selectShippingMethode(){
        driver.findElement(By.id("shippingoption_1")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
    }

    public void selectCheckPayment() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
    }
    public String mailInfo(){return driver.findElement(By.cssSelector("li[class=\"email\"]")).getText();}

    public String phoneInfo(){return driver.findElement(By.cssSelector("li[class=\"phone\"]")).getText();}

    public void clickConfirm() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
    }
    public String getOrderMsg(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]")).getText();}







}
