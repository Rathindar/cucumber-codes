package com.flipkarttask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AddToCart extends BaseClass {
	public AddToCart() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//form[@class='_2rslOn header-form-search']")
	private WebElement txtsearchbox;
		@FindBy(xpath="//button[@class='QqFHMw vslbG+ In9uk2']")
	private WebElement btnaddtocart;
	@FindBy(xpath="//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")
	private WebElement btnplaceorder;
	@FindBy(xpath="//div[@class='_2vQwZw']")
	private WebElement btnaddaddres;
	@FindBy(xpath="//input[@class='v2VFa- z2D4XG'][1]")
	private WebElement textname;
	@FindBy(xpath="//input[@class='v2VFa- z2D4XG'][2]")
	private WebElement txtmobileno;
	@FindBy(xpath="//input[@class='v2VFa- z2D4XG'][3]")
	private WebElement txtpincode;
	@FindBy(xpath="//input[@class='v2VFa- z2D4XG'][4]")
	private WebElement txtlocality;
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement txtaddress;
	@FindBy(xpath="//input[@class='v2VFa- z2D4XG'][5]")
	private WebElement txtcity;
	@FindBy(xpath="//select[@name='state']")
	private WebElement ddnstate;
	@FindBy(xpath="//span[text()='Home (All day delivery)']")
	private WebElement btnhomeaddres;
	@FindBy(xpath="//button[@class='QqFHMw SUn3yL _7Pd1Fp']")
	private WebElement btnsaveanddelever;
	@FindBy(xpath="//input[@class='HFxIVK']")
	private WebElement textemail;
	@FindBy(xpath="//button[@class='QqFHMw SUn3yL _7Pd1Fp']")
	private WebElement btncontinuetopayment;
	@FindBy(xpath="//img[@class='W5mR4e']")
	private WebElement imgflipkart;
	public WebElement getBtnaddtocart() {
		return btnaddtocart;
	}
	public WebElement getBtnplaceorder() {
		return btnplaceorder;
	}
	public WebElement getBtnaddaddres() {
		return btnaddaddres;
	}
	public WebElement getTextname() {
		return textname;
	}
	public WebElement getTxtmobileno() {
		return txtmobileno;
	}
	public WebElement getTxtpincode() {
		return txtpincode;
	}
	public WebElement getTxtlocality() {
		return txtlocality;
	}
	public WebElement getTxtaddress() {
		return txtaddress;
	}
	public WebElement getTxtcity() {
		return txtcity;
	}
	public WebElement getDdnstate() {
		return ddnstate;
	}
	public WebElement getBtnhomeaddres() {
		return btnhomeaddres;
	}
	public WebElement getBtnsaveanddelever() {
		return btnsaveanddelever;
	}
	public WebElement getTextemail() {
		return textemail;
	}
	public WebElement getBtncontinuetopayment() {
		return btncontinuetopayment;
	}
	public WebElement getImgflipkart() {
		return imgflipkart;
	}
	
	
	
	


}
