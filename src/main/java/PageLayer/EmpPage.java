package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpPage {
@FindBy(id="menu_pim_viewPimModule")
WebElement ClickPim;
@FindBy(name="btnAdd")
WebElement ClickAdd;
@FindBy(name="firstName")
WebElement Enterfname;
@FindBy(name="lastName")
WebElement Enterlname;
@FindBy(name="employeeId")
WebElement EnterEid;
@FindBy(name="photofile")
WebElement Clickchoosefile;
@FindBy(id="btnSave")
WebElement ClickSave;
public void verifyEmp(String fname,String lname,String eid)throws Throwable
{
	ClickPim.click();
	Thread.sleep(3000);
	ClickAdd.click();
	Thread.sleep(3000);
	Enterfname.sendKeys(fname);
	Enterlname.sendKeys(lname);
	EnterEid.clear();
	EnterEid.sendKeys(eid);
	Clickchoosefile.click();
	Runtime.getRuntime().exec("E:\\Autoit\\upload.exe");
	Thread.sleep(3000);
	ClickSave.click();
	Thread.sleep(7000);
}

}
