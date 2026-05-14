package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class AddAndVerifyEmployeeTest extends BaseTest{
	
	DashboardPage dashboardPage;
	PIMPage pimPage;
	LoginPage loginPage;
	
	String username = "Admin";
	String pass = "admin123";
	String first = "abc";
	String middle = "def";
	String last = "xyz";
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(username, pass);
	}
	
	@Test
	public void addEmployee() throws InterruptedException {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clickPIM();
		Thread.sleep(2000);
		pimPage = new PIMPage(driver);
		pimPage.clickAddEmployee();
		Thread.sleep(2000);
		pimPage.addNewEmployee(first, middle, last);
		pimPage.clickSaveBtn();
		Thread.sleep(2000);
		String employeeId = pimPage.getEmployeeId();
		System.out.println(employeeId + "first");
		pimPage.clickEmployeeList();
		pimPage.enterEmployeeInSearch(first);
		pimPage.clickSearch();
		Thread.sleep(2000);
		Assert.assertEquals(pimPage.getFirstAndLastName(), first + " " +middle);
		
		//yaha pe "expected [] but found [0394]" ye error aa raha hai. ye itna important nhi hai
		//hamara main purpose automation sikhna hai for interview abhi k liye move on karo
		//kyuki ye error automation sikhne k liye itna important nhi hai.
		Assert.assertEquals(pimPage.getEmployeeIdInSearch(), employeeId);
	}

}
















