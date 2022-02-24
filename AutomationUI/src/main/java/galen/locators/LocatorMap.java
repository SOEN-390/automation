package galen.locators;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LocatorMap {
    private static final Logger LOG = LoggerFactory.getLogger(LocatorMap.class);
    WebDriver driver;

    public LocatorMap(WebDriver driver) {
        this.driver = driver;
    }

    public Pair<String, String> getLocator(WebElement element) {
        LOG.info("Convert element to pair of a locator and the path", element);
        if (element.toString().contains("Proxy")) {
            String type = (element.toString().split(" ")[4]).split("\\.")[1].replaceFirst("\\:","");
            String path = (element.toString().split(" ")[5]).replaceFirst("]'","]");
            return Pair.of(type,path);
        } else {
            String[] variable = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

             if(variable[0].contains("xpath") || variable[0].contains("id")){
                return Pair.of(variable[0], variable[1]);
            }
            else {
                return Pair.of("xpath", getElementXPath(element));
            }
        }
    }

    private String getElementXPath(WebElement element) {
        LOG.info("Convert the element to xpath", element);

        return (String)((JavascriptExecutor)this.driver)
                .executeScript(
                        "gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();"
                        , element);
    }

}
