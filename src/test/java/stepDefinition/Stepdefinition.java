package stepDefinition;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.When;

public class Stepdefinition {
	
	WebDriver driver;
	@When("^Open Browser$")
	public void open_Browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	   
	}

	@When("^Open Application$")
	public void open_Application() throws Throwable {
		driver.get("http://webapp.qedge.com/login.php");
	    
	}

	@When("^wait for username$")
	public void wait_for_username() throws Throwable {
		Thread.sleep(5000);
	   
	}

	@When("^Enter Username$")
	public void enter_Username() throws Throwable {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
	}

	@When("^Wait For password$")
	public void wait_For_password() throws Throwable {
		Thread.sleep(5000);
		   
	   
	}

	@When("^Enter Password$")
	public void enter_Password() throws Throwable {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
	}

	@When("^Wait for login$")
	public void wait_for_login() throws Throwable {
		Thread.sleep(5000);
		   
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {
	    driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	}

	@When("^Wait for logout$")
	public void wait_for_logout() throws Throwable {
		Thread.sleep(5000);
	}

	@When("^click on logout$")
	public void click_on_logout() throws Throwable {
		  driver.findElement(By.id("logout")).click();
	}

	@When("^Wait for ok$")
	public void wait_for_ok() throws Throwable {
		Thread.sleep(5000);
	}

	@When("^click on ok$")
	public void click_on_ok() throws Throwable {
	   driver.findElement(By.xpath("//*[text()='OK!']")).click();
	}

	@When("^CloseBrowser$")
	public void closebrowser() throws Throwable {
	   driver.close();
	}

}