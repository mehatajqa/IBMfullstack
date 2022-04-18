Feature: Register for E-learning skills

Scenario Outline: Verify User Registration for E-learning skills

Given User clicks on Sign-up link
When User enters the Registration details
|FirstName|LastName|E-mail|UserName|Pass|ConfirmPassword|
|Mehataj|Nizam|mehatajece@gmail.com|sharmilaniz|hello123|hello123|
And clicks on Register button
Then User receives success message "<SuccessMessage>"
When User clicks next button
And clicks Profile in the dropdown menu
And user send messages


Examples:

|SuccessMessage|
|Your personal settings have been registered.|


 
