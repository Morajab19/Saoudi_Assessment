package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectGender(String gen) {
        if ((gen.equals("female"))) {
            driver.findElement(By.cssSelector("input[value=\"F\"]")).click();
        } else if ((gen.equals("male"))) {
            driver.findElement(By.cssSelector("input[id=\"gender-male\"]")).click();
        }
    }


    public WebElement enterFirstname() {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement enterLastname() {
        return driver.findElement(By.id("LastName"));
    }

    public void enterBirthdate(String day, String month, String year) {
        Select s = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")));
        s.selectByIndex(Integer.parseInt(day));
        s = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
        s.selectByValue(month);
        s = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
        s.selectByVisibleText(year);
    }

    public WebElement enterEmail() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement enterPassword() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public void clickRegister() {
        driver.findElement(By.id("register-button")).click();
    }

    public String confimaationMsg() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();
    }
}


