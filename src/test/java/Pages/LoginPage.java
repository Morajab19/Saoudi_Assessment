package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver ;
    public LoginPage(WebDriver driver){this.driver=driver;}

    public WebElement enterEmail(){return driver.findElement(By.id("Email"));}

    public WebElement enterPassword(){return driver.findElement(By.name("Password"));}

    public void clickLoginBtn(){driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();}

    //initiate valid login step to test other functionalities/features
    public void loginStep(){
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        enterEmail().sendKeys("MohammedRaja@gmail.com");
        enterPassword().sendKeys("Asdfgh");
        clickLoginBtn();
    }
    public void guestLogin(){
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

}
