Feature: Search for packages

#  GUI test that will perform a search for a package on the InPost website by its number and check if it has a status as expected.
#  List of packages with statuses:
#  - no: 520113014230722029585646, expected status: Delivered
#  - no: 520107010499997005638120, expected status: Passed for delivery
#  - No: 523000016696115042036670, expected status: The label was cancelled
#  - No: 520000011395200025754311, expected status: Delivered

  @TASK-1
  @gui @positive
  Scenario Outline: Packages - Search - by package number
    Given InPost website is open
    When I search for package "<number>"
    Then status should be "<status>"
    Examples:
      | number                   | status    |
      | 520113014230722029585646 | Collected |
      | 520107010499997005638120 | Passed for delivery |
      | 523000016696115042036670 | Label nullified     |
      | 520000011395200025754311 | Collected           |
