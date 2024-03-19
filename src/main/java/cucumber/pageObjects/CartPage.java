package cucumber.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.AbstractComponents.AbstractComponent;



public class CartPage extends AbstractComponent{

WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
		private List<WebElement> cartProducts;
	 
	public CartPage(WebDriver driver) {
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//PageFactory

	
	
	
	

	public Boolean verifyProductDisplay(String productName) {
		// TODO Auto-generated method stub
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
		
	}

}