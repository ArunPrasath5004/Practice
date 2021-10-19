package org.some;

import org.find.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKart_PlaceOrder extends BaseClass{

	public FlipKart_PlaceOrder() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrder;

	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	
	
}
