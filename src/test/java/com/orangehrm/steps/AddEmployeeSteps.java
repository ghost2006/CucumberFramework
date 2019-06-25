package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;
import com.orangehrm.utils.ExcelUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeSteps extends CommonMethods {
	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	AddEmployeePage empPage = new AddEmployeePage();

	@Given("I logged in into Orange Hrm")
	public void i_loged_in_into_Orange_Hrm() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		click(home.pim);
	}

	@When("I click on add employee link")
	public void i_click_on_add_employee_link() {
		click(home.addEmp);
	}

	@When("I provide employee details")
	public void i_provide_employee_details() { // our instance method
		sendText(empPage.firstName, "Jane");
		sendText(empPage.midName, "J");
		sendText(empPage.lastName, "Johnson");
		click(empPage.location);
		selectList(empPage.locationList, "HQ");
	}

	@Given("I provide {string}, {string}, {string} and {string}")
	public void i_provide_and(String fName, String mName, String lName, String location) { // single parameterization
		sendText(empPage.firstName, fName);
		sendText(empPage.midName, mName);
		sendText(empPage.lastName, lName);
		click(empPage.location);
		selectList(empPage.locationList, location);
	}

	@When("I provide Employee details from {string}")
	public void i_provide_Employee_details(String sheetName) {
		ExcelUtility exc=new ExcelUtility();
		
		//exc.openExcel(xlFilePath, sheetName);
		
		
		/*let's say they come from Excel
		 * 
		 *fis-->workbook-> worksheet(sheetName)-># of rows--># of cols-->
		 * loop(through crows){
		 * loop(through cols){
		    sendText(empPage.firstName, valueFromEachCell);
			sendText(empPage.midName, valueFromEachCell);
			sendText(empPage.lastName, valueFromEachCell);
		click(empPage.location);
		selectList(empPage.locationList, location); }}
		 */
	}

	@When("I click on save button")
	public void click_on_save_button() {
		click(empPage.saveBtn);
	}

	@Then("I see employee is added successfully")
	public void i_see_employee_is_added_successfully() {
		waitForElementBeVisible(empPage.empCheck, 7); // !!!
		String verifText = empPage.empCheck.getText().trim();
		Assert.assertEquals("Jane Johnson", verifText);
	}

	@Then("I see {string}, {string} is displayed")
	public void i_see_is_displayed(String fName, String lName) {
		waitForElementBeVisible(empPage.empCheck, 7); // !!!
		String verifText = empPage.empCheck.getText().trim();
		Assert.assertEquals(fName + " " + lName, verifText);
	}

	@Then("I see following labels")
	public void i_see_following_labels(List<String> expectedLabels) {
		for (String label : expectedLabels) {
			System.out.println(label); // printing labels from cucumber dataTable (expected values)
		}

		List<WebElement> labelList = empPage.addEmpLabels; // (actual ones)
		for (int i = 0; i < expectedLabels.size(); i++) {
			String labeltxt = labelList.get(i).getText().replace("*", "");
			Assert.assertEquals(expectedLabels.get(i), labeltxt);
		}
	}
	// 2 way of comparing 2 lists
//		public void i_see_following_labels(List<String> expectedLabels) {
//			for (String label : expectedLabels) { 
//				System.out.println(label); // printing expected labels from cucumber dataTable (expected values)
//			}
//			//creating an empty arrayList (Sting type) were we'll store labels text
//			List<String> actuaLabels=new ArrayList<String>();
//			//get all label elements
//			List<WebElement> labelList = empPage.addEmpLabels; //list of WE_ts
//			for (WebElement label:labelList) {
//				String labeltxt=label.getText();
//				if (!labeltxt.isEmpty()) { //if text is not empty-->replace * & store it inside actualLables
//					actuaLabels.add(labeltxt.replace("*", ""));
//				}
//			}
//			//here 1 List of String type, 2d-WebElement list, that's why we created an empty one & stored our Strings from WE List, so now we can compare Lists of the same type
//			actuaLabels.equals(expectedLabels); //equals method_ to compare 2 lists.
//			Assert.assertTrue(actuaLabels.equals(expectedLabels));
//			//can use also actuaLabels.retainAll(expectedLabels);}

	@When("I click on create login details")
	public void i_click_on_create_login_details() {
		empPage.checkBox.click();
	}

	@When("I provide all mandatory fields:")
	public void i_provide_all_mandatory_fields(Map<String, String> mandatoryFields) {
		Random r = new Random(); // random class for generation numbers
		String username = mandatoryFields.get("Username") + r.nextInt(10000);
		sendText(empPage.userName, username);
		sendText(empPage.password, mandatoryFields.get("Password"));
		empPage.confirmPassword.sendKeys(mandatoryFields.get("ConfirmPassword"));
		selectValueFromDD(empPage.sRole, mandatoryFields.get("ESS_Role"));
		selectValueFromDD(empPage.superRole, mandatoryFields.get("Supervisor_Role"));
	}

}
