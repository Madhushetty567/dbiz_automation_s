package base;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;



public class POM {
	public static final Logger logger1 = Logger.getLogger(POM.class.getName());
	public WebDriver ldriver;

	public POM(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	

	@FindBy(xpath = "//input[@id='ybar-sbq']")
	WebElement searchbar;
	
	@FindBy(xpath = "//button[@id='ybar-search']")
	WebElement search;
	

	//@FindBy(xpath = "//*[@id=\\\"ybar-sf\\\"]/div[4]/div[1]/div/ul[1]/li[1]")
	@FindBy(xpath = "//ul[@role='listbox'][1]//li[1][@data-id='result-quotes-0']")
	WebElement first_element;
	

	@FindBy(xpath ="//ul[@role='listbox'][1]//li")
	List<WebElement> allelements;
	
	
	@FindBy(xpath ="//div[@class='bottom yf-k4z9w']//section[@class='yf-1tejb6']//span[@data-testid='qsp-price']")
	WebElement Stockprice;
	

	@FindBy(xpath ="//li[@class=' yf-gn3zu3']//span[@class='value yf-gn3zu3']//fin-streamer[@data-field='regularMarketPreviousClose']")
	WebElement previous_close_price;
	

	@FindBy(xpath ="//li[@class=' yf-gn3zu3']//span[@class='value yf-gn3zu3']//fin-streamer[@data-field='regularMarketVolume']")
	WebElement volume_of_stock;
	

	
	
	
	public void searchingstock() throws Throwable
	{
		logger1.info("searching stock invoked");
		TestBase.waitForElementToBeVisible(searchbar, "searchbar");

		try {
			TestBase.EnterText(searchbar, "TSLA", "TSLA ");
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	public void verifyfirstelement_in_suggestion() throws IOException, Throwable
	{
		logger1.info("verifying first  element in suggestion");
		TestBase.waitForElementToBeVisible(first_element, "firstelement");
		ArrayList al=new ArrayList(allelements);
		Thread.sleep(2000);
		 if(first_element.equals(al.get(0)))
		 {
			 System.out.println("first element is TSLA in auto suggestion");
			 logger1.info("first element in autousggestion is "+ first_element);
		 }
		 
		 else
		 {
			 System.out.println("first element is not first_element");
		 }
		}
	
	public void clicksearch() throws Throwable
	{
		logger1.info("clicked on search button");
		search.click();
		
	}
	
	public void stockprice() throws IOException, Throwable
	{
		logger1.info("waiting for"+Stockprice);
		TestBase.waitForElementToBeVisible(Stockprice, "stockprice");
		String stocktext =  Stockprice.getText();
		String Stocktext2 = stocktext.replaceAll("[^0-9]", "");
	
		 int n = Integer.parseInt(Stocktext2);
		 if(n>200)
		 {
			 logger1.info("value of stock ="+n +"is grether then 200" );
			 System.out.println("value of stock is greater then expected");
		 }
		 
		 else
		 {
			 logger1.info("value of stock =" +n+ "is lesser then 200" );
			 System.out.println("value is lesser  then expected");
		 }
	
	
	}
	
	public void previous_close()
	{
		TestBase.string_to_int_conversion(previous_close_price, "previous_close_price");
	}
	
	public void volume()
	{
		TestBase.string_to_int_conversion(volume_of_stock, "volume_of_stock");
	}
}
	 
	
	
	
	
	
	
	
	
	

		
	
	
	
	


