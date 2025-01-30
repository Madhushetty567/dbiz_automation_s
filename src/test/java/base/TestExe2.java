package base;

import org.openqa.selenium.WebDriver;
import base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

//import base.POM  ;

public class TestExe2 {
	public static POM p;
	
	
	public static void main(String[] args) throws Throwable {
		TestBase.setupdriver();
		TestBase.getdriver();
		TestBase.getdriver().get("https://finance.yahoo.com/");
		p=new POM(	TestBase.getdriver());
		p.searchingstock();
		p.verifyfirstelement_in_suggestion();
		p.clicksearch();
		Thread.sleep(5000);
		p.stockprice();
		p.previous_close();
		p.volume();
		
		}

}
