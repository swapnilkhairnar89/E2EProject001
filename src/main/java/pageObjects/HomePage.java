package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By homePage = By.xpath("//div[@id='root']");
	private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	private By viewCartButton = By.xpath("//img[@alt='Cart']");
	private By productInCart = By.xpath("//p[@class='product-name']");
	private By cartHeaderBlinkingLink = By.xpath("//a[@class='cart-header-navlink blinkingText']");

	public WebElement gethomePage() {
		return driver.findElement(homePage);
	}

	public WebElement getaddToCartButton() {
		return driver.findElement(addToCartButton);
	}

	public WebElement getviewCartButton() {
		return driver.findElement(viewCartButton);
	}

	public WebElement getproductInCart() {
		return driver.findElement(productInCart);
	}

	public WebElement getcartHeaderBlinkingLink() {
		return driver.findElement(cartHeaderBlinkingLink);
	}

}
