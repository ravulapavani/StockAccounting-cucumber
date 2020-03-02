Feature: validating login tests

Scenario Outline: supplier creation functionality validation

When open Browser
When open Application
When Wait For Username
When Enter Username
When Wait For Password
When Enter Password
When Wait For Login
When Click On Login
When Wait for Supplier
When Click On Supplier
When Wait For Add Button
When Clcik On Add Button
When Wait For SupplierNumber
Then Capture Data
When Wait For SupplierName
When Wait For SupplierName
When Enter in "<Supplier Name>" with "id" and "x_Supplier_Name"
When Enter in "<Adress>" with "xpath" and "//*[@id='x_Address']"
When Enter in "<city>" with "xpath" and "//*[@id='x_City']"
When Enter in "<Country>" with "xpath" and "//*[@id='x_Country']"
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']"
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']"
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']"
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']"
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Notes']"
When wait for Add Button
When Click On Add Button after adding notes
When Wait For Ok Button
When Click On Ok Button  with "xpath" and "(//*[text()='OK!'])[1]"
When Wait For Alert
When Click On Alert
Then User validate supplier table
When Close the browser

Examples:
|Suppliername|address|city|country|cperson|pnumber|mail|mnumber|note|
|pavani1|ecil|Hyderabad|India|pavaniravula|8897228651|kalthireddypavani@gmail.com|9949873767|iam purchasing bag1|
|pavani2|ecil|Hyderabad|India|pavaniravula|8897228651|kalthireddypavani@gmail.com|9949873767|iam purchasing bag2|