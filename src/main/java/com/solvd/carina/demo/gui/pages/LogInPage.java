package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SignInPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]")
    private Header header;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//*[@id=\"loginContainer\"]/div[1]/form/div[1]/input")
    private ExtendedWebElement emailTextInput;

    @FindBy(xpath = "//*[@id=\"loginContainer\"]/div[1]/form/div[2]/div/input")
    private ExtendedWebElement passwordTextInput;
    @FindBy(xpath = "//*[@id=\"loginContainer\"]/div[1]/form/button")
    private ExtendedWebElement loginBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageURL("/login/phone-or-email/email");
        setUiLoadedMarker(loginBtn);
    }

    public void inputEmail(String email) {
        System.out.println("munif");
        emailTextInput.type(email);

    }

    public void inputPassword(String password) {
        System.out.println("hi");

        passwordTextInput.type(password);
    }

    public void clickLogInButton() {
        loginBtn.click();
    }

    public void logIn(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickLogInButton();
    }
}
