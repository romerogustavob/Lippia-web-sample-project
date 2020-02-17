package com.crowdar.examen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class BlogResultPage extends PageBasePhptravels{
	private String titulo="Blog";
    public BlogResultPage(RemoteWebDriver driver){
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void verificarTitulo(){
        Assert.assertEquals(this.driver.getTitle(), titulo);
    }   
}