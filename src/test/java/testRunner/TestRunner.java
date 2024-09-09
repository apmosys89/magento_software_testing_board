package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				//	features= {".//Features/"},
				//	features= {".//Features/MagentoLogin.feature"},
				//	features= {".//Features/MagentoAccountcreation.feature"},
				    features= {".//Features/MagentoLoginDDTExcel.feature"},
		
					
				//	features= {".//Features/MagentoLogin.feature",".//Features/MagentoAccountcreation.feature"},
					//features= {"@target/rerun.txt"},
					glue={"stepDefinitions","hooks"},
					plugin= {
								"pretty", "html:reports/myreport.html",   
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								//"rerun:target/rerun.txt",
							
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,  // to avoid junk characters in output
					publish=true     // to publish report in cucumber server
				//	tags="@sanity"
		)
public class TestRunner 
{

}


