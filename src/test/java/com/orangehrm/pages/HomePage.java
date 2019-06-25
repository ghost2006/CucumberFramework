package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(xpath="//span[text()='PIM']")
	public WebElement pim;
	
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	public WebElement addEmp;
	
	@FindBy(xpath ="//li[@id ='menu_admin_viewAdminModule']//span[text()='Admin']")
	public WebElement admin; 
	
	@FindBy(xpath ="//span[text()='Organization']")
	public WebElement organization;

	@FindBy(xpath ="//span[text()='Locations']")
	public WebElement locations;


	public HomePage(){
		PageFactory.initElements(driver, this);
	}
}
