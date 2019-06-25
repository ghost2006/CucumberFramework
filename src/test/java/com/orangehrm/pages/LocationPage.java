package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class LocationPage extends BaseClass {
	
	@FindBy(xpath ="//a[contains(@class,'btn-floating btn')]/i")
	public WebElement addLocation;

	@FindBy (id="name")
	public WebElement name;
 
	@FindBy (id="city")
	public WebElement city;
	
	@FindBy (id="zipCode")
	public WebElement zip;
 
	@FindBy (xpath="//div[@id='countryCode_inputfileddiv']//input")
	public WebElement country;
	
	@FindBy (xpath="//div[@id='countryCode_inputfileddiv']//input/following-sibling::ul")
	public WebElement contryList ;
	
	@FindBy (xpath ="//a[text()='Save']")
    public WebElement saveBtn;
	
	public LocationPage(){
		PageFactory.initElements(driver, this);
	}
}


