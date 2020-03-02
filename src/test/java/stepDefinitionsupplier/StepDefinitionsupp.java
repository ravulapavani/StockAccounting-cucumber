package stepDefinitionsupplier;

import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.openqa.selenium.WebDriver;

import commonfunctionlibrary.FunctionLibrary;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionsupp {
	WebDriver driver;
	@When("^Open Browser$")
	public void open_Browser() throws Throwable {
	driver=FunctionLibrary.startBrowser();   
	}

	@When("^Open Application$")
	public void open_Application() throws Throwable {
	   FunctionLibrary.openApplication(driver); 
	}

	@When("^wait for username$")
	public void wait_for_username() throws Throwable {
	  FunctionLibrary.waitForElement(driver,"id", "username","10"); 
	}

	@When("^Enter Username$")
	public void enter_Username() throws Throwable {
	    FunctionLibrary.typeAction(driver, "id", "username", "admin");
	}

	@When("^Wait For password$")
	public void wait_For_password() throws Throwable {
		 FunctionLibrary.waitForElement(driver,"name", "password","10"); 
	}

	@When("^Enter Password$")
	public void enter_Password() throws Throwable {
		  FunctionLibrary.typeAction(driver, "name", "password", "master");
 
	}

	@When("^Wait for login$")
	public void wait_for_login() throws Throwable {
		 FunctionLibrary.waitForElement(driver,"xpath", ".//*[@id='btnsubmit']","10"); 
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {
	   FunctionLibrary.clickAction(driver,"xpath","//*[@id='btnsubmit']");
	}

	
     @When("^Wait for Supplier$")
	public void wait_for_Supplier() throws Throwable {
    	 FunctionLibrary.waitForElement(driver,"xpath", "//*[@id='mi_a_suppliers']","10");  
	}

	@When("^Click On Supplier$")
	public void click_On_Supplier() throws Throwable {
		 FunctionLibrary.clickAction(driver,"xpath","//*[@id='mi_a_suppliers']");  
	}

	@When("^Wait For Add Button$")
	public void wait_For_Add_Button() throws Throwable {
		 FunctionLibrary.waitForElement(driver,"xpath", "//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a","10");  
	}

	@When("^Clcik On Add Button$")
	public void clcik_On_Add_Button() throws Throwable {
		 FunctionLibrary.clickAction(driver,"xpath","//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a");  
	}

	@When("^Wait For SupplierNumber$")
	public void wait_For_SupplierNumber() throws Throwable {
		 FunctionLibrary.waitForElement(driver,"xpath", "//*[@id='x_Supplier_Number']","10");  
	}

	@Then("^Capture Data$")
	public void capture_Data() throws Throwable {
	    FunctionLibrary.captureData(driver,"id","x_Supplier_Number");
	}

	@When("^Wait For SupplierName$")
	public void wait_For_SupplierName() throws Throwable {
		 FunctionLibrary.waitForElement(driver,"xpath", "x_Supplier_Name","10");  
	}

	@When("^Enter in \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_in_with_and(String Test_Data, String Locator_Type, String Locator_Value) throws Throwable {
	    FunctionLibrary.typeAction(driver,"id","x_Supplier_Name","10");
	}

	@When("^wait for Add Button$")
	public void wait_for_Add_Button() throws Throwable {
	    FunctionLibrary.waitForElement(driver,"id","btnAction","10");
	}

	@When("^Click On Add Button after adding notes$")
	public void click_On_Add_Button_after_adding_notes() throws Throwable {
	   FunctionLibrary.clickAction(driver, "id","btnAction");
	}

	@When("^Wait For Ok Button$")
	public void wait_For_Ok_Button() throws Throwable {
		FunctionLibrary.waitForElement(driver,"xpath","(//*[text()='OK!'])[1]","10");
	}

	@When("^Click On Ok Button  with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void click_On_Ok_Button_with_and(String Locator_Type, String Locator_Value) throws Throwable {
		FunctionLibrary.clickAction(driver, "xpath","(//*[text()='OK!'])[1]");
	}

	@When("^Wait For Alert$")
	public void wait_For_Alert() throws Throwable {
		FunctionLibrary.waitForElement(driver,"xpath","(//*[text()='OK'])[6]","10");
	}

	@When("^Click On Alert$")
	public void click_On_Alert() throws Throwable {
		FunctionLibrary.clickAction(driver, "xpath","(//*[text()='OK'])[6]");

	}

	@Then("^User validate supplier table$")
	public void user_validate_supplier_table() throws Throwable {
	    FunctionLibrary.tableValidation(driver, "6");
	}

	@When("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.close();
	}


}