package com.crowdar.examen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PageBasePhptravels{

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
		this.url="login";
//		this.navigateTo(this.url);
		// TODO Auto-generated constructor stub
	}
	
	public void go() throws Exception {
		navigateToCompleteURL();
		Thread.sleep(2000);
	}
	
	private WebElement loginSelect() {
		return getWebElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']"));
	}
	
	private WebElement emailUser() {
		return getWebElement(By.xpath("//div[@class='row']//div[1]//label[1]//input[1]"));
	}
	
	private WebElement passwordUser() {
		return getWebElement(By.xpath("//div[@class='col-md-6 bg-white-shadow pt-25 ph-30 pb-40']//div[2]//label[1]//input[1]"));
	}
	
	private WebElement loginButton() {
	//	return getWebElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']"));
		return getWebElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/button"));
	///html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/button
	}
	
	public void selectLogin(String opcion) throws Exception {
		Select options=new Select(loginSelect());
		options.selectByVisibleText(opcion);
		Thread.sleep(3000);
	}
	
	public void inputEmail(String email) {
		emailUser().clear();
		emailUser().sendKeys(email);
	}
	
	public void inputPassword(String pass) {
		passwordUser().clear();
		passwordUser().sendKeys(pass);
	}
	
	public void loginSubmit() throws Exception {
		loginButton().click();
		Thread.sleep(6000);
	}
	
}
