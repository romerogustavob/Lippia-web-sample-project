package com.crowdar.examen.pages;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage extends PageBasePhptravels{

	public BookingPage(RemoteWebDriver driver) {
		super(driver);
		this.url="";
		// TODO Auto-generated constructor stub
	}
	
	private WebElement emailUser() {
		return getWebElement(By.xpath("//input[@id='username']"));
	}
	
	private WebElement emailPassword() {
		return getWebElement(By.xpath("//form[1]/div[2]/div[1]/input[1]"));	
	}
	
	private WebElement titleSelect() {
		return getWebElement(By.xpath("//select[@id='title']"));
	}
	
	private WebElement nameUser() {
		return getWebElement(By.xpath("//input[@id='name']"));
	}
	
	private WebElement surnameUser() {
		return getWebElement(By.xpath("//input[@id='surname']"));
	}
	
	private WebElement mail() {
		return getWebElement(By.xpath("//input[@id='email']"));
	}
	
	private WebElement phoneUser() {
		return getWebElement(By.xpath("//input[@id='phone']"));
	}
	
	private WebElement birthdayUser() {
		return getWebElement(By.xpath("//input[@id='birthday']"));
	}
	
	private WebElement passportNo() {
		return getWebElement(By.xpath("//input[@id='cardno']"));
	}
	
	private WebElement expirationDate() {
		return getWebElement(By.xpath("//input[@id='expiration']"));
	}
//-------------
	private WebElement nationalitySelect() {
		return getWebElement(By.xpath("//a[@class='select2-choice']"));
	}
	
	private WebElement nationalityInput() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[@class='select2-input select2-focused']")));
	}
	
	private WebElement nationalityUl() {
		return getWebElement(By.xpath("//ul[@class='select2-results']"));
	}
	
	private WebElement nationalityDiv(int i) {
		return getWebElement(By.cssSelector("#select2-drop > ul > li:nth-child("+i+") > div"));
	}
	
	private WebElement nationalitySpan(int i) {
		return getWebElement(By.cssSelector("#select2-drop > ul > li:nth-child("+i+") > div > span"));
	}
//-------------
	private WebElement cardTypeSelect() {
		return getWebElement(By.xpath("//select[@id='cardtype']"));
	}
	
	private WebElement cardNumber() {
		return getWebElement(By.xpath("//input[@id='card-number']"));
	}
	
	private WebElement expiredMonthSelect() {
		return getWebElement(By.xpath("//select[@id='expiry-month']"));
	}
	
	private WebElement expiredYearSelect() {
		return getWebElement(By.xpath("//select[@id='expiry-year']"));
	}
	
	private WebElement cvvCard() {
		return getWebElement(By.xpath("//input[@id='cvv']"));
	}
	
	private WebElement acceptConditionsCheck() {
		return getWebElement(By.xpath("//div[@class='custom-control custom-checkbox form-group acceptterm']"));
	}
	
	private WebElement completeBookingButton() {
		return getWebElement(By.xpath("//button[@id='confirmBooking']"));
	}
	
	private WebElement cookiesButton() {
		return getWebElement(By.xpath("//button[@class='cc-btn cc-dismiss']"));
	}
	
	public void inputMailUser(String user) {
		emailUser().clear();
		emailUser().sendKeys(user);
	}
	
	public void inputPassUser(String pass) {
		emailPassword().clear();
		emailPassword().sendKeys(pass);
	}
	
	public void selectTitle(String title) throws Exception {
		Select options=new Select(titleSelect());
		options.selectByVisibleText(title);
		Thread.sleep(3000);
	}
	
	public void inputName(String name) {
		nameUser().clear();
		nameUser().sendKeys(name);
	}
	
	public void inputSurname(String surname) {
		surnameUser().clear();
		surnameUser().sendKeys(surname);
	}
	
	public void inputMail(String mail) {
		mail().clear();
		mail().sendKeys(mail);
	}
	
	public void inputPhone(String numberPhone) {
		phoneUser().clear();
		phoneUser().sendKeys(numberPhone);
	}
	
	public void inputBirthday(String birthday) {
		birthdayUser().clear();
		birthdayUser().sendKeys(birthday);
	}
	
	public void inputPassportNo(String passport) {
		passportNo().clear();
		passportNo().sendKeys(passport);
	}
	
	public void inputExpirationDate(String date) {
		expirationDate().clear();
		expirationDate().sendKeys(date);
	}
	
	public void selectNationality(String nationality) {
		nationalitySelect().click();
		nationalityInput().sendKeys(nationality);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int i=1; i<= nationalityUl().findElements(By.tagName("li")).size(); i++ ) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if(nationalityDiv(i).getText().equals(nationality)) {
				nationalitySpan(i).click();
				break;
			}
		}	
	}
	
	public void selectCardType(String card) throws InterruptedException {
		Select options=new Select(cardTypeSelect());
		options.selectByVisibleText(card);
		Thread.sleep(1000);
	}
	
	public void inputCardNumber(String cardnumber) {
		cardNumber().clear();
		cardNumber().sendKeys(cardnumber);
	}
	
	public void selectExpiredMonthCard(String month) throws InterruptedException {
		Select options=new Select(expiredMonthSelect());
		options.selectByVisibleText(month);
		Thread.sleep(1000);
	}
	
	public void selectExpiredYearCard(String year) throws InterruptedException {
		Select options=new Select(expiredYearSelect());
		options.selectByVisibleText(year);
		Thread.sleep(2000);
	}
	
	public void inputCvvCard(String cvv) {
		cvvCard().clear();
		cvvCard().sendKeys(cvv);
	}
	
	public void checkAcceptConditions() throws InterruptedException {
		acceptConditionsCheck().click();
		Thread.sleep(2000);
	}
	
	public void confirmBooking() throws InterruptedException {
		completeBookingButton().submit();
		Thread.sleep(6000);
	}
	
	public void acceptCookies() {
		cookiesButton().click();
	}
}
