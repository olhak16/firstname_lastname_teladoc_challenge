@task#1
Feature:
I need to automate http://www.way2automation.com/angularjs-protractor/webtables/
So that I can show my awesome automation skills

Scenario: Add a user and validate the user has been added to the table
  Given User is on the practice page
  When User clicks on Add User button
  Then new window pops up and user has to input information
  And User has to fill out First Name field
  And User has to fill out Last Name field
  And User has to fill out User Name field
  And User has to fill out Password field
  And User has to chose a role
  And User needs to add email
  And User needs to add phone number and click Save button
  Then User should be able to see his info added to the list



  Scenario: Delete the user "novak" from the table and validate the user has been deleted.
    Given User locates novak user and clicks on remove icon
    Then new window pops up and User needs to click ok button
    Then User can confirm that novak information has been deleted successfully

