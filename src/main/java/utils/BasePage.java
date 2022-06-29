package utils;

import pages.*;

public class BasePage extends BaseTest {
	
	
	public NavMenuPage navMenu =  new NavMenuPage(driver);
	public LoginPage loginPage =  new LoginPage(driver);
	public PostFormatsPage postFormatsPage = new PostFormatsPage(driver);
	public ContactsPage contactsPage = new ContactsPage(driver);
	public ShopPage shopPage = new ShopPage(driver);

	public SeleniumWrappers se = new SeleniumWrappers(driver);
	

}
