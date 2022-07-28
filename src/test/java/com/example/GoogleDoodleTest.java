package com.example;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleDoodleTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
	  	// Indica onde está o driver do firefox
	  	System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() {
	    // instrui o driver para "navegar" pelo Google
	    driver.navigate().to("http://www.google.com");

	    List<WebElement> elementName = driver.findElements(By.name("btnI"));
	    elementName.get(1).click();

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains("Google Doodles"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertEquals("Google Doodles", driver.getTitle());
	}

	@After
	public void closing() throws Exception{
		// Espera 5 segundos e fecha a janela do browser
	    Thread.sleep(5000);
		driver.quit();
	}
}
