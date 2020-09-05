package DiverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageLayer.LoginPage;
import Utilities.ReadExcel;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataDrivenFramework {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String writeresults="./TestOutput/Results.xlsx";
	@BeforeTest
	public void launch()
	{
		report=new ExtentReports("./Reports/Login.html");
		driver=new ChromeDriver();
	}
	@Test
	public void verifyLogin()throws Throwable
	{
		//call login page
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);	
		//access excel methods
		ReadExcel xl=new ReadExcel("./TestInput/Logindata.xlsx");
		//count no of rows
		int rc=xl.rowCount("Login");
		//count no of columns
		int cc=xl.colCount("Login");
		Reporter.log("no of rows are::"+rc+" "+"no of columns are::"+cc,true);
		for(int i=1;i<=rc;i++)
		{
			test=report.startTest("Verify Login");
			driver.get("http://orangehrm.qedgetech.com");
			driver.manage().window().maximize();
			String username=xl.getcelldata("Login", i, 0);
			String password=xl.getcelldata("Login", i, 1);
			//call login method
			login.verifyLogin(username, password);
			if(driver.getCurrentUrl().contains("dash"))
			{
				Reporter.log("Login success",true);
				test.log(LogStatus.PASS, "Login success");
				//write as login success in to results column
				xl.setCelldata("Login", i, 2, "Login Success", writeresults);
				//write as pass in to status column
				xl.setCelldata("Login", i, 3, "PASS", writeresults);
				xl.greencolour("Login", i, 3, writeresults);
			}
			else{
				//get error message
				String message=driver.findElement(By.id("spanMessage")).getText();
				Reporter.log(message,true);
				test.log(LogStatus.FAIL,message );
				xl.setCelldata("Login", i, 2, message, writeresults);
				xl.setCelldata("Login", i, 3, "FAIL", writeresults);
				xl.redcolour("Login", i, 3, writeresults);
			}
			report.endTest(test);
			report.flush();
		}
		xl.closefiles();
	}
	@AfterTest
	public void logout()
	{
		driver.close();
	}
}



















