package com.flipkarttask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;


public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//span[text()='Login']")
private WebElement textlogin;

@FindBy(xpath="//input[@class='r4vIwl BV+Dqf']")
private WebElement txtphonenumber;

@FindBy(xpath="(//a[@class='_1TOQfO'])[1]//span")
private WebElement textsucessmsg;

@FindBy(xpath="//input[@class='Pke_EE']")
private WebElement txtsearchproduct;

@FindBy(xpath="(//div[@class='_1sdMkc LFEi7Z'])[10]")
private WebElement imgproduct;

@FindBy(xpath="(//div[@class='_3pKU-e'])[9]")
private WebElement btnlogout;

public WebElement getBtnlogout() {
	return btnlogout;
}

public WebElement getImgproduct() {
	return imgproduct;
}

public WebElement getTextsucessmsg() {
	return textsucessmsg;
}

public WebElement getTxtsearchproduct() {
	return txtsearchproduct;
}
public WebElement getTextlogin() {
	return textlogin;
}
public WebElement getTxtphonenumber() {
	return txtphonenumber;
}

public void clicklogin() {
elementClick(textlogin);
	
}
public void enterphoneno(String Phone) {
elementSendKeysEnter(txtphonenumber, Phone);
}

public String loginsucessmsg() {
String elementGetText = elementGetText(textsucessmsg);
return elementGetText;
}

public void logout() {
	Actions actions = new Actions(driver);
	actions.moveToElement(textsucessmsg).click();
	actions.moveToElement(btnlogout).click();
}


}
