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

public class IfmgSabaraTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
	  	// Indica onde está o driver do firefox
	  	System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testMeuIfmg() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.xpath("//*[@id='portalservicos-meu-ifmg']/a"));
		element.click(); 

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("RM Portal"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("rm"));
	}

	@Test
	public void testCpa() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.xpath("//*[@id='portalservicos-cpa-1']/a"));
		element.click(); 

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("Comissão"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("comissão"));
	}

	@Test
	public void testWebMail() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.xpath("//*[@id='portalservicos-webmail']/a"));
		element.click(); 

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("Gmail"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.equals("Gmail"));
	}

	@Test
	public void testContato() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.xpath("//*[@id='portalservicos-fale-conosco']/a"));
		element.click(); 

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("Contato"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("contato"));
	}

	@Test
	public void testExAlunos() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.xpath("//*[@id='portalservicos-ex-alunos']/a"));
		element.click(); 

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("Ex alunos"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("formulário"));
	}

	@Test
	public void testAcessoAosSistemas() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.xpath("//*[@id='portalservicos-acesso-a-sistemas']/a"));
		element.click(); 

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("Sistemas"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("acesso"));
	}

	@Test
	public void testBuscarNoPortal() {
	    //instrui o webdriver a navegar até ao site do IFMG
	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	   //obtém um campo
	    WebElement element = driver.findElement(By.name("SearchableText"));

		// preenche esse campo 
	    element.sendKeys("matrícula");
		element.submit();

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("Busca"));

		WebElement result = driver.findElement(By.id("search-results-number"));
	    String resultText = result.getText();
		int resultNum = Integer.parseInt(resultText);
	    
		 
	    assertTrue("Erro - Página não retornou valor esperado.", resultNum > 0);
	    															
	}

	@After
	public void closing() throws Exception{
		// Espera 5 segundos e fecha a janela do browser
	    Thread.sleep(5000);
		driver.quit();
	}
}
