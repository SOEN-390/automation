package cucumber;

import controls.PageObjectControl;
import controls.WebDriverControl;


public class TestContent {
    private WebDriverControl webDriverController;
    private PageObjectControl pageObjectController;

    public TestContent(){
        webDriverController = new WebDriverControl();
        pageObjectController = new PageObjectControl(webDriverController.getDriver());
    }


    public WebDriverControl getWebDriverControl(){

        return webDriverController;
    }

    public PageObjectControl getPageObjectControl(){
        return pageObjectController;
    }

}
