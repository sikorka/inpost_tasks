Feature: Search for delivery points

# API test that will perform a Parcel Lockers search for a city (several cities) and save the data of the returned Parcel Lockers (name, postal code, coordinates) to the file 'parcellockers.{city}.json'.

  @TASK-2-1
  @api
  @prod @sandbox @plpoints
  Scenario: Parcel Lockers - Search - by City
    When searching for Parcel Lockers by city "Wrocław"
    Then Parcel Lockers found

  @TASK-2-2
  @api
  @prod @sandbox @plpoints
  Scenario: Parcel Lockers - Search - by Cities
    When searching for Parcel Lockers by several cities "Kraków, Warszawa, Wrocław"
    Then Parcel Lockers found
