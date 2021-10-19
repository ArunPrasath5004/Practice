package org.some;

import org.find.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main_FlipKart extends BaseClass {
	
	@BeforeClass
	private void before() {
		browserLaunch("chrome");
		get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		timeWait(5);
	}
	
	@Test
	private void test() {
		FlipKart_Search sh=new FlipKart_Search();
		clickBtn(sh.getPopUp());
		timeWait(3);
		sendValues(sh.getSearchBox(), "mobiles");
		clickBtn(sh.getSearch());
		
		timeWait(5);
		Flipkart_Mobiles mb=new Flipkart_Mobiles();
		clickBtn(mb.getallMoblies().get(0));
		windowHandle(0);
		clickBtn(mb.getallMoblies().get(4));
		windowHandle(2);
		timeWait(5);

		FlipKart_AddToCart ad=new FlipKart_AddToCart();
		clickBtn(ad.getAddToCart());
		
		FlipKart_PlaceOrder pl=new FlipKart_PlaceOrder();
		timeWait(3);
		clickBtn(pl.getPlaceOrder());
		
		
	}

}
