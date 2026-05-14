package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static By userName = By.xpath("//input[@name='username']");
	public static By password = By.name("password");
	public static By loginBtn = By.xpath("//button[@type=\"submit\"]");
	
	public void enterUserName(String name) {
		driver.findElement(userName).sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void login(String name, String pass) {
		enterUserName(name);
		enterPassword(pass);
		clickLogin();
	}

}
