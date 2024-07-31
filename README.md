Task description
================

**Required technologies / libraries**

1. Java
2. Maven
3. Cucumber
4. Selenium Webdriver
5. Rest Assured
6. Docker

**Task 1.**

GUI test that will perform a search for a package on the InPost website by its number and check if it has a status as expected.
List of packages with statuses:
- no: 520113014230722029585646, expected status: Delivered
- no: 520107010499997005638120, expected status: Passed for delivery
- No: 523000016696115042036670, expected status: The label was cancelled
- No: 520000011395200025754311, expected status: Delivered

**Task 2.**

API test that will perform a Parcel Lockers search for a city (several cities) and save the data of the returned Parcel Lockers (name, postal code, coordinates) to the file 'parcellockers.{city}.json'.

**Guidelines:**

- publish the repository with the solved tasks on github.
- run tests from a Docker image
- when running tests it should be possible to indicate whether you want to run only GUI , API or all tests
- test results should produce html report
- GUI test report should contain screenshot in case of unsuccessful test result
- (\*) simulation of running tests on few environments
- (\*) docker-compose.yml

**Deadline**: usually 3 working days is enough, please let me know if you need more time.


In case of any questions regarding the task, do not hesitate to reach out to us.
However please note that all needed informations are in the task and if you'd have any assumptions, feel free to document them.

You may send us your solution as a .zip or a link to your repository.

Run tests
=========

All tests: 

    

API tests:



UI tests:

