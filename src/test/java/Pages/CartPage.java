package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver=driver;
    }
    public void closeNotification(){driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();}
    public void openCart(){
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();}

    //check if the product is in cart
public Boolean itemsInCart(String itemName) {
        Boolean found = false;
        List<WebElement> items = driver.findElements(By.cssSelector("td[class=\"product\"]"));
    if(!items.isEmpty()) {
        for (WebElement item : items) {
            if(item.findElement(By.className("product-name")).getText().equals(itemName))
                found= true;
        }
    }
        return found;
}

public void updateItem(String quantity){
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys(quantity);
        driver.findElement(By.id("updatecart")).click();
}
public String getQuantity(){return driver.findElement(By.cssSelector("input[class=\"qty-input\"]")).getAttribute("value");}

    public void removeItem(){driver.findElement(By.className("remove-btn")).click();}

    public String checkDeleted(){
        return driver.findElement(By.className("no-data")).getText();
    }

    public Boolean itemsInWishlist(String itemName) {
        Boolean found = false;
        List<WebElement> items = driver.findElements(By.cssSelector("td[class=\"product\"]"));
        if(!items.isEmpty()) {
            for (WebElement item : items) {
                if(item.findElement(By.className("product-name")).getText().equals(itemName))
                    found= true;
            }
        }
        return found;
    }
    public Boolean itemsInCompareList(String name1 , String name2){
        Boolean found = false;
        if (driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a")).getText().equals(name1)
                && driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/a")).getText().equals(name2)
        ){
            found = true;
        }

            return found;
    }
    //Checkout

    public void checkout() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }
}
