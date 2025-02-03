package org.seleniumlearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GuviSeleniumWebComponentTask3 {

    static WebDriver driver;

    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.guvi.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Guvilocator();

    }

    public static void Guvilocator(){

        WebElement signupButton = driver.findElement(By.xpath("//div//a[contains(text(),'Sign up')]"));
        signupButton.click();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("JeganGbuicce");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gj151020022@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jegan@2002");
        driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("8838765454");
        WebElement signupbtn = driver.findElement(By.xpath("//div//a[@id='signup-btn']"));
        signupbtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().back();

        WebElement loginButton = driver.findElement(By.xpath("//div//a[@id='login-btn']"));
        loginButton.click();

        driver.findElement(By.id("email")).sendKeys("gj15102002@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Jegan@2002");

        WebElement loginbtn = driver.findElement(By.id("login-btn"));
        loginbtn.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("dashboard")) {
            System.out.println("✅ Login Successful!");
        } else {
            System.out.println("❌ Login Failed!");
        }



    }
}
