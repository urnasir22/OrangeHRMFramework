package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class DeleteAndVerifyEmployeeTest extends BaseTest {

	DashboardPage dashboardPage;
	PIMPage pimPage;
	LoginPage loginPage;

	String username = "Admin";
	String pass = "admin123";
	String first = "abc";
	String middle = "def";
	String last = "xyz";
	String searchName = "a";

	@DataProvider(name = "empData")
	public Object[][] empData() {
		return new Object[][] { { "Admin", "admin123", "abc", "def", "xyz", "a" } };
	}

	@Test(dataProvider = "empData")
	public void deleteAndVerifyEmployee(String username, String pass, String first, String middle, String last,
			String searchName) throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(username, pass);
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clickPIM();
		Thread.sleep(2000);
		pimPage = new PIMPage(driver);
		pimPage.clickAddEmployee();
		Thread.sleep(2000);
		pimPage.addNewEmployee(first, middle, last);
		pimPage.clickSaveBtn();
		Thread.sleep(2000);
		pimPage.clickEmployeeList();
		Thread.sleep(2000);
		pimPage.searchEmp(searchName);
		Thread.sleep(2000);
		pimPage.clickDelete();
		Thread.sleep(2000);
		pimPage.clickAccept();
	}

}
