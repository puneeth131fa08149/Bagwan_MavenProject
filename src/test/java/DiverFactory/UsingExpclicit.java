package DiverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingExpclicit {

	public static void main(String[] args)  {
		WebDriver driver=new ChromeDriver();
		driver.get("https://gmail.com");
driver.manage().window().maximize();
WebDriverWait wait=new WebDriverWait(driver, 600);
driver.findElement(By.name("identifier")).sendKeys("pranga2010");	
driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
//wait for password textbox to be visible
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
driver.findElement(By.name("password")).sendKeys("test12346");
	}

}
