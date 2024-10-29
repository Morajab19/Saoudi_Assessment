package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver ;
    public LoginPage(WebDriver driver){this.driver=driver;}

    public WebElement enterEmail(){return driver.findElement(By.id("user-name"));}
    public WebElement enterPassword(){return driver.findElement(By.id("password"));}

    public WebElement clickLogin(){return driver.findElement(By.id("login-button"));}

    public WebElement HeaderMessage(){return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));}

    public WebElement LoginMessage(){return driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));}

    }


