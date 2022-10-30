package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.Header;
import com.solvd.carina.demo.gui.components.LogInContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LogInPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"loginContainer\"]")
    private LogInContainer logInContainer;

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageURL("/login/phone-or-email/email");
        setUiLoadedMarker(logInContainer.getLoginButton());
    }

    public void logIn(String email, String password) {
        logInContainer.getEmailInput().type(email);
        logInContainer.getPasswordInput().type(password);
        logInContainer.getLoginButton().click();
    }
}
