Feature: Login and product adding Test Scenarios

Scenario Outline: Verify if the user is able to login and add product
Verify if the user is able to log in to Swiggy with proper location
Given User launches the application
When The user enters valid <location>
Then Check if the user has login successfully
Then The user searches for the <product>
Then Check if the appropriate product page is getting displayed
And The user selects a product and added it into the cart
And Check if the Selected product is successfully added into the cart
And Close the browser

Examples:
|location                  |product               |
|Pune, Maharashtra, India  |Chicken parm Burger   |