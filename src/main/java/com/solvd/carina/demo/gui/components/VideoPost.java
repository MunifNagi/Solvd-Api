package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class VideoPost extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[1]/div/div[1]")
    private ExtendedWebElement video;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[3]/div[1]/div[2]/div[1]/div")
    private OpenedVideo openedVideo;

    public VideoPost(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getVideo() {
        return video;
    }

    public void clickVideo() {
        video.click();
    }


    public OpenedVideo getOpenedVideo() {
        return openedVideo;
    }
}
