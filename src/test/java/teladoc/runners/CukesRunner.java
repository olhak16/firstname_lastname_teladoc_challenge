package teladoc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = ""
)
public class CukesRunner {


}
