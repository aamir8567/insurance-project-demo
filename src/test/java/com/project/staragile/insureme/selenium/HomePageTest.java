

package com.project.staragile.insureme.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    private WebDriver driver;
    private WebDriverWait wait;

@BeforeEach
public void setUp() {
    WebDriverManager.firefoxdriver().driverVersion("0.35.0").setup();
    
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);  // Enable headless mode for non-GUI environments
    
    driver = new FirefoxDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("http://localhost:8081");
}


    @Test
    public void testHomePageTitle() {
        driver.get("http://localhost:8081");  // Update with the correct URL for your app
        String title = driver.getTitle();
        assertEquals("Insure-me", title);  // Update with expected title
    }
        @Test
    public void testContactUsButtonIsPresent() {
        boolean isButtonPresent = driver.findElement(By.cssSelector(".btn1")).isDisplayed();
        assertTrue(isButtonPresent, "Contact Us button should be present");
    }

    @Test
    public void testOurServicesSectionIsPresent() {
        boolean isServicesSectionPresent = driver.findElement(By.xpath("//h2[contains(text(),'Our Services')]")).isDisplayed();
        assertTrue(isServicesSectionPresent, "'Our Services' section should be present");
    }
    @Test
    public void testAboutSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")).click();
        WebElement isContactHeadingPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Get In Touch')]")));

        assertTrue(isContactHeadingPresent.isDisplayed(), "Get In Touch is Present");
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
}
