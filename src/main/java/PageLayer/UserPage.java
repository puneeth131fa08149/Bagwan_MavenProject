package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement clickAdmin;
	@FindBy(name="btnAdd")
	WebElement clickAdd;
	@FindBy(name="systemUser[employeeName][empName]")
	WebElement Enterename;
	@FindBy(name="systemUser[userName]")
	WebElement Enterusername;
	@FindBy(name="systemUser[password]")
	WebElement Enterpassword;
	@FindBy(name="systemUser[confirmPassword]")
	WebElement Entercpassword;
	@FindBy(name="btnSave")
	WebElement clickSave;
	public void verifyUser(String ename,String username,String password,String cpassword)
			throws Throwable{
		clickAdmin.click();
		Thread.sleep(3000);
		clickAdd.click();
		Thread.sleep(3000);
		Enterename.sendKeys(ename);
		Enterusername.sendKeys(username);
		Enterpassword.sendKeys(password);
		Entercpassword.sendKeys(cpassword);
		clickSave.click();
		Thread.sleep(5000);

	}



}
