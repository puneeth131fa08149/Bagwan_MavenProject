package Utilities;
import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
public static void screenShot(WebDriver driver,String sname)
 throws Throwable{
DateFormat df=new SimpleDateFormat("dd_MM_yyyy hh_mm_ss");
Date d=new Date();
String datef=df.format(d);
String path="E:\\mrngbatch\\TestNg_FrameWork\\Screens\\"+datef+sname+".png";	
File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(path));
}
}
