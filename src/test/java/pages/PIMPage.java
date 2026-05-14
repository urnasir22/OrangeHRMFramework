package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {

	WebDriver driver;

	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}

	public static By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
	public static By employeeFirstName = By.name("firstName");
	public static By employeeMiddleName = By.name("middleName");
	public static By employeeLastName = By.name("lastName");
	public static By employeeId = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
	public static By addEmployeeSaveBtn = By.xpath("//button[text() =' Save ']");
	public static By employeeListBtn = By.xpath("//a[text()=\"Employee List\"]");
	public static By employeeName = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	public static By searchBtn = By.xpath("//button[@type=\"submit\"]");
	public static By employeeIdInSearch = By.xpath("//div[@role='row']//div[@role='cell'][2]");
	public static By firstAndMiddleNameInSearch = By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[3]");
	public static By lastNameInSearch = By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[4]");
	public static By searchTable = By.xpath("(//div[@role='row'])[1]");
	public static By firstNameInSearch = By.xpath("//div[text()='abc def']");
	public static By licenseExpireDate = By.xpath("(//div[@class=\"oxd-date-input\"]/input)[1]");
	public static By nationalityDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	public static By maritalStatusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	public static By dateOfBirth = By.xpath("(//div[@class=\"oxd-date-input\"]/input)[2]");
	public static By personalDetailsSaveBtn = By.xpath("(//button[text() = \" Save \"])[1]");
	public static By successMessage = By.xpath("//p[text()='Successfully Updated']");
	public static By allSuggestions = By.xpath("//div[@role='listbox']//span");
	public static By deleteBtn = By.xpath("//div[contains(text(),'abc ')]/ancestor::div[@role='row']//i[@class=\"oxd-icon bi-trash\"]");
	public static By acceptBtn = By.xpath("//button[contains(. ,' Yes, Delete ')]");
	
	// methods
	public void clickAddEmployee() {
		driver.findElement(addEmployeeBtn).click();
	}

	public void enterFirstName(String firstName) {
		driver.findElement(employeeFirstName).sendKeys(firstName);
	}

	public void enterMiddleName(String middleName) {
		driver.findElement(employeeMiddleName).sendKeys(middleName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(employeeLastName).sendKeys(lastName);
	}

	public void clickSaveBtn() {
		driver.findElement(addEmployeeSaveBtn).click();
	}

	public void addNewEmployee(String first, String middle, String last) {
		enterFirstName(first);
		enterMiddleName(middle);
		enterLastName(last);

	}

	public String getEmployeeId() {
		return driver.findElement(employeeId).getText();
	}

	public void clickEmployeeList() {
		driver.findElement(employeeListBtn).click();
	}

	public void enterEmployeeInSearch(String EmpNameSearch) {
		driver.findElement(employeeName).sendKeys(EmpNameSearch);
	}

	public void clickSearch() {
		driver.findElement(searchBtn).click();
	}

	// Search employee
	public void searchEmp(String EmpNameSearch) {
		enterEmployeeInSearch(EmpNameSearch);
		clickSearch();
	}

	public String getFirstAndLastName() {
		return driver.findElement(firstAndMiddleNameInSearch).getText();
	}

	public String getEmployeeIdInSearch() {
		return driver.findElement(employeeIdInSearch).getText();
	}

	public boolean isSearchTableVisible() {
		return driver.findElement(searchTable).isDisplayed();
	}

	public void clickFirstNameSearch() {
		driver.findElement(firstNameInSearch).click();
	}

	public void licenseExpireDate(String expireDate) {
		driver.findElement(licenseExpireDate).sendKeys(expireDate);
	}

	public void selectNationality(String nationality) {
		driver.findElement(nationalityDropdown).sendKeys(nationality);

	}

	public void selectMaritalStatus(String maritalStatus) {
		driver.findElement(maritalStatusDropdown).sendKeys(maritalStatus);
		;

	}

	public void sendDateOfBirth(String date) {
		driver.findElement(dateOfBirth).sendKeys(date);
		;
	}

	public void clickPersonalDetailsSave() {
		driver.findElement(personalDetailsSaveBtn).click();
	}

	public void savePersonalDetails(String expiredate, String nationality, String maritalStatus, String date) {
		licenseExpireDate(expiredate);
		selectNationality(nationality);
		selectMaritalStatus(maritalStatus);
		sendDateOfBirth(date);
		clickPersonalDetailsSave();
	}

	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		return successMsg.getText();

	}
	
	public void clickDelete() {
		driver.findElement(deleteBtn).click();
	}
	
	public void clickAccept() {
		driver.findElement(acceptBtn);
	}

}























