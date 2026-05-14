package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class SearchEmployeeUsingAutoSuggestionTest extends BaseTest{
	
	@DataProvider(name = "empData")
	public Object[][] empData(){
		return new Object[][] {
			{
				"Admin", "admin123", "m"
			}
		};
	}
	
	@Test(dataProvider = "empData")
	public void SearchEmployeeUsingAutoSuggestion(String username, String password, String empFirstName) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		DashboardPage dashboard = new DashboardPage(driver);
		PIMPage pim = new PIMPage(driver);
		dashboard.clickPIM();
		pim.enterEmployeeInSearch(empFirstName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(PIMPage.allSuggestions));

				List<WebElement> allSuggestions =
				        driver.findElements(PIMPage.allSuggestions);

				allSuggestions.get(1).click();
	}

}


















