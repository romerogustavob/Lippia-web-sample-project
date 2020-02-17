package com.crowdar.examen.steps;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examen.pages.*;
import com.crowdar.examples.pages.GoogleHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class PhptravelsSteps extends PageSteps {

    @Given("The user is in home page")
    public void home(){
    	Injector._page(PhptravelsHomePage.class).go();
    }
    
    @When("The user go to Blog page")
    public void goToBlog(){
    	Injector._page(PhptravelsHomePage.class).toBlog();
    }

    @Then("The Blog page is displayed")
    public void tituloVerification(){
       Injector._page(BlogResultPage.class).verificarTitulo();
    }
    
    @Given("The user is in flight page")
    public void goFlightPage() {
    	Injector._page(PhptravelsHomePage.class).toFlight();
    }
    
    @When("The user search a flight")
    public void searchFlight() throws Exception{
    	Injector._page(FlightPage.class).clickRadioOneWay();
    	Injector._page(FlightPage.class).selectTipoBusqueda("First");
    	Injector._page(FlightPage.class).selectFlightFrom("Miami", "(MIA)");
    	Injector._page(FlightPage.class).selectFlightTo("Adler Sochi", "(AER)");
    	//Injector._page(FlightPage.class).firstDate();
    	Injector._page(FlightPage.class).setDateFlightStart("2020-02-18");
    	Injector._page(FlightPage.class).clickSearchButton();
    }
    
    @Then("The page search a list of flights")
    public void verificarLista() throws Exception {
    	Injector._page(FlightResultPage.class).verificarTitulo();
    }
    
    @When("The user complete a flight form")
    public void completeFields() throws Exception {
    	Injector._page(LoginPage.class).go();
    	Injector._page(LoginPage.class).inputEmail("romero_gustavob@yahoo.com.ar");
    	Injector._page(LoginPage.class).inputPassword("zeroone");
    	Injector._page(LoginPage.class).loginSubmit();
    	Injector._page(AccountPage.class).linkToFlight();
    	Injector._page(FlightPage.class).clickRadioOneWay();
    	Injector._page(FlightPage.class).selectTipoBusqueda("First");
    	Injector._page(FlightPage.class).selectFlightFrom("Miami", "(MIA)");
    	Injector._page(FlightPage.class).selectFlightTo("Adler Sochi", "(AER)");
    	Injector._page(FlightPage.class).setDateFlightStart("2020-02-18");
    	Injector._page(FlightPage.class).clickSearchButton();
    	Injector._page(FlightResultPage.class).flightListVerifyExist();
    	Injector._page(BookingPage.class).acceptCookies();
//    	Injector._page(BookingPage.class).inputMailUser("romero_gustavob@yahoo.com.ar");
//    	Injector._page(BookingPage.class).inputPassUser("zeroone");
    	Injector._page(BookingPage.class).selectTitle("Mrs.");
    	Injector._page(BookingPage.class).inputName("Gustavo");
    	Injector._page(BookingPage.class).inputSurname("Romero");
    	Injector._page(BookingPage.class).inputMail("romero_gustavob@yahoo.com.ar");
    	Injector._page(BookingPage.class).inputPhone("3624282828");
    	Injector._page(BookingPage.class).inputBirthday("1890-01-01");
    	Injector._page(BookingPage.class).inputPassportNo("AAB899234");
    	Injector._page(BookingPage.class).inputExpirationDate("2020-12-30");
    	Injector._page(BookingPage.class).selectNationality("ARGENTINA");
    	Injector._page(BookingPage.class).selectCardType("Visa");
    	Injector._page(BookingPage.class).inputCardNumber("4509953566233704");
    	Injector._page(BookingPage.class).selectExpiredMonthCard("Aug (08)");
    	Injector._page(BookingPage.class).selectExpiredYearCard("2021");
    	Injector._page(BookingPage.class).inputCvvCard("134");
    	Injector._page(BookingPage.class).checkAcceptConditions();
    }
    
    @Then("The form flight fields are completed")
    public void fieldsCompleated() throws Exception {
    	Injector._page(BookingPage.class).confirmBooking();
    }
}