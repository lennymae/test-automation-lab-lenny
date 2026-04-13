package main.java.Heroku;
//Packages
//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utils.BaseClass;

	

public class AddProduct extends BaseClass{
	private static String url = "https://www.saucedemo.com/";
	//Open url in browser
	@Test
	public void addProduct(){
    	//Open url in browser
		OpenSite(url);
	    //Click link to Add Element page
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
	    WebElement newElement = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	    if(newElement.isDisplayed())
	    	newElement.click();
	    driver.findElement(By.xpath(("//*[@id=\"shopping_cart_container\"]/a"))).click();
	    
	    WebElement addedProduct = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
	    		
	    if(addedProduct.isDisplayed())
	    	System.out.println("Product added");
	  
	    
	    BaseClass.closeBrowser();
		
	}
}
