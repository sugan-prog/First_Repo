
Feature: OMR Branch Select Hotel Functionality

This feature verifies the select hotel functionality of the OMR Branch hotel application,

including selecting hotels, handling alerts, and navigating to the Book Hotel page.



Background:

Given User is on the OMR Branch hotel page

When User enters "sugancse27@gmail.com" and "Sugandhi@123"

Then User should verify success message after login "Welcome Sugandhi"

When User search hotel "Tamil Nadu", "Chennai", "Suite", "25-11-2026", "26-11-2026", "1-One", "2-Two" and "1"

Then User should verify after search hotel success message "Select Hotel"



Scenario: Verify select last hotel and navigate to Book Hotel page

When User save the last hotel name and hotel price

And User select the last hotel and accept the alert

Then User should verify after select success message "Book Hotel"



Scenario: Verify select second from last hotel and navigate to Book Hotel page

When User save the second from last hotel name and hotel price

And User select the second from last hotel and accept the alert

Then User should verify after select success message "Book Hotel"



Scenario: Verify select second hotel and dismiss the alert

When User save the second hotel name and hotel price

And User select the second hotel and dismiss the alert

Then User should verify after select success message "Select Hotel"

