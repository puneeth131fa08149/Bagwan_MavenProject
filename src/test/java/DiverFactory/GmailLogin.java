package DiverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args)  {
		WebDriver driver=new ChromeDriver();
		driver.get("https://gmail.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
driver.findElement(By.name("identifier")).sendKeys("pranga2010");	
driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
driver.findElement(By.name("password")).sendKeys("test12346");
	}

}
