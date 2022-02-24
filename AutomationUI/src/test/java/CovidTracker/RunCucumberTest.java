package CovidTracker;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/CovidTracker"},
        plugin = {"json:target/jsonReports/test-report.json","html:target/test-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@run_it"
)
public class RunCucumberTest {

}
