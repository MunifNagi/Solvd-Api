package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.Header;
import com.solvd.carina.demo.gui.components.LogInContainer;
import com.solvd.carina.demo.gui.components.SideNav;
import com.solvd.carina.demo.gui.components.VideoPost;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div")
    private Header header;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div[2]/div")
    private SideNav sideNav;

    @FindBy(xpath = "//*[@class=\"tiktok-1lh5noh-DivVideoCardContainer e1bh0wg77\"][1]")
    private VideoPost firstVideo;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sideNav.getHomeButton());
    }

    public VideoPost getFirstVideo() {
        return firstVideo;
    }

    public Header getHeader() {
        return header;
    }

    public SideNav getSideNav() {
        return sideNav;
    }

}
