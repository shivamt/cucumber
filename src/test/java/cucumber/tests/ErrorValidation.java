package cucumber.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.pageObjects.CartPage;
import cucumber.testComponents.BaseTest;
import cucumber.pageObjects.ProductCatalogue;



public class ErrorValidation extends BaseTest{
	
	
	@Test
	public void LoginErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";
		landingPage.loginApplication("anshika@gmail.com", "Iamkg@000");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	@Test
	public void productErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 3a");
		Assert.assertFalse (match);
	
	}

}


