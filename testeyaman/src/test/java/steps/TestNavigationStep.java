package steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.PraticeSitePageObject;
import pageobject.RegisterPageObject;

public class TestNavigationStep {

	RegisterPageObject register = new RegisterPageObject();
	PraticeSitePageObject pratice = new PraticeSitePageObject();
	
	@Given("I open url {string}")
	public void i_open_url(String url) {
		register.openUrl(url);
	}

	@Given("write a email {string}")
	public void write_a_email(String email) throws InterruptedException {
		Thread.sleep(1000);
		register.signUp(email);
	}

	@When("I register my personal data")
	public void i_register_my_personal_data() throws InterruptedException {
		Thread.sleep(1000);
		register.register();
	}

	@When("delete an old record")
	public void delete_an_old_record() throws InterruptedException {
		Thread.sleep(1000);
		register.deleteOldRecord();
	}

	@When("select the {string} in menu {string}")
	public void select_the_in_menu(String bookSelected, String menuPage) throws InterruptedException {
		Thread.sleep(1000);
		register.menuPracticeSiteNavigation();
		Thread.sleep(1000);
		pratice.chooseBook();
	}

	@When("create my resgistration")
	public void create_my_resgistration() throws InterruptedException {
		Thread.sleep(1500);
		pratice.billingDetails();
		Thread.sleep(2000);
	}

	@Then("I validate if the book are buying")
	public void i_validate_if_the_book_are_buying() {
		assertTrue(pratice.OrderExist());
	}

}
