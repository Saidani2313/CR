package org.runner;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.qa.base.DriverCapabilities;
import com.qa.base.JvmReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"pretty", "summary"},
        plugin = {"json:target/ResultsMobile/cucumber.json"},
        features = {"src/test/resources"},
        glue = "com.qa.tests",
        tags = "@ipl",
        dryRun = false,
        monochrome = true
)
public class RunnerTest extends DriverCapabilities {
//public class RunnerTest extends AbstractTestNGCucumberTests {
        @AfterClass
        public static void afterClass() throws IOException {   
                //System.out.println("AfterClass Report");
	        JvmReport.generateReport(System.getProperty("user.dir")+"/target/ResultsMobile/cucumber.json");  
		   }
}

