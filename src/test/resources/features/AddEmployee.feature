@addEmployee @sprint5
Feature: Add employee
essfully
  Background: 
    Given I logged in into Orange Hrm
    And I click on PIM link
    And I click on add employee link

  @smoke 
  Scenario Outline: Add employee
    When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
    And I click on save button
    Then I see "<FirstName>", "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName | Location     |
      | Jane      | J          | Smith    | Smart Office |
      | John      | W          | West     | New Office   |
      | Kira      | V          | Thompson | West Office  |

  #Examples: will define how many time we'll run our scenario
  @regression 
  Scenario Outline: Add Employee and Create Login Details
    When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
    And I click on create login details
    And I provide all mandatory fields:
      | Username        | <UserName>        |
      | Password        | <Password>        |
      | ConfirmPassword | <ConfirmPassword> |
      | ESS_Role        | <Ess_Role>        |
      | Supervisor_Role | <Supervisor_Role> |
    And I click on save button
    Then I see "<FirstName>", "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName | Location       | UserName | Password            | ConfirmPassword     | ESS_Role    | Supervisor_Role    |
      | Kim       | J          | Smith    | Smart Office   | Kim      | Aa12345678!Aa!NBGJK | Aa12345678!Aa!NBGJK | Default ESS | Default Supervisor |
      | Kate      | W          | West     | Central Office | Kate     | Aa12345678!Aa!NBGJK | Aa12345678!Aa!NBGJK | Default ESS | Default Supervisor |
      | Nick      | V          | Thompson | South Office   | Nick     | Aa12345678!Aa!NBGJK | Aa12345678!Aa!NBGJK | Default ESS | Default Supervisor |

@regression @temp
  Scenario: Add Employee and Create Login Details
    When I provide Employee details from "EmployeeDetails"
    And I click on create login details
    And I provide all mandatory fields:
    And I click on save button
    Then I see employee is added successfully

  @regression 
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Name           |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
# data table above and it will run only one step 5 times. to execute multiple times one scenario- will use DataTable
