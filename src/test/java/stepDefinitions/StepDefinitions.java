package stepDefinitions;

import java.util.concurrent.TimeUnit;


import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(io.cucumber.junit.Cucumber.class)
public class StepDefinitions {
	
	public static WebDriver driver;
	
	 @Given("^User launches the application$")
	    public void user_launches_the_application() throws Throwable {
		 System.setProperty("webdriver.chrome.driver", "./BrowserUtils/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.swiggy.com/");
		 driver.manage().window().maximize();
	    
	    }
       @When("^The user enters valid (.+)$")
	    public void the_user_enters_valid(String location) throws Throwable {
	    	WebElement Location = driver.findElement(By.id("location"));
	    	
	    	Location.sendKeys(location);
	    	Location.click();
	    	
	    	Thread.sleep(3000);
	    	WebElement EnteredLocation = driver.findElement(By.xpath("//button[@tabindex='2']"));
	    	
	    	EnteredLocation.click();
	    }

	    @Then("^Check if the user has login successfully$")
	    public void check_if_the_user_has_login_successfully() throws Throwable {
	        
	    	Thread.sleep(5000);
	    	String ExpectedURL = driver.getCurrentUrl();
	    	if(ExpectedURL.equalsIgnoreCase("https://www.swiggy.com/restaurants"));
	    	{
	    		System.out.println("Use has logged in successfully");
	    	}
	    }

	    @SuppressWarnings("deprecation")
		@Then("^The user searches for the (.+)$")
	    public void the_user_searches_for_the(String product) throws Throwable {
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	WebElement Search = driver.findElement(By.xpath("//span[normalize-space()='Search']"));
	    	Search.click();
	    	
	    	
	    	Thread.sleep(5000);
	    	
	    	WebElement SearchBar = driver.findElement(By.xpath("//input[@placeholder='Search for restaurants and food']"));
	    	SearchBar.clear();
	    	SearchBar.sendKeys(product); // The value we want to set to input
	    	SearchBar.sendKeys(Keys.RETURN);
	    	
	    	
	    }

	    @And("^Check if the appropriate product page is getting displayed$")
	    public void check_if_the_appropriate_product_page_is_getting_displayed() throws Throwable {
	    	
	    	Thread.sleep(5000);
	    	String ExpectedProduct = driver.getCurrentUrl();
	    	if(ExpectedProduct.equalsIgnoreCase("https://www.swiggy.com/search?query=Chicken+parm+Burger"));
	    	{
	    		System.out.println("User has been successfully navigated to appropriate product page");
	    	}
	     }
	    	
	     @And("^The user selects a product and added it into the cart$")
	    	    public void the_user_selects_a_product_and_added_it_into_the_cart() throws Throwable {
	  
	    	 
	    	 Thread.sleep(3000);
	    	 WebElement AddItemButton = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)"));
	    	 AddItemButton.click();
	    	 
	    	
	     }

	    
		@And("^Check if the Selected product is successfully added into the cart$")
	    	    public void check_if_the_selected_product_is_successfully_added_into_the_cart() throws Throwable {
	    	 
	    	 WebElement Cart = driver.findElement(By.xpath("//span[normalize-space()='Cart']"));
	    	 Cart.click();
	    	 
	    	 Thread.sleep(5000);
		    	String ExpectedProduct1 = driver.getTitle();
		    	if(ExpectedProduct1.equalsIgnoreCase("To place your order now, log in to your existing account or sign up.To place your order now, log in to your existing account or sign up."));
		    	{
		    		System.out.println("Selected item successfully added into the cart");
		    	}
	    	

		}

	    @And("^Close the browser$")
	    public void close_the_browser() {
	    	
	    	driver.close();
	    
}

	}


