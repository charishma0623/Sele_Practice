package testProject;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Datatest {
	WebDriver driver;
  @Test(dataProvider="login",dataProviderClass=ConnectionDB.class)
  public void test1(String username,String password) throws IOException {
		  WebElement userName = driver.findElement(By.id("username"));
		  userName.sendKeys(username);
		  WebElement password1 = driver.findElement(By.id("password"));
		  password1.sendKeys(password);
		  WebElement btn = driver.findElement(By.id("submit"));
		  btn.click();
		  try {
			  WebElement msg = driver.findElement(By.xpath("//strong[text()=\"Congratulations student. You successfully logged in!\"]"));
			  String textmsg = msg.getText();
			  Assert.assertEquals(textmsg,"Congratulations student. You successfully logged in!");
			  File src1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File des1 = new File("C:\\Users\\chari\\git\\repository\\practice\\testProject\\src\\main\\java\\testProject\\LoginSS.png");
			  FileUtils.copyFile(src1, des1);
			  WebElement Logout = driver.findElement(By.xpath("//a[text()=\"Log out\"]"));
			  Logout.click();
		} catch (Exception e) {
			WebElement error = driver.findElement(By.id("error"));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",error);
			File src2 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des2 =new File("C:\\Users\\chari\\git\\repository\\practice\\testProject\\src\\main\\java\\testProject\\fail"+username+System.currentTimeMillis()+".png");
			FileUtils.copyFile(src2, des2);
			
		}
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://practicetestautomation.com/practice-test-login/");
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
