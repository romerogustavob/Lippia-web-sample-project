package com.crowdar.examen.pages;

import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageBasePhptravels extends PageBaseWeb {

    public PageBasePhptravels(RemoteWebDriver driver){
        super( driver);
        BASE_URL = "https://www.phptravels.net/";
    }
} 