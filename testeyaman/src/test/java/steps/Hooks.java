package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import factory.WebDriverFactory;

public class Hooks {

	@Before()
	public void BeginTest() {
		WebDriverFactory.openChrome();
	}
	
	@After()
	public void TearDown() {
		WebDriverFactory.killDriver();
	}
}
