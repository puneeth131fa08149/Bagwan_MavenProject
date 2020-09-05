package DiverFactory;

import org.testng.annotations.Test;

import Utilities.ReadExcel;
import Utilities.TakeScreenShot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunLibrary.FunctionLibrary;
import Constants.PBConstant;


public class DriverScript extends PBConstant {
String inputpath="E:\\mrngbatch\\Maven_Project\\TestInput\\Controller.xlsx";
String writeresult="E:\\mrngbatch\\Maven_Project\\TestOutput\\keywordResults.xlsx";
String TCSheet="TestCases";
String TSSheet="TestSteps";
boolean res=false;
ExtentReports report;
ExtentTest test;
@Test
public void primusbank()throws Throwable
{
String tcres="";
//create refernce object for excel methods
ReadExcel xl=new ReadExcel(inputpath);

//count first sheet rows
int tccount=xl.rowCount(TCSheet);
//count second sheet rows
int tscount=xl.rowCount(TSSheet);
for(int i=1;i<=tccount;i++)
{
report=new ExtentReports("./Reports/Keyword.html");	
test=report.startTest("Primus Bank");
//read execute column
String execute=xl.getcelldata(TCSheet, i, 2);	
if(execute.equalsIgnoreCase("Y"))
{
//read testcaseid column
String tcid=xl.getcelldata(TCSheet, i, 0);
for(int j=1;j<=tscount;j++)
{
String description=xl.getcelldata(TSSheet, j, 2);	
//read teststep id
String tsid=xl.getcelldata(TSSheet, j, 0);
if(tcid.equalsIgnoreCase(tsid))
{
	//read keyword column
String keyword=xl.getcelldata(TSSheet, j, 3);
switch(keyword.toUpperCase())
{
case "ADMINLOGIN":
res=FunctionLibrary.verifyLogin("Admin", "Admin");
TakeScreenShot.screenShot(driver, "Loginpage");
test.log(LogStatus.INFO, description);
break;
case"NEWBRANCHCREATION":
FunctionLibrary.navigatebranches();
res=FunctionLibrary.branchCreation("ameerpet23", "Hyderabad1", "srnagar", "12345", 1, 2, 2);
TakeScreenShot.screenShot(driver, "BranchCreation");
test.log(LogStatus.INFO, description);
break;
case "UPDATEBRANCH":
	FunctionLibrary.navigatebranches();
	res=FunctionLibrary.branchUpdation("hitechcity", "kukatpalli");
	TakeScreenShot.screenShot(driver, "Updatebranch");
	test.log(LogStatus.INFO, description);
	break;
case"ADMINLOGOUT":
	FunctionLibrary.verifyLogout();
	TakeScreenShot.screenShot(driver, "Logout");
	test.log(LogStatus.INFO, description);
}
String tsres=null;
if(res)
{
test.log(LogStatus.PASS, description);	
tsres="pass";
xl.setCelldata(TSSheet, j, 4, tsres, writeresult);
xl.greencolour(TSSheet, j, 4, writeresult);
}
else{
	test.log(LogStatus.FAIL, description);	
	tsres="Fail";
xl.setCelldata(TSSheet, j, 4, tsres, writeresult);	
xl.redcolour(TSSheet, j, 4, writeresult);
}
//if not tcres equal to null then write as pass or fail into tcsheet
if (!tsres.equalsIgnoreCase("FAIL")) 
{
//assign teststep results to testcase results
tcres=tsres;
}
}
}
xl.setCelldata(TCSheet, i, 3, tcres, writeresult);
if (tcres.equalsIgnoreCase("PASS")) 
{
xl.greencolour(TCSheet, i, 3, writeresult);
}else 
xl.redcolour(TCSheet, i, 3, writeresult);
report.endTest(test);
report.flush();
}
else
{
//write as not executed in results in first sheet
xl.setCelldata(TCSheet, i, 3, "Not Exeuted", writeresult);	
}
}
}
}














