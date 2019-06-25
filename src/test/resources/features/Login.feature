#Author: syntax team OR email(firstLast name).@wellsfargo.com
@sprint3 @login
Feature: Login

  Background: 
    Given I see OrangeHrm logo

  @smoke @log
  Scenario: Valid login
    When I enter valid username & password
    And I click login button
    Then I successfully logged in

  @regression 
  Scenario: Invalid login
    When I enter invalid username & password
    And I click login button
    Then I see error massage is displayed

  @regression
  Scenario: Error message Validation
    When I enter invalid username & password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | admin123   | Invalid Credentials |
      | Admin1   | syntax123! | Invalid Credentials |
      | Admin2   | syntax123  | Invalid Credentials |
 # Background is applicable only for the current feature.file
 # feature file defines the code flow! 'given', 'and' don't matter for us, only steps for ex.'I see OrangeHrm logo' matter, can use even * instead of keywords
