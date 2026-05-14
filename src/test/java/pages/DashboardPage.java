package pages;

import org.openqa.selenium.WebDriver;

import locators.CommonLocators;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickPIM() {
		driver.findElement(CommonLocators.pimButton).click();
	}
	

}
