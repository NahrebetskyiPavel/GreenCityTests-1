package com.softserve.edu.greencity.ui.tests.signUp;

import com.softserve.edu.greencity.ui.pages.cabinet.ManualRegisterComponent;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterComponent;
import com.softserve.edu.greencity.ui.pages.common.TopGuestComponent;
import com.softserve.edu.greencity.ui.tests.GreenCityTestRunner;
import org.openqa.selenium.Dimension;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CustomScreenResolutionsTests extends GreenCityTestRunner {

    @DataProvider
    public Object[] sizes() {
        Object[] returnArray = new Object[2];
        returnArray[0] = new Dimension(1024, 760);
        returnArray[1] = new Dimension(1440, 1024);
        return returnArray;
    }

    @Test(dataProvider = "sizes", description = "GC-487")
    public void checkSignUpModalBigScreen(Dimension resolution) {
        changeWindowSize(resolution);

        logger.info("Starting checkSignUpModalUI: ");
        loadApplication();

        logger.info("Click on Sign up button");
        RegisterComponent registerComponent = new TopGuestComponent(driver).clickSignUpLink();

        logger.info("Get a title text of the modal window: "
                + registerComponent.getTitleString());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Hello!", registerComponent.getTitleString(),
                "This is not a register modal:(");

        logger.info("Get a subtitle text of the modal window: "
                + registerComponent.getSubtitleString());

        softAssert.assertEquals("Please enter your details to sign up", registerComponent.getSubtitleString(),
                "This is not a register modal:(");

        logger.info("Get a text for registered users: "
                + registerComponent.getSignInLinkText());
        softAssert.assertEquals(registerComponent.getSignInLinkText(), "Do you already have an account? Sign in");

        logger.info("Checking if the rest of the page elements are displayed ");
        softAssert.assertTrue(registerComponent.getRegisterComponentModal().isDisplayed());
        softAssert.assertTrue(registerComponent.getSignInLink().isDisplayed());
        softAssert.assertTrue(registerComponent.getGoogleSignUpButton().isDisplayed());
        softAssert.assertTrue(registerComponent.getModalImage().isDisplayed());
        ManualRegisterComponent manualRegisterComponent = registerComponent.getManualRegisterComponent();
        softAssert.assertTrue(manualRegisterComponent.getSignUpButton().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getEmailField().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getUserNameField().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getPasswordField().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getPasswordConfirmField().isDisplayed());
        softAssert.assertAll();

    }

    @Test(description = "GC-487")
    public void checkSignUpModalSmallScreen() {
        Dimension resolution = new Dimension(768, 1024);
        changeWindowSize(resolution);

        logger.info("Starting imageDisplyedIfResolutionAllows: ");
        loadApplication();

        logger.info("Click on Sign up button");
        RegisterComponent registerComponent = new TopGuestComponent(driver).clickSignUpLink();

        logger.info("Get a title text of the modal window: "
                + registerComponent.getTitleString());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Hello!", registerComponent.getTitleString(),
                "This is not a register modal:(");

        logger.info("Get a subtitle text of the modal window: "
                + registerComponent.getSubtitleString());

        softAssert.assertEquals("Please enter your details to sign up", registerComponent.getSubtitleString(),
                "This is not a register modal:(");

        logger.info("Get a text for registered users: "
                + registerComponent.getSignInLinkText());
        softAssert.assertEquals(registerComponent.getSignInLinkText(), "Do you already have an account? Sign in");

        logger.info("Checking if the rest of the page elements are displayed ");
        softAssert.assertTrue(registerComponent.getRegisterComponentModal().isDisplayed());
        softAssert.assertTrue(registerComponent.getSignInLink().isDisplayed());
        softAssert.assertTrue(registerComponent.getGoogleSignUpButton().isDisplayed());
        softAssert.assertFalse(registerComponent.getModalImage().isDisplayed());
        ManualRegisterComponent manualRegisterComponent = registerComponent.getManualRegisterComponent();
        softAssert.assertTrue(manualRegisterComponent.getSignUpButton().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getEmailField().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getUserNameField().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getPasswordField().isDisplayed());
        softAssert.assertTrue(manualRegisterComponent.getPasswordConfirmField().isDisplayed());
        softAssert.assertAll();

    }
}