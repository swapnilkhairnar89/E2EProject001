package projectSauceDemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import resources.base;

public class ValidateHomePageFunctionalitiesTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void validateAddToCart(String productName) {

		HomePage homePage = new HomePage(driver);
		log.info("Home Page is displayed");
		homePage.getaddToCartButton().click();
		log.info("First Add To Cart Button is clicked");
		homePage.getviewCartButton().click();
		log.info("View Cart Button is clicked");
		Assert.assertEquals(productName, homePage.getproductInCart().getText());
		log.info("Successfully validated Product Name: " + productName + " in cart");
		homePage.gethomePage().click();
		log.info("Back to Home Page");
	}

	@Test
	public void validateCartHeaderBlinkingLink() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getcartHeaderBlinkingLink().isDisplayed());
		Assert.assertTrue(homePage.getcartHeaderBlinkingLink().isEnabled());
		Assert.assertEquals("Free Access to InterviewQues/ResumeAssistance/Material",
				homePage.getcartHeaderBlinkingLink().getText());
	}

	@DataProvider
	public Object[] getData() {
		Object[] data = new Object[1];
		data[0] = "Brocolli - 1 Kg";
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
