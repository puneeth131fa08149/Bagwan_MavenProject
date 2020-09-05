package Aug24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class dataprovider {
	WebDriver driver;
	@BeforeTest
	public void launch()
	{
		driver=new ChromeDriver();	
	}
	@Test(dataProvider = "logindata")
	public void VerifyLogin(String user,String password) {
		driver.get("http://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		if(driver.getCurrentUrl().contains("dash"))
		{
			Reporter.log("Login success",true);
		}
		else{
			String message=driver.findElement(By.id("spanMessage")).getText();
			Reporter.log(message,true);
		}
	}
	@DataProvider
	public Object[][] logindata() {
		Object login[][]=new Object[5][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admin";
		login[1][1]="test";
		login[2][0]="Admin";
		login[2][1]="Qedge123!@#";
		login[3][0]="Admin";
		login[3][1]="Qedge123!@#";
		login[4][0]="Admin";
		login[4][1]="Qedge123!@#";
		return login;
	}
	@AfterTest
	public void logout(){
		driver.close();
	}
}
