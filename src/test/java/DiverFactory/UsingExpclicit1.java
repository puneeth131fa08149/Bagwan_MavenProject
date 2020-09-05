package DiverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingExpclicit1 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.name("login")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
//wait for alert
wait.until(ExpectedConditions.alertIsPresent());
String alertmess=driver.switchTo().alert().getText();
System.out.println(alertmess);
driver.switchTo().alert().dismiss();

		
	}

}
