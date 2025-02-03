package org.seleniumlearning.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.seleniumlearning.SeleniumSetUp.waitforfixtime;

public class SeleniumWebComponentTask1 {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/resources/demos/datepicker/default.html')]")));
        waitforfixtime(2000);
        driver.findElement(By.id("datepicker")).click();
        waitforfixtime(4000);
        SelectDate("22");
        System.out.println("Selected date on Console as Output");
    }

    public static void SelectDate(String  date){
        List<WebElement> dates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for(int i = 0; i < dates.size(); i++){
            if(dates.get(i).getText().equalsIgnoreCase(date)){
                dates.get(i).click();
            }
        }
        driver.close();
    }
}
