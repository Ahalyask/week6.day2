Feature: Create Lead functionality

@Functional
Scenario: TC001_Create Lead positice testcase positive
Given enter username as 'DemoSalesManager'
And enter password as 'crmsfa'
When click on login button
And click on CRM/FSA
And click on Leads
And click on Create Leads
Given company name as 'Noesys'
And first name as 'Ahalya'
And last name as 'S K'
When click on submit
Then confirm title

@Smoke
Scenario: TC002_Create Lead positice testcase negative
Given enter username as 'DemoSales'
And enter password as 'crms'
When click on login button

@Regression @Smoke
Scenario Outline: TC003_Create Lead positive testcase multidata
And enter username as <Uname>
And enter password as <Password>
When click on login button
And click on CRM/FSA
And click on Leads
And click on Create Leads
Given company name as <Cname>
And first name as <Fname>
And last name as <Lname>
When click on submit
Then confirm title

Examples:

|Uname|Password|Cname|Fname|Lname|
|'DemoSalesManager'|'crmsfa'|'Noesys'|'Ahalya'|'S K'|
|'DemoSalesManager'|'crmsfa'|'TestTaps'|'Anu'|'S'|
|'DemoSalesManager'|'crmsfa'|'Qeagle'|'Arjun'|'K'|