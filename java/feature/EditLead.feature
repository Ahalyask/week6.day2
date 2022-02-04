Feature: Create Lead functionality

Scenario Outline: TC001_Create Lead positice testcase positive
Given enter username as 'DemoSalesManager'
And enter password as 'crmsfa'
When click on login button
And click on CRM/FSA
And click on Leads
And click on find Leads menu
Given enter name as <name>
When click on find leads
And select first search result
When click on edit button
Given enter company new name as <Cname>
When click on submit
Then verify the updated Company name as <Cname>


Examples:
|name|Cname|
|'Ahalya'|'TestLeaf1'|
|'Anu'|'Qeagle1'|
