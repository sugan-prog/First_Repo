Feature: OMR Branch Cancel Booking Functionality

 This feature verifies the cancel booking functionality of the OMR Branch hotel application,

 including cancel booking flows for Card and UPI payments.



 Background:

  Given User is on the OMR Branch hotel page

  When User enters "sugancse27@gmail.com" and "Sugandhi@123"

  Then User should verify success message after login "Welcome Sugandhi"

  When User search hotel "Tamil Nadu", "Chennai", "Suite", "25-05-2026", "26-05-2026", "1-One", "2-Two" and "1-One"

  Then User should verify after search hotel success message "Select Hotel"



 Scenario Outline: Verify cancel created Order ID using card payment with GST and special request

  When User save the last hotel name and hotel price

  And User select the last hotel and accept the alert

  Then User should verify after select success message "Book Hotel"

  When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"

  And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>"

  And User add Special Request "<Request>"

  And User enter payment details, proceed with Card Type "<Card Type>"

   | Select Card | Card No     | Card Name | Month | Year | CVV |

   | Visa    | 5555555555552223 | Your name | July | 2025 | 123 |

   | MasterCard | 5555555555554444 | Your name | July | 2025 | 123 |

   | Amex    | 5555555555550000 | Your name | July | 2025 | 123 |

   | Discover  | 5555555555556666 | Your name | July | 2025 | 123 |

  And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID

  Then User should verify same selected Hotel is booked or not

  When User navigate to My Booking page

  Then User should verify after navigate to My Booking page success message as "Bookings"

  When User search the Order ID

  Then User should verify same booked Order ID is present or not

  And User should verify same booked Hotel Name is present or not

  And User should verify same booked Hotel Price is present or not

  When User edit the Check-in Date "<Modify Date>"

  Then User should verify after modify check-in date success message "Booking updated successfully"

  When User search the Order ID

  Then User should verify same booked Order ID is present or not

  When User should Cancel the new order ID

  Then User should verify after cancel booking success message "Your booking cancelled successfully"



  Examples:

   | Select Salutation | First Name | Last Name | Mobile No. | Email     | Enter Registration No. | Enter Company Name | Enter Company Address | Request   | Card Type | Modify Date |

   | Mr.        | Greens   | Tech   | 9876543210 | test@gmail.com | 123456789012345    | Greens Tech    | Chennai        | Need parking | Visa   | 30-05-2026 |



 Scenario Outline: Verify cancel created Order ID using UPI payment with GST and special request

  When User save the last hotel name and hotel price

  And User select the last hotel and accept the alert

  Then User should verify after select success message "Book Hotel"

  When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"

  And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>"

  And User add Special Request "<Request>"

  And User enter upi details "<UPI ID>" and click submit

  And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID

  Then User should verify same selected Hotel is booked or not

  When User navigate to My Booking page

  Then User should verify after navigate to My Booking page success message as "Bookings"

  When User search the Order ID

  Then User should verify same booked Order ID is present or not

  And User should verify same booked Hotel Name is present or not

  And User should verify same booked Hotel Price is present or not

  When User edit the Check-in Date "<Modify Date>"

  Then User should verify after modify check-in date success message "Booking updated successfully"

  When User should Cancel the new order ID

  Then User should verify after cancel booking success message "Your booking cancelled successfully"



  Examples:

   | Select Salutation | First Name | Last Name | Mobile No. | Email     | Enter Registration No. | Enter Company Name | Enter Company Address | Request   | UPI ID    | Modify Date |

   | Mr.        | Greens   | Tech   | 9876543210 | test@gmail.com | 123456789012345    | Greens Tech    | Chennai        | Need parking | test@okicici | 30-05-2026 |



 Scenario Outline: Verify cancel existing Order ID

  When User navigate to My Booking page

  Then User should verify after navigate to My Booking page success message as "Bookings"

  When User should Cancel the existing order ID "<Order ID>"

  Then User should verify after cancel booking success message "Your booking cancelled successfully"



  Examples:

   | Order ID  |

   | #YPJCO46488 |



 Scenario: Verify cancel first displayed Order ID

  When User navigate to My Booking page

  Then User should verify after navigate to My Booking page success message as "Bookings"

  When User should Cancel the first order ID

  Then User should verify after cancel booking success message "Your booking cancelled successfully"



 Scenario: Verify cancel last displayed Order ID

  When User navigate to My Booking page

  Then User should verify after navigate to My Booking page success message as "Bookings"

  When User should Cancel the last order ID

  Then User should verify after cancel booking success message "Your booking cancelled successfully"

