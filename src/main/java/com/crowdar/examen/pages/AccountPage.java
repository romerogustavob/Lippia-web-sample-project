package com.crowdar.examen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AccountPage extends PageBasePhptravels{

	public AccountPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private WebElement flightLink() {
		return getWebElement(By.xpath("//a[contains(text(),'Flights')]"));
	}
	
	public void linkToFlight() throws Exception {
		flightLink().click();
		Thread.sleep(2000);
	}
}
