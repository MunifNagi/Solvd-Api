package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class OpenedVideo extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(className = "tiktok-i8t918-SvgPlayIcon")
    private ExtendedWebElement playButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[3]/div[2]/div[3]")
    private ExtendedWebElement commentSection;

    @FindBy(className = "xgplayer-pause")
    private ExtendedWebElement paused;

    @FindBy(xpath = "//button[contains(text(),'Copy link')]")
    private ExtendedWebElement copyLinkButton;


    public OpenedVideo(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getPlayButton() {
        return playButton;
    }

    public void pauseVideo(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.SPACE).build().perform();
    }

    public ExtendedWebElement getCommentSection() {
        return commentSection;
    }

    public ExtendedWebElement getPaused() {
        return paused;
    }

    public ExtendedWebElement getCopyLinkButton() {
        return copyLinkButton;
    }
}
