Feature: Home page features

Background: 
Given user is alreday logged into the application
|username|password|
|test321@testing.com|India321|

Scenario: Register button availblity on Homepage
 Given User is on Homepage
 When user verify Register option
 Then Register option should not be visible
 
 Scenario: Homepage title validation
 Given User is on Homepage
 When user get the page title
 Then Page title is "Demo Web Shop"
 
 Scenario: Community poll options on Homepage
 Given User is on Homepage
 When user verify Community poll option
 Then Community poll options should be visible
 |Excellent|
 |Good|
 |Poor|
 |Very bad|
 And total number options should be 4