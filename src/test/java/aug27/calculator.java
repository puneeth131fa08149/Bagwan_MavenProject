package aug27;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class calculator {
String url="https://www.calculator.net"	;
DesiredCapabilities cap;
WebDriver driver;
String Node="http://localhost:5550/wd/hub";
@Parameters({"browser"})
@BeforeTest
public void launch(String brw)throws Throwable
{
if(brw.equalsIgnoreCase("chrome"))
{
	System.out.println("Executing on chrome browser");
cap=new DesiredCapabilities();
cap.setBrowserName("chrome");
cap.setPlatform(Platform.WINDOWS);
driver=new RemoteWebDriver(new URL(Node), cap);	
driver.get(url);
driver.manage().window().maximize();
}
else if(brw.equalsIgnoreCase("firefox"))
{
	System.out.println("Executing on firefox browser");
	cap=new DesiredCapabilities();
	cap.setBrowserName("firefox");
	cap.setPlatform(Platform.WINDOWS);
	driver=new RemoteWebDriver(new URL(Node), cap);
	driver.get(url);
}
else{
	System.out.println("browser is not matching");
}
}
@Test
public void verifyCalculation()throws Throwable
{
driver.findElement(By.linkText("Math Calculators")).click();
Thread.sleep(4000);
driver.findElement(By.linkText("Percentage Calculator")).click();
Thread.sleep(4000);
driver.findElement(By.name("cpar1")).sendKeys("5");
Thread.sleep(4000);
driver.findElement(By.name("cpar2")).sendKeys("30000");
Thread.sleep(4000);
driver.findElement(By.xpath("//table[1]//tbody[1]//tr[2]//td[1]//input[2]")).click();
String result=driver.findElement(By.xpath("//b[contains(text(),'1500')]")).getText();
if(result.equals("1500"))
{
	System.out.println("Calculation is correct");
}
else{
	System.out.println("Calculation is Incorrect");
}
}
@AfterTest
public void logout(){
	driver.close();
}
}













