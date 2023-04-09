Feature: Application Login
Scenario: Login with valid credentials

Given Open any browser
And Navigate to login page
When User enter username as "Alka@gmail.com" and password as "Standard" into the fields
And User clicks on login Button
Then verify user is able to successfully login