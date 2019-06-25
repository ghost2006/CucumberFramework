package com.orangehrm.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	 WebDriver driver;
	 
	@Given("I navigated to the Google")
	public void i_navigated_to_the_Google() {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://google.com");
	}

	@When("I type search item")
	public void i_type_search_item() {
	   driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("iphone");
	}

	@When("I click on search button")
	public void i_click_on_search_button() {
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform(); 
	}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
	    System.out.println("Results are displayed");
	}

}
