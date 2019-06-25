package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;

public class LoginPage extends BaseClass{
	//our object repository 
	
	@FindBy(id ="txtUsername")
	public WebElement name;
	
	@FindBy(xpath ="//input[@id='txtPassword']")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(id ="divLogo")
	public WebElement logo;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement invalidLog;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName, String userPassword) {
		CommonMethods.sendText(name, userName);
		CommonMethods.sendText(password, userPassword);
		CommonMethods.click(loginBtn);
	}
}