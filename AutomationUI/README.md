## Prerequisites
A. Make sure JAVA is installed on your environment 
- Run `java -version` in your terminal to verify

B. Make sure Maven is installed on your environment
- If not run `brew install maven`

## Open the project in IDE
1. Clone the project
2. Launch IntelliJ --> Go to File --> Open --> navigate to the cloned project and double-click on the ```pom.xml``` file under ```AutomationUI``` folder -> Click on the `“Open as Project”` option
4. Once download is complete, open the `pom.xml` file and make sure no dependency is highlighted in red


## How to run a full test suit:
1. Make sure your local environment and the COVID 19 Tracker application is running locally and is reachable
2. In the IDE go to "Terminal" and run
   ` mvn clean install `

   :warning:  If during the execution you have an error of Chrome driver version, go to the [official site](https://chromedriver.chromium.org/downloads) to download the relevant version

## How to view a test result
1. Once a test execution is over, go to the "target" folder either in IDE or on your machine
2. Under the "Automation UI" folder, expand the "cucumber-html-report" folder and launch any of "overview - ....html" files

## How to create cucumber test scenario:
1. Go to ```src/test/resources/CovidTracker/ ```
2. Add a new file with ```.feature``` extension
3. Write cucumber scenario:
    * Use the [Gherkin syntax for that:](https://cucumber.io/docs/gherkin/)


    :warning: **To avoid code duplication do the steps below**
    1) View the existing scenarios
    2)  Copy the sentences which are suitable for your flow
    3)  Paste the sentences into your ```.feature``` file

4. If you get a chromedriver error:
    * If it says "wrong version", --> verify you have the right version [here](https://chromedriver.storage.googleapis.com/index.html)
    * If it says "unidentified developer by Apple", --> get to your chromedriver in your file system and open it with the terminal until it says "chromedriver was started successfully"

## How to generate missing (not implemented) steps
1. Make sure you added steps of a test in the ```.feature``` file (see the item above)
2. Locate the "Run Scenario" button in your ```.feature``` file and click on the first "Run ..." option
   <img src="https://user-images.githubusercontent.com/82170299/120384471-3744da00-c2f4-11eb-8c03-d7f5dabc8081.png" width="300" height="150" align="center">


3. When the fake test execution is failed, scroll down the towards the test output and find the "You can implement missing steps with the snippets below:" string
   <img src="https://user-images.githubusercontent.com/82170299/120384738-8a1e9180-c2f4-11eb-97b6-185e2931c615.png" width="400" height="250" align="center">


4. Those are steps which should be added to the relevant .java class accordingly

## How missing/not implemented steps should be added/managed in the framework
1. Go to ```src/test/java/CovidTracker/testsDefinition/```
2. Open a .java file that includes a name "page" 
   - The "not implemented case" could be executed, for instance if a step says *"User searches a text on the home page"* as in the function below:

           ```
           @When("User searches a text on the home page")
           public void User_searches_a_text_on_the_home_page(String str) {
               // Write code here that turns the phrase above into concrete actions
               throw new io.cucumber.java.PendingException();
           } 
           ```

Open the "HomePageSteps.java" file and add the new function with relevant code. Otherwise, if a sentence of the script describes event/action on a page which does not exist under ```/testsDefinition/``` --> add a new .java file with a name of the following format:
*pageName*Steps.java

:warning: **The name of "glue" .java file should contain name of the relevant page**

:high_brightness:Explanation: Why the name of a file is so important?
1) That approach makes a code maintenance easley
2) It avoids code duplication



# How to Create a Page Object

1) In the pageObjects, add java class file with the name of a page.

   NOTE: If the page uses common elements, extend the page from the CommonElements class

2) Add all locators of the page elements by PageFactory (look at any page classes as an exmaple)
3) List all locators under ```public Map<String, Pair<String, String>> getLocators()``` function, take a look at any page class as an example
4) Create functions of the all actions which are relevant for the page (under test)
5) In the ```controls/PageObjectControl.java``` class, create a get function of the new page


# How to create a Layout spec

1. Under the ```pageObjects``` folder, add a new folder with a name of the page under test.
2. Move the relevant page object class to that folder
3. Create a new file with .gspec extension
4. Use the [Galen Syntax](http://galenframework.com/docs/reference-galen-spec-language-guide/) to create scenarios


:warning: **NOTE: you should NOT use the ```@objects``` section to declare elements under a test since they will be added automatically during a test execution, however, you should use exactly the same names pool which are declared in the relevant page object. 
