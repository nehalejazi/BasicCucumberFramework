package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	 private DriverFactory  driverFactory;
	 private WebDriver driver;
	 private ConfigReader configReader;
	 private Properties prop ;
	 
	 @Before(order = 0)
	 public void getProperty()
	 {
		 configReader  = new ConfigReader();
		 prop = configReader.init_prop();
	 }
	 @Before(order = 1)
	 public void launchBrwoser()
	 {
		 driverFactory  = new DriverFactory();
		 driver = driverFactory.initDriver(prop.getProperty("browser"));
	 }
	 
	 @After(order=0)
	 public  void quitBrwoser()
	 {
		 driver.quit();
	 }
	 
	 @After(order=1)
	 public  void teardown(Scenario sc)
	 {
		 if(sc.isFailed())
		 {
			String screenshotname = sc.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcepath, "image/png", screenshotname);
		 }
		 
	 }
	 
	

}
