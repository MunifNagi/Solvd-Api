package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.OpenedVideo;
import com.solvd.carina.demo.gui.components.VideoPost;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.LogInPage;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class WebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeClass()
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Configuration.getEnvArg("webDriverPath"));
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open");
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void openVideo() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open");
        VideoPost video = homePage.getFirstVideo();
        video.clickVideo();
        OpenedVideo openedVideo = video.getOpenedVideo();
        Assert.assertTrue(openedVideo.verifyCommentSectionExist(), "Video Wasn't opened, no comment section was present");
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void pauseVideo() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open");
        VideoPost video = homePage.getFirstVideo();
        video.clickVideo();
        OpenedVideo openedVideo = video.getOpenedVideo();
        Assert.assertTrue(openedVideo.verifyCommentSectionExist());
        openedVideo.pauseVideo(driver);
        Assert.assertTrue(openedVideo.verifyPlayButtonExist(), "play button is not visible and video wasn't paused");
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void shareVideo() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open as expected");
        VideoPost video = homePage.getFirstVideo();
        video.clickVideo();
        OpenedVideo openedVideo = video.getOpenedVideo();
        openedVideo.clickCopyLinkButton();
        LOGGER.info(getClipboard());
        Assert.assertTrue(getClipboard().startsWith("https://www.tiktok.com/@"), " The video link is not in the clipboard as expected");
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void testLogin() {

        WebDriver driver = getDriver();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Login page is not open as expected");
        logInPage.logIn(Configuration.getEnvArg("webEmail"), Configuration.getEnvArg("webPassword"));
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not loaded after the login process");
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void testFailedLogIn() {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Login page is not open as expected");
        logInPage.logIn("fakeEmail@gmail.com", "WrongPassword!");
        Assert.assertTrue(logInPage.isPageOpened(), "Login page should be opened since login must fail");
    }

    public String getClipboard() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String actualCopedText = null;
        try {
            actualCopedText = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            LOGGER.error("Nothing was copied to Clipboard", e);
            return "";
        } catch (IOException io) {
            LOGGER.error("Nothing was copied to Clipboard", io);
            return "";
        }
        return actualCopedText;
    }
}
