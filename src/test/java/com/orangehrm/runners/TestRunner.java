package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue="com/orangehrm/steps",
        //dryRun=true,  // if dryRun=true --> it will check if all our steps have been defined before execution. After we checked, we should change it on false
        monochrome=true, //shows more readable format in console. 
        tags= {"@temp"} // specifying which test we want to execute or exclude {"~ @login"}
       ,plugin= {"pretty", "html:target/cucumber-default-reports", "json:target/cucumber.json"} //pretty report format, json-it's file format of arrays
        )


public class TestRunner { // it's like our xm.file in testNG
}
