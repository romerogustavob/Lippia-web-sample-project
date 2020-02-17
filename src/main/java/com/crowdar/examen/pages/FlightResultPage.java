package com.crowdar.examen.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightResultPage extends PageBasePhptravels {

	private final String titulo="Flights Results - From to MIA to AER";
	public FlightResultPage(RemoteWebDriver driver) {
		super(driver);
		this.url="";
		// TODO Auto-generated constructor stub
	}
	
	public WebElement labelListFlights() {
		if (driver.getPageSource().contentEquals("0 Total listings found")) {
			return driver.findElementByXPath("//p[@class='text-muted post-heading']");
		}
		else {
			return null;
		}
	}
	
	public WebElement buttonBookNowFirstElement() {
		return getWebElement(
				By.xpath("//li[1]//div[1]//div[1]//div[2]//form[1]//div[2]//div[1]//button[1]"));
	}
	
	public void flightListVerifyExist() {
		if(labelListFlights()==null) {
			System.out.println("Chequear Vuelos");
			//I´ve supposed. The user will take the first Flight
			buttonBookNowFirstElement().click();
		}
		else {
			System.out.println("No Existen Vuelos");
			
		}
	}
	
	public void verificarTitulo() {
		Assert.assertEquals(this.driver.getTitle(), titulo);
	}
}
