Feature: Add employee 2

  Background: 
    Given I logged in into Orange Hrm
    And I click on PIM link
    And I click on add employee link

  @addEmployee2
  Scenario Outline: Add employee
    When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
    And I click on save button
    Then I see data is displayed:
      | FirstName | <FirstName> |
      | LastName  | <LastName>  |

    Examples: 
      | FirstName | MiddleName | LastName | Location     |
      | Jane      | J          | Smith    | Smart Office |
      | John      | W          | West     | New Office   |
      | Kira      | V          | Thompson | West Office  |
