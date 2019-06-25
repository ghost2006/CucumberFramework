package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement firstName; //instance variable
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='middleName']")
	public WebElement midName;
	
	@FindBy(xpath="//input[@id='employeeId']")
	public WebElement employeeId;
	
	@FindBy(xpath="//a[@id='systemUserSaveBtn']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//div[@id='location_inputfileddiv']//input")
	public WebElement location;
	
	@FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
	
	@FindBy(xpath="//span[@id='pim.navbar.employeeName']")
	public WebElement empCheck;
	
	 @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
	 public List<WebElement> addEmpLabels;
	
	 @FindBy(xpath="//label[text()='Create Login Details']")
	 public WebElement checkBox;
	 
	 @FindBy(xpath="//label[text()='User Name']/../input")
	 public WebElement userName;
	 
	 @FindBy(xpath="//label[text()='Password']/../input")
	 public WebElement password;
	
	 @FindBy(xpath="//label[text()='Confirm Password']/../input")
	 public WebElement confirmPassword;
	 
	 @FindBy(xpath="//label[text()='ESS Role']/../div/select")
	 public WebElement sRole; 
	 
	 @FindBy(xpath="//label[text()='Supervisor Role']/../div/select")
	 public WebElement superRole; 
	
	public AddEmployeePage(){ //initializing our instances
		PageFactory.initElements(driver, this);
	}
}
