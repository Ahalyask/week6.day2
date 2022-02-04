Feature: duplicate lead functionality

Background: login scenario
Given enter username as 'DemoSalesManager'
And enter password as 'crmsfa'
When click on login button
And click on CRM/FSA
And click on Leads
And click on Create Leads

Scenario Outline: duplicate Lead test case
#Given enter username as 'DemoSalesManager'
#And enter password as 'crmsfa'
#When click on login button
#And click on CRM/FSA
#And click on Leads
#And click on find Leads menu
Given enter name as <name>
When click on find leads
And select first search result
And click on dupicate lead
Then verify title of duplicate lead page
When click on submit
Then verify Dulicate lead name <name>



Examples:
|name|
|'Ahalya'|
|'Anu'|