package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class SeleniumBoilerPlate
{
    private WebDriver driver;
   
    @BeforeClass
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
    }
    @Test
    public void userLogin()
    {   
        System.out.println("TC_01 : Search for an item.");

        WebElement searchText = driver.findElement(By.name("q"));
        System.out.println("Search text entered.");
        searchText.sendKeys("Selenium Boilerplate");
        System.out.println("Click on submit button.");
        WebElement submitButton = driver.findElement(By.name("btnK"));
        submitButton.click();
        System.out.println("Clicked Submit button.");
        System.out.println("TC_01 : PASSED!");

        System.out.println("TC_02 : Verify search result is displayed.");
        
        System.out.println("Current Title is:" + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Selenium Boilerplate - Google Search"));
        System.out.println("TC_02 : PASSED!");

    }
    @AfterClass
    public void tearDown()
    {
      if (driver != null) 
      {
        driver.quit();
      }
    }
}
