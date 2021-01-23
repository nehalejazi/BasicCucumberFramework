Feature: Login Page feature

Scenario: Login page Title
 Given User is on Login Page
 When user get the page title
 Then Page title is "Demo Web Shop. Login"
 
 
Scenario: Forgot Password Link
 Given User is on Login Page
 When user verify forgot password link
 Then Forgor password link should be availble
 
 
Scenario: Login with Correct credentials
 Given User is on Login Page
 When user enter username as "test321@testing.com"
 And user enter password as "India321"
 And user click on login button
 Then user get the page title
 And Page title is "Demo Web Shop"
