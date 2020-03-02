package commonfunctionlibrary;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class FunctionLibrary {
	 static WebDriver driver;
		
		public static WebDriver startBrowser() throws Exception{
			

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				 driver =new ChromeDriver();	
			
			
			return driver;
		}
					
		public static void openApplication(WebDriver driver) throws Exception{
			driver.get("http://webapp.qedge.com/ ");	
			driver.manage().window().maximize();
		}
		
		public static void waitForElement(WebDriver driver,String locatortype,
			String locatorvalue,String waittitme){
			
			WebDriverWait mywait=new WebDriverWait(driver, Integer.parseInt(waittitme));
			if(locatortype.equalsIgnoreCase("id")){
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
			}
			else if(locatortype.equalsIgnoreCase("xpath")){
				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
			}else if(locatortype.equalsIgnoreCase("name")){
				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			}else
			{
			System.out.println("unable to locate for waitForElement method with "+locatortype);
			}			
		}
		
		public static void typeAction(WebDriver driver,String locatortype,
				String locatorvalue,String testdata){
			if(locatortype.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(locatorvalue)).clear();
				driver.findElement(By.id(locatorvalue)).sendKeys(testdata);
			}
			else if(locatortype.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorvalue)).clear();
				driver.findElement(By.name(locatorvalue)).sendKeys(testdata);
			}
			else if(locatortype.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorvalue)).clear();
				driver.findElement(By.xpath(locatorvalue)).sendKeys(testdata);
			}else
			{
				System.out.println("unable to locate for typeAction method with "+locatortype);
			}	
			
		}
		
		//method for clickaction
		public static void clickAction(WebDriver driver,String locatortype,
				String locatorvalue)
		{
			if(locatortype.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(locatorvalue)).sendKeys(Keys.ENTER);
			}
			else if(locatortype.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorvalue)).click();
			}
			else if(locatortype.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorvalue)).click();
		}
			else{
			System.out.println("Unable to locate for ClickAction method");	
			}
		}
		
		public static void tableValidation(WebDriver driver,String column) throws Exception{
			
			FileReader  fr=new FileReader(System.getProperty("user.dir")+"/CaptureData/suppnumber.txt");
			BufferedReader br=new BufferedReader(fr);
			
			String Exp_data=br.readLine();
			

			if(driver.findElement(By.id("searchtextbox")).isDisplayed()){
				Thread.sleep(5000);
				driver.findElement(By.id("searchtextbox")).sendKeys(Exp_data);
				driver.findElement(By.id("searchbutton")).click();
			}else{
				driver.findElement(By.id("searchpanelbutton")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("searchtextbox"))
				.sendKeys(Exp_data);
				driver.findElement(By.id("searchbutton")).click();
			}
			
			WebElement table=driver.findElement(By.id("suppliertable"));
			
			List<WebElement>rows=table.findElements(By.tagName("tr"));
			
			for(int i=1;i<rows.size();i++){
			       String act_data= driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td["+column+"]/div/span")).getText();	
			       Assert.assertEquals(Exp_data, act_data); 
			       System.out.println(act_data+"   "+Exp_data);
			       break;
			}
			
		}
				
			
		
			
		
		public static void closeBrowser(WebDriver driver){
			driver.close();
		}
		
		public static String generateDate(){
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_DD_hh_mm_ss");
			String requiredDate=sdf.format(d);
			return requiredDate;
		}
		
		
		
		public static void captureData(WebDriver driver,String locatortytpe,
				String locatorvalue) throws Exception{
			
			String supplierdata="";
			
			if(locatortytpe.equalsIgnoreCase("id")){
				supplierdata=driver.findElement(By.id(locatorvalue)).getAttribute("value");
			}
			
			else if(locatortytpe.equalsIgnoreCase("xpath")){
				supplierdata=driver.findElement(By.xpath(locatorvalue)).getAttribute("value");
			}
			
			else if(locatortytpe.equalsIgnoreCase("name")){
				supplierdata=driver.findElement(By.name(locatorvalue)).getAttribute("value");
			}
			
			FileWriter fw=new FileWriter (System.getProperty("user.dir")+"\\CaptureData\\suppnumber.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(supplierdata);
			bw.flush();
			bw.close();	
}
}