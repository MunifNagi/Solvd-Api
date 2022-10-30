package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class SideMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"mount_0_0_ec\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div/a/div")
    private ExtendedWebElement homeButton;

    public SideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        setUiLoadedMarker(homeButton);
    }

    public  ExtendedWebElement getHomeButton() {
        return homeButton;
    }

}
