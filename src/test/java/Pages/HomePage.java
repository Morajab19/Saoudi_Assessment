package Pages;

import StepDefinitions.Initiate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collections;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){this.driver=driver;}

    public WebElement enterItemToSearch(){return Initiate.driver.findElement(By.id("small-searchterms"));}

    public void clickSearch(){driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();}
    public void clickHomeAddToCart(){driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[1]")).click();}
    public WebElement enterQuantity(){return Initiate.driver.findElement(By.xpath("//*[@id=\"product_enteredQuantity_4\"]"));}

    public void clickProductAddToCart(){driver.findElement(By.id("add-to-cart-button-4")).click();}

    public String getCartNotification(){return driver.findElement(By.id("bar-notification")).getText();}

}
