package com.flipkarttask.pagemanager;

import com.flipkarttask.pages.AddToCart;
import com.flipkarttask.pages.LoginPage;

public class PageObjectManager {
	private LoginPage loginPage;
	private AddToCart addToCart;
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage=new LoginPage():loginPage;
	}
	public AddToCart getAddToCart() {
		return (addToCart==null)? addToCart=new AddToCart():addToCart;
	}
	
}
