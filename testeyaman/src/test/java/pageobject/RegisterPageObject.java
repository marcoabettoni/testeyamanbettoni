package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObject extends PageObject{
	
	//Sign Up Page Elements
	@FindBy(id = "logo")
	private WebElement signUpLogo;
	
	@FindBy(id = "email")
	private WebElement signUpEmail;
	
	@FindBy(id = "enterimg")
	private WebElement signUpLink;
	
	//Registry Elements
	@FindBy(xpath = "//input[@ng-model='FirstName']")
	private WebElement registerFirstName;
	
	@FindBy(xpath = "//input[@ng-model='LastName']")
	private WebElement registerLastName;
	
	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	private WebElement registerAdress;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement registerEmail;
	
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement registerTel;
	
	@FindBy(xpath = "//input[@type='radio' and @value='Male']")
	private WebElement registerGenderMale;

	@FindBy(id = "checkbox2")
	private WebElement registerHobbiesMovies;
	
	@FindBy(xpath = "//*[@ng-model='Skill']")
	private WebElement registerSelectSkills;
	
	@FindBy(xpath = "//option[@value='Java']")
	private WebElement registerOptionJava;

	@FindBy(id = "countries")
	private WebElement registerFirstSelectCountry;
	
	@FindBy(xpath = "//option[@value='Brazil']")
	private WebElement registerFirstOptionCountry;
	
	@FindBy(id = "firstpassword")
	private WebElement registerPassword;
	
	@FindBy(id = "secondpassword")
	private WebElement registerConfirmPassword;

	@FindBy(id = "submitbtn")
	private WebElement registerSubmit;

	@FindBy(xpath = "//a[text()='Practice Site']")
	private WebElement menuPraticeSite;
	
	
	
	//Selector Methods
	public void selectLanguages() throws InterruptedException {
		driver.findElement(By.id("msdd")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='English']")).click();
		driver.findElement(By.xpath("//a[text()='Portuguese']")).click();
	}
	
	public void selectCountry() throws InterruptedException {
		driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//li[text()='United States of America']")).click();
	}
	
	public void selectBirthDate() throws InterruptedException {
		//select year
		driver.findElement(By.id("yearbox")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[@value='2000']")).click();
		//select month
		driver.findElement(By.xpath("//select[@ng-model='monthbox']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[@value='January']")).click();
		//select day
		driver.findElement(By.id("daybox")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[@value='1']")).click();
	}
	
	
	
	//Navigation Methods
	public void signUp(String email) {
		signUpEmail.sendKeys(email);
		signUpLink.click();
	}
	
	public void register() throws InterruptedException {		
		registerFirstName.sendKeys("FirstNameOption");
		registerLastName.sendKeys("SendoLAstName");
		registerAdress.sendKeys("adress to send");
		registerEmail.sendKeys("validEmailList3@email.com");
		registerTel.sendKeys("0204060800");
		registerGenderMale.click();
		registerHobbiesMovies.click();
		registerSelectSkills.click();
		Thread.sleep(500);
		registerOptionJava.click();
		registerFirstSelectCountry.click();
		Thread.sleep(1000);		
		registerFirstOptionCountry.click();		
		selectCountry();	
		selectBirthDate();
		Thread.sleep(500);
		registerPassword.sendKeys("Senha01");
		registerConfirmPassword.sendKeys("Senha01");
		selectLanguages();
		Thread.sleep(1500);
		registerSubmit.click();
	}
	
	public void deleteOldRecord() throws InterruptedException {
		Actions action = new Actions(driver);
		List<WebElement> btnTrash = driver.findElements(By.xpath("//del-click/button[1]"));
		action.contextClick(btnTrash.get(1)).build().perform();
		Thread.sleep(1000);
		List<WebElement> btnDel = driver.findElements(By.xpath("//ul/li/button[text()='Delete']"));
		btnDel.get(1).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	
	public void menuPracticeSiteNavigation() {
		menuPraticeSite.click();
	}
}
