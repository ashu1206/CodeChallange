@runall
Feature: Automation of OrangeHRM Web Application


Scenario Outline: Automating Login feature of the OrangeHRM Web Application
Given that user launch the "<url>" and is on login page
Then user login with valid "<username>" & "<password>" 
And the page redirected to the dashboard



Examples: 
| url     | username     | password |
|orangeurl|  useradmin   | adminpass|



Scenario Outline: Adding new Employee in the OrangeHRM Web Application
Given that user launch the "<url>" and is on login page
Then user login with valid "<username>" & "<password>" 
And the page redirected to the dashboard
Then user clicks on PIM tab
And click on button labelled as Add
Then user enters his "<firstName>" 
And enters his "<lastName>"
Then upload a picture
And click on button labelled as Save
And verify that user is redirected to the dashboard


Examples: 
| url     | username  | password |  firstName  | lastName |
|orangeurl| useradmin | adminpass|  Ashutosh   |  Shukla  |


Scenario Outline: Verify the new Employee added in the OrangeHRM Web Application
Given that user launch the "<url>" and is on login page
Then user login with valid "<username>" & "<password>" 
Then user clicks on PIM tab
And enter the "<name>" added in the above test step
Then click on the Search button
And verify that the "<name>" addded is present



Examples: 
| url     | username  | password  | name     |
|orangeurl| useradmin | adminpass |Ashutosh  |


