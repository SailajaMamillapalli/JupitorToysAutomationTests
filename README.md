# JupitorToysAutomationTests
Framework is built using below:  
**Java** - Language used in this framework  
**Selenium Webdriver** - UI testing tool for executing UI test cases (Driving the Webbrowser)  
**TestNg** - Test library for executing tests locally and remotely also in the pipeline  
**Maven** - Build and dependency manager  
**Page Object Model/pattern** and **Page Factory** concepts were used to build this framework  
**Webdriver Manager** dependency was used to mitigate the issue of Browser version and driver version discrepancies  

**ASSUMPTIONS**  
**Browser support:** Only catered for Chrome browser as it the most popular browser in use. Multiple browser capability can be built in to the framework based on the userinput/CI/CD piepline
**Parallel test execution:** Not currently supported here. This can be setup using **Selenium Grid** when this is required  
**Multiple Environment:** Capability of execution against multiple environments is not supported. This can also be setup when required  
**Test data:** As the requirement here was to run some basic tests, there is no requirement for setting up a separate test data capability. If required, seperate helper methods to read from various files and Database can be set up  
No assertions are required for Surname and Telephone fileds  
