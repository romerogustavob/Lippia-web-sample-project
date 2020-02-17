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

public class FlightPage extends PageBasePhptravels{
	
	private static final String titulo="PHPTRAVELS | Travel Technology Partner";
	private JavascriptExecutor js;
	private WebElement flightOption() {
		return getWebElement(By.linkText("Flights"));
	}
	
	//select tipo búsqueda |First|Business|Economy|
	private WebElement select() {
		return getWebElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[1]/div[2]/div/div/a/span"));
	}
	
	//ahora obtengo el elemento ul que contiene los li de tipo de búsqueda |First|Business|Economy|
	private WebElement ul() {
		return getWebElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[1]/div[2]/div/div/div/ul"));
	}
	
	private WebElement radioOneWay() {
		return getWebElement(By.xpath("//label[contains(text(),'One Way')]"));
	}
	
	//busco el select de viaje origen
	private WebElement selectFlightFrom() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#s2id_location_from > a:nth-child(1) > span:nth-child(1)")));
	}
	
	private WebElement inputFlightFrom() {
		return getWebElement(By.cssSelector("#select2-drop > div:nth-child(1) > input:nth-child(1)"));
	}
	
	//ahora obtengo el elemento ul de vuelo origen que contiene los li
	private WebElement ulFlightFrom() {
		return getWebElement(By.cssSelector("#select2-drop > ul:nth-child(2)"));
	}
	
	private WebElement divLiFlightFrom(int i) {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("li.select2-results-dept-0:nth-child("+i+") > div:nth-child(1)")));
	}
	
	private WebElement spanDivLiFlightFrom(int i) {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("li.select2-results-dept-0:nth-child("+i+") > div:nth-child(1) > span:nth-child(1)")));
	}
	
	public void selectTipoBusqueda(String tipobBusqueda) {	
		//primero hago click para desplegar el dropdown		
		select().click();
		//obtengo los li que contienen las opciones de búsqueda
		List<WebElement> liOptions = ul().findElements(By.tagName("li"));
		//recorro y selecciono el tipo de busqueda
		for (WebElement liOption : liOptions)
		{
		    if (liOption.getText().equals(tipobBusqueda))
		    {
		        liOption.click(); // click la opción deseada
		        break;
		    }
		}
	}

	public void selectFlightFrom(String vuelo, String aeropuerto) throws InterruptedException {			
		selectFlightFrom().click();
		inputFlightFrom().sendKeys(vuelo);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int i=1; i<=ulFlightFrom().findElements(By.tagName("li")).size(); i++ ) {
			if(divLiFlightFrom(i).getText().equals(vuelo+" "+aeropuerto)) {
				spanDivLiFlightFrom(i).click();
				break;
			}
		}
	}
	
	private WebElement selectFlightTo() {
		return getWebElement(By.cssSelector("#s2id_location_to"));
	}
	
	public WebElement inputFlightTo() {
		return getWebElement(By.cssSelector("#select2-drop > div:nth-child(1) > input:nth-child(1)"));
	}
	
	public WebElement ulFlightTo() {
		return getWebElement(By.cssSelector("#select2-drop > ul:nth-child(2)"));
	}
	
	private WebElement divLiFlightTo(int i) {
		return driver.findElement(By.cssSelector(""
				+ "li.select2-results-dept-0:nth-child("+i+") > div:nth-child(1)"));
	}
	
	private WebElement spanDivLiFlightTo(int i) {
		return driver.findElement(By.cssSelector(
				"li.select2-results-dept-0:nth-child("+i+") > div:nth-child(1) > span:nth-child(1)"));
	}
	
	private WebElement inputDateFlightStart() {
		return getWebElement(By.cssSelector("#FlightsDateStart"));
	}
	
	public void selectFlightTo(String vuelo, String aeropuerto) {
		selectFlightTo().click();
		inputFlightTo().sendKeys(vuelo);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int i=1; i<=ulFlightFrom().findElements(By.tagName("li")).size(); i++ ) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if(divLiFlightTo(i).getText().equals(vuelo+" "+aeropuerto)) {
				spanDivLiFlightTo(i).click();
				break;
			}
		}
	}
	
	public void fechaVueloIda() {
		inputDateFlightStart().sendKeys(Keys.ENTER);
		String xpathSelectorDia="//*[@id=\"FlightsDateStart\"]";
		
		driver.findElementByXPath(xpathSelectorDia).click();
	}
	
	private WebElement searchButton() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[4]/button")));
	
	}
	
    public FlightPage(RemoteWebDriver driver) {
    	super(driver);
        this.url = "m-flights"; //here you can define the custom paths For example:"/search" --> www.googe.com/search  
        js = (JavascriptExecutor) driver;
	}
    
    public void verificarTitulo(){
//    	System.out.println("titulo: "+this.driver.getTitle());
        Assert.assertEquals(this.driver.getTitle(), titulo);
    }
    
    public void clickFlightOption() {
    	flightOption().click();
    }
    
    public void clickRadioOneWay() {
    	radioOneWay().click();
    }
    
    public void clickSearchButton() {
    	searchButton().submit();
    }
    
    private WebElement inputFirstDate() {
    	return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[@id='FlightsDateStart']")));

    }
    
    public void firstDate() throws Exception {
    	inputFirstDate().click();
    	Thread.sleep(3000);
    }
    
    //quiero testear el form de vuelo, no el datepicker, mando directo el value
    public void setDateFlightStart(String fecha) {
    	js.executeScript("document.getElementById("
    			+ "'FlightsDateStart').setAttribute('value','"+fecha+"')");
    }
}