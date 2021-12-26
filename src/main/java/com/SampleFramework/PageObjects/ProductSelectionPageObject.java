package com.SampleFramework.PageObjects;

public class ProductSelectionPageObject {
	public static String productCategory_xpath = "//div[@id='block_top_menu']/ul/li/a[@title='var']";
	public static String productImage_xpath = "//a[@class='product_img_link' and @title ='var']";
	public static final String addToCartBtn_xpath = "//a[@title='Add to cart']";
	public static final String SuccessMsg_xpath = "//div[@id='layer_cart']/div/div/h2";
	public static final String proceedtoCheckoutBtn_xpath = "//a[@title='Proceed to checkout']";
}
