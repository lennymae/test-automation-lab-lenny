package main.java.utils;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;
import java.util.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass {
	public static WebDriver driver;
	
	public void OpenSite(String url) 
	{
	    WebDriverManager.chromedriver().setup();
	
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--remote-allow-origins=*");
	
	    driver = new ChromeDriver(options);
	    driver.get(url);
	
	    System.out.println("Site has been opened");
	}
	
	public static void closeBrowser() {
	    if (driver != null) {
	        driver.quit();
	        driver = null;
	    }
	}
	
	public static void isImageBroken(WebElement image)
	{
	    if (image.getAttribute("naturalWidth").equals("0"))
	    {
	        System.out.println(image.getAttribute("outerHTML") + " is broken.");
	    }
	}
	public static void assertElementNotPresent(WebDriver driver, String xpath) {
	    try {
	        driver.findElement(By.xpath(xpath));
	        fail("Element with xpath <" + xpath + "> is present");
	        
	    } catch (NoSuchElementException e) { 
	        System.out.println("Element with xpath <" + xpath + "> is not present");
	    }
	}
	
}

