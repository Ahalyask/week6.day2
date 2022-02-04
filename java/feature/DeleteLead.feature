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
When store Resultant searched first lead id and click lead link
And click delete button
And click on find Leads menu
And pass stored id to inputtext 
And click on find leads
Then verify no records message




Examples:
|name|
|'Ahalya'|
|'Anu'|