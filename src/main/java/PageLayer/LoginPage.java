package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
@FindBy(name="txtUsername")
WebElement Enterusername;
@FindBy(name="txtPassword")
WebElement Enterpassword;
@FindBy(name="Submit")
WebElement ClickLogin;
public void verifyLogin(String username,String password)throws Throwable
{
	Enterusername.sendKeys(username);
	Enterpassword.sendKeys(password);
	ClickLogin.click();
	Thread.sleep(4000);
}
}
