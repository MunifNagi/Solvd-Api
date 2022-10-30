package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.OpenedVideo;
import com.solvd.carina.demo.gui.components.VideoPost;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
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
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open");
        driver.close();
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void openVideo() {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open");
        VideoPost video = homePage.getFirstVideo();
        video.clickVideo();
        OpenedVideo openedVideo = video.getOpenedVideo();
        Assert.assertTrue(openedVideo.getCommentSection().isElementPresent(), "Video Wasn't opened, no comment section was present");
        driver.close();
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void pauseVideo() {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open");
        VideoPost video = homePage.getFirstVideo();
        video.clickVideo();
        OpenedVideo openedVideo = video.getOpenedVideo();
        openedVideo.getCommentSection().assertElementPresent();
        openedVideo.pauseVideo(driver);
        Assert.assertTrue(openedVideo.getPlayButton().isElementPresent(), "play button is not visible and video wasn't paused");
        driver.close();
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void shareVideo() {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not open as expected");
        VideoPost video = homePage.getFirstVideo();
        video.clickVideo();
        OpenedVideo openedVideo = video.getOpenedVideo();
        openedVideo.getCopyLinkButton().assertElementPresent();
        openedVideo.getCopyLinkButton().click();
        LOGGER.info(getClipboard());
        Assert.assertTrue(getClipboard().startsWith("https://www.tiktok.com/@"), " The video link is not in the clipboard as expected");
        driver.close();
    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void testLogin() {

        WebDriver driver = new ChromeDriver();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.open();

        Assert.assertTrue(logInPage.isPageOpened(), "Login page is not open as expected");
        logInPage.logIn(Configuration.getEnvArg("webEmail"), Configuration.getEnvArg("webPassword"));

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not loaded after the login process");
        driver.close();

    }

    @Test()
    @MethodOwner(owner = "munifnagi")
    public void testFailedSignIn() {
        WebDriver driver = new ChromeDriver();
        LogInPage signInPage = new LogInPage(driver);
        signInPage.open();
        Assert.assertTrue(signInPage.isPageOpened(), "Login page is not open as expected");
        signInPage.logIn("fakeEmail@gmail.com", "WrongPassword!");
        Assert.assertTrue(signInPage.isPageOpened(), "Login page should be opened since login must fail");
        driver.close();
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
