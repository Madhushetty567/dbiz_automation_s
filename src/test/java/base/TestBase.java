package base;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

   public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
	static WebDriver driver;
	 
	public static void setupdriver()
	{
		logger.info("..................Set updriver initialized.........................");
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
		logger.info("...................Setup driver setup completed.................");
	}
	
	public static WebDriver getdriver()
	{
		logger.info(driver +"launched sucessfully");
		return driver;
	}
	
	public static WebDriverWait applyWebDriverWait()
	{		
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			wait.pollingEvery(2000, TimeUnit.MILLISECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(NoSuchFrameException.class);
			return wait;
	}
	
	public static void waitForElementToBeVisible(WebElement locator,String elementDesc) throws IOException, Throwable
	{		 
			Thread.sleep(500); 
			
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public static void EnterText(WebElement element, String textToType, String elementDesc) throws Throwable
	{
		logger.info("--------	EnterText  invoked successfully	--------");
		try
		{
			waitForElementToBeVisible(element,elementDesc);
			element.click();
			element.clear();
			element.sendKeys(textToType);
			logger.info("--------	EnterText is successfully done	--------");
		}

		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"User unable to enter text into the input field "+"<b>"+elementDesc +"</b>"+" due to the Exception: "+error.getMessage());
		}
	}
	
	public static void clickk(WebElement element, String elementDesc) throws Throwable
	{
		logger.info("--------	click on + element + invoked successfully	--------");
			waitForElementToBeVisible(element,elementDesc);
			element.click();
			logger.info("--------	click on + element +  executed successfully	--------");
     }
	
	public static void  string_to_int_conversion(WebElement element,String value)
	{
		String text1=element.getText();
		String text2=text1.replaceAll("[^0-9]", "");
		int n = Integer.parseInt(text2);
		logger.info("--------conversion of string to int completed	--------");
		System.out.println("value of" + value + " is  " + n);	
	} 
   }

	