package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class SearchUpdateAndVerifyEmployeeTest extends BaseTest {

	@DataProvider(name = "empData")
	public Object[][] empData() {
		return new Object[][] {
				{ "Admin", "admin123", "abc", "2025-11-19", "Indian", "Married", "1988-05-30", "abc", "def", "xyz" } };
	}

	@Test(dataProvider = "empData")
	public void SearchUpdateAndVerifyEmployee(String username, String password, String firstName, String expiredate,
			String nationality, String maritalStatus, String dateOfBirth, String first, String middle, String last)
			throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		DashboardPage dashboard = new DashboardPage(driver);
		PIMPage pim = new PIMPage(driver);
		Thread.sleep(2000);
		dashboard.clickPIM();
		pim.clickAddEmployee();
		Thread.sleep(4000);
		pim.addNewEmployee(first, middle, last);
		Thread.sleep(2000);
		pim.clickSaveBtn();
		Thread.sleep(2000);
		pim.clickEmployeeList();
		Thread.sleep(3000);
		pim.searchEmp(firstName);
		Assert.assertTrue(pim.isSearchTableVisible());
		pim.clickFirstNameSearch();
		Thread.sleep(4000);
		pim.savePersonalDetails(expiredate, nationality, maritalStatus, dateOfBirth);
		Thread.sleep(3000);
		Assert.assertEquals(pim.getSuccessMessage(), "Successfully Updated");
		driver.navigate().refresh();

	}

}
