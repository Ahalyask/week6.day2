Feature: duplicate lead functionality

Scenario Outline: duplicate Lead test case
Given enter username as 'DemoSalesManager'
And enter password as 'crmsfa'
When click on login button
And click on CRM/FSA
And click on Leads
And click on Merge lead menu
Given first Lead Name <fLName>
Given Second Lead Name <sLName>
When cick on Merge button
Then verify Merge page title

Examples:
|fLName|sLName|
|'Ahalya'|'Anu'|