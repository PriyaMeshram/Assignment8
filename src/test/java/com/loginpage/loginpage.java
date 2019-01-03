package com.loginpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.config.config;
import com.launch.launch;

public class loginpage {

	@FindBy(how=How.LINK_TEXT,using="MY ACCOUNT")
    WebElement myaccount;
	public void click_on_myaccount() {
		myaccount.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='login[username]']")
	WebElement mailid;

	public void enter_mail_forlogin() {
		mailid.sendKeys("meshrampriya11@gmail.com");
	}

	@FindBy(how = How.XPATH, using = "//input[@name='login[password]']")
	WebElement password;

	public void enter_password_forlogin() {
		password.sendKeys("priya@123");
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Login']")
	WebElement clicklogin;

	public void click_login() {
		clicklogin.click();
	}

	@FindBy(how=How.LINK_TEXT,using="REORDER")
	WebElement reorder;
	public void click_reorder() {
		reorder.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='cart[88638][qty]']")
	WebElement quantity;
	public void enter_quantity() throws Exception {
		Thread.sleep(2000);
		quantity.clear();
		quantity.sendKeys("10");
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Update']")
	WebElement update;

	public void click_update() {
		update.click();
	}

	public void verify_cost() {
		String acutal = config.driver.findElement(By.xpath("//div[@class='cart-totals']/table/tfoot/tr/td[2]/strong/span")).getText();
		String expected = "$6,150.00";
		Assert.assertEquals(acutal, expected);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Proceed to Checkout']")
	WebElement clickprocced;

	public void click_to_proceed() throws Exception {
		Thread.sleep(2000);
		clickprocced.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@id='checkout-step-billing']/form/div/div/button")
	WebElement clickbillinginfo;

	public void click_billingifo_countinue() throws Exception {
		
		clickbillinginfo.click();
		Thread.sleep(2000);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='shipping-method-buttons-container']/button/span/span")
	WebElement clickshippinginfo;

	public void click_shippinginfo_countinue() throws Exception {
		Thread.sleep(2000);
		clickshippinginfo.click();
	}

	@FindBy(how=How.XPATH,using="//input[@value='checkmo']")
	WebElement clickmoney;
	
	public void payment_info() throws Exception {
		Thread.sleep(2000);
		clickmoney.click();
		config.driver.findElement(By.xpath("//div[@id='payment-buttons-container']//button/span/span")).click();
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Place Order']")
	WebElement clickplaceorder;

	public void click_placeorder() throws Exception {
		Thread.sleep(2000);
		clickplaceorder.click();
	}

	public void varify_order_place() {
		String text = config.driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		System.out.println(text);
	}
	
	public void page_load() {
		PageFactory.initElements(config.driver, this);
	}

	public static void main(String[] args) throws Exception {

		launch l = new launch();
		l.open_browser();
		l.enter_application_url();
		l.wait_till_pageload();
		l.maximize_webpage();

		loginpage lp = new loginpage();
		lp.page_load();
		lp.click_on_myaccount();
		lp.enter_mail_forlogin();
		lp.enter_password_forlogin();
		lp.click_login();
		lp.click_reorder();
		lp.enter_quantity();
		lp.click_update();
		lp.verify_cost();
		lp.click_to_proceed();
		lp.click_billingifo_countinue();
		lp.click_shippinginfo_countinue();
		lp.payment_info();
		lp.click_placeorder();
		lp.varify_order_place();

	}

}
