package org.seleniumlearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class GUVITASKSeleniumLocator {

    static WebDriver driver;

    public static void main(String[] args) {
       question1fromSeleniumTask("https://www.google.com");
    question2fromSeleniumTask("https://www.demoblaze.com/");
        question3fromSeleniumTask("https://www.wikipedia.org/");
        driver.quit();
    }

    public static void instantiateBrowser(String baseURL){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    public static void question1fromSeleniumTask(String baseURl) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String CurrentURlPage = driver.getCurrentUrl();
        System.out.println("The URL of Current Page is :: " + CurrentURlPage);
        driver.navigate().refresh();
        driver.close();
    }

    public static void question2fromSeleniumTask(String baseURl) {
        instantiateBrowser(baseURl);
        String CurrentPageTitle = driver.getTitle();
        String CurrentpageURL = driver.getCurrentUrl();
        System.out.println("Current Page Title is:: " + CurrentPageTitle);
        if(CurrentPageTitle.equals("STORE")){
            System.out.println("Page landed on correct website");
        }
        else{
            System.out.println("Page not landed on correct website");
        }
        System.out.println("The URL of Current Page is :: " + CurrentpageURL);

        driver.close();
    }

    public static void question3fromSeleniumTask(String baseURL){
        instantiateBrowser(baseURL);

        WebElement searchbox = driver.findElement(By.id("searchInput"));
        searchbox.sendKeys("Artificial Intelligence");
        searchbox.sendKeys(Keys.ENTER);

        WebElement historysection = driver.findElement(By.linkText("History"));
        historysection.click();

        String currentPageTitle = driver.getTitle();

        System.out.println("Section Title :: " + currentPageTitle);

        driver.close();

    }
}
