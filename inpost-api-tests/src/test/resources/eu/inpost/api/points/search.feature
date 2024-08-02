Feature: Search for delivery points

# API test that will perform a Parcel Lockers search for a city (several cities) and save the data of the returned Parcel Lockers (name, postal code, coordinates) to the file 'parcellockers.{city}.json'.

  @TASK-2-1
  @api @positive
  Scenario: Parcel Lockers - Search - by City
    When executing Parcel Lockers search by city "Wrocław"
    Then Parcel Lockers found for city

  @TASK-2-1
  @api @negative
  Scenario: Parcel Lockers - Search - by City - with trailing space
    When executing Parcel Lockers search by city "Wrocław "
    Then Parcel Lockers NOT found for city

  @TASK-2-2
  @api @positive
  Scenario: Parcel Lockers - Search - by Cities
    When executing Parcel Lockers search by cities "Kraków,Warszawa,Wrocław"
    Then Parcel Lockers found for each city

  @TASK-2-2
  @api @negative
  Scenario: Parcel Lockers - Search - by Cities - with spaces in between cities
    When executing Parcel Lockers search by cities "Kraków ,Warszawa ,Wrocław "
    Then Parcel Lockers NOT found for each city