package com.example;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
	  	// Indica onde está o driver do firefox
	  	System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() {
	
	    driver.navigate().to("http://the-internet.herokuapp.com/login");

	    WebElement user = driver.findElement(By.name("username"));
	    user.sendKeys("tomsmith");
        
        WebElement password = driver.findElement(By.name("password"));
	    password.sendKeys("SuperSecretPassword!");

        WebElement elementButton = driver.findElement(By.xpath("//*[@id='login']/button"));   
	    elementButton.click();

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs("The Internet"));
        
	    String url = driver.getCurrentUrl();
	    System.out.println("URL atual: " + url);
	    assertTrue("Erro, login não realizado", driver.getCurrentUrl().equals(url));
	}

	@After
	public void closing() throws Exception{
		// Espera 5 segundos e fecha a janela do browser
	    Thread.sleep(5000);
		driver.quit();
	}
}

