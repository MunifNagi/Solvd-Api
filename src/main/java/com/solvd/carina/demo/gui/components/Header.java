package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class Header extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private ExtendedWebElement signInButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div")
    private ExtendedWebElement homeLogo;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        setUiLoadedMarker(homeLogo);
        setUiLoadedMarker(signInButton);
    }

    public  ExtendedWebElement getSignInButton() {
        return signInButton;
    }

    public  ExtendedWebElement getHomeLogo() {
        return homeLogo;
    }

}
