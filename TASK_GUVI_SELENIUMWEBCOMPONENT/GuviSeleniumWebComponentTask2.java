package org.seleniumlearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.time.Duration;

import static org.seleniumlearning.SeleniumSetUp.waitforfixtime;

public class GuviSeleniumWebComponentTask2 {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source,target).perform();

        String targetText = target.getText();
        if(targetText.equals("Dropped!")){
            System.out.println("Drag and Drop Successfull");
        }
        else{
            System.out.println("Drag and Drop failed");
        }

        String bgcolor = target.getCssValue("background-color");
        System.out.println("Background color after drop : " + bgcolor);

        driver.quit();

    }

//    public static void waitForFixTime(int Timeinmilliseconds) {
//        try {
//            Thread.sleep(Timeinmilliseconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
