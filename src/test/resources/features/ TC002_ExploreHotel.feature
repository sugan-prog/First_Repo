Feature: OMR Branch Hotel Search Functionality

 This feature verifies the hotel search functionality of the OMR Branch hotel application,

 including search with all fields, mandatory fields, validations, sorting, filtering,

 and header verification.



 Background:

  Given User is on the OMR Branch hotel page
  When User enters "sugancse27@gmail.com" and "Sugandhi@123"
  Then User should verify success message after login "Welcome Sugandhi"



 Scenario Outline: Verify search hotels with all fields

  When User search hotel "<State>", "<City>", "<Room type>", "<Check in date>", "<Check out date>", "<No of Room>", "<No of Adults>" and "<No of Childs>"

  Then User should verify after search hotel success message "Select Hotel"



  Examples:

   | State   | City  | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |

   | Tamil Nadu | Chennai | Suite   | 25-11-2026  | 26-11-2026   | 1-One   | 2-Two    | 1    |



 Scenario Outline: Verify search hotels with only mandatory fields

  When User search hotel "<State>", "<City>", "<Check in date>", "<Check out date>", "<No of Room>" and "<No of Adults>"

  Then User should verify after search hotel success message "Select Hotel"



  Examples:

   | State   | City  | Check in date | Check out date | No of Room | No of Adults |

   | Tamil Nadu | Chennai | 25-11-2026  | 26-11-2026   | 1-One   | 2-Two    |



 Scenario: Verify search hotel without entering any fields

  When User click Search button

  Then User should verify after search hotel error message "Please select state", "Please select city", "Please select Check-in date", "Please select Check-out date", "Please select no. of rooms" and "Please select no. of adults"


 Scenario Outline: Verify hotel price sorting from low to high

  When User search hotel "<State>", "<City>", "<Room type>", "<Check in date>", "<Check out date>", "<No of Room>", "<No of Adults>" and "<No of Childs>"

  Then User should verify after search hotel success message "Select Hotel"

  When User click sort from low to high

  Then User should verify after sorting that prices are listed from low to high



  Examples:

   | State   | City  | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |

   | Tamil Nadu | Chennai | Suite   | 25-11-2026  | 26-11-2026   | 1-One   | 2-Two    | 1    |



 Scenario Outline: Verify hotel name sorting in descending order

  When User search hotel "<State>", "<City>", "<Room type>", "<Check in date>", "<Check out date>", "<No of Room>", "<No of Adults>" and "<No of Childs>"

  Then User should verify after search hotel success message "Select Hotel"

  When User click sort from descending order

  Then User should verify after sorting that names are listed in descending order



  Examples:

   | State   | City  | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |

   | Tamil Nadu | Chennai | Suite   | 25-11-2026  | 26-11-2026   | 1-One   | 2-Two    | 1    |



 Scenario Outline: Verify Suite room type hotels are listed

  When User search hotel "<State>", "<City>", "<Room type>", "<Check in date>", "<Check out date>", "<No of Room>", "<No of Adults>" and "<No of Childs>"

  Then User should verify after search hotel success message "Select Hotel"

  When User click Suite room type

  Then User should verify after filtering that Suite room type is listed



  Examples:

   | State   | City  | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |

   | Tamil Nadu | Chennai | Suite   | 25-11-2026  | 26-11-2026   | 1-One   | 2-Two    | 1    |



 Scenario Outline: Verify header contains selected room type

  When User search hotel "<State>", "<City>", "<Room type>", "<Check in date>", "<Check out date>", "<No of Room>", "<No of Adults>" and "<No of Childs>"

  Then User should verify after search hotel success message "Select Hotel"

  And User should verify the header contains "<Room type>"



  Examples:

   | State   | City  | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |

   | Tamil Nadu | Chennai | Suite   | 25-11-2026  | 26-11-2026   | 1-One   | 2-Two    | 1   |

