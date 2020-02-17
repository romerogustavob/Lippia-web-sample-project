package com.crowdar.examen.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PhptravelsHomePage extends PageBasePhptravels{

	private WebElement linkToFlightPage() {
		return getWebElement(By.xpath("//a[contains(text(),'Flights')]"));
	}
	
    public PhptravelsHomePage(RemoteWebDriver driver){
        super(driver);
        this.url="home";
        this.go();
    }

    public void go(){
    	navigateToCompleteURL();
    }

    public void toBlog(){
    	this.url="blog";
    	this.go();
    }
    
    public void toFlight() {
    	linkToFlightPage().click();
    }
}