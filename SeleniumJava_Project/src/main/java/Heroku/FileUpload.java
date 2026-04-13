package main.java.Heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.utils.BaseClass;

public class FileUpload extends BaseClass{
	private static String url = "https://the-internet.herokuapp.com/";
	// build an absolute path for the file so Selenium's sendKeys won't fail with "path is not absolute"
	private static String fileName = new java.io.File("resources/Heroku/DataSource.xlsx").getAbsolutePath();
	  @Test
	  public void fileUpload(){
		    //Access URL 
			OpenSite(url);
		    //Click link to File upload page
		    driver.findElement(By.xpath("//*[@id='content']/ul/li[18]/a")).click();
		    //Click Choose File button
		    WebElement uploadPhotoBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
		    uploadPhotoBtn.sendKeys(fileName);
		    driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();
		    //Validate that upload is successful - compare the uploaded filename only
		    String uploadSuccessMsg = driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText();
		    String expectedFileName = new java.io.File(fileName).getName();
		    Assert.assertEquals(uploadSuccessMsg, expectedFileName, "Uploaded filename should match");
		    System.out.println("File has been uploaded successfully");
			closeBrowser();
	  }
}