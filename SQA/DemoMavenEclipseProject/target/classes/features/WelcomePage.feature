#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: User navigation localization
  
  @tag1
  Scenario Outline: User navigate to www.gov.lk with different languages
    Given User on the Welcome Page of "https://www.gov.lk/welcome"
    When User click on "<language>"
    Then User should navigate to home page successfully with correct "<language>"
    
		Examples: 
      | language | 
      | sinhala  | 
      | tamil    |  
      | english  |  
