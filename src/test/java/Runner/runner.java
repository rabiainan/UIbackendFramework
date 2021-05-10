package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty",
                "html:target/htmlReport/cucumber.html",
                //"json:target/jsonReport/cucumber.json"},
                "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"
        },
        features = "src/test/resources/features",
        glue = {"Steps"},
        dryRun=false,
        tags = "@web or @api"
        //monochrome = true

)

public class runner {
}
