package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LogInContainer extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//*[@id=\"loginContainer\"]/div[1]/form/div[1]/input")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//*[@id=\"loginContainer\"]/div[1]/form/div[2]/div/input")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"loginContainer\"]/div[1]/form/button")
    private ExtendedWebElement loginButton;

    public LogInContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }
}
