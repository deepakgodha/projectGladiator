package onewaytrip;

import java.io.FileInputStream;

import java.util.Properties;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Runner extends Base {
	OneWayTrip book;
  Properties prop=new Properties();
  @Test(priority='a',enabled=false,description="creating a one way trip")
  public void bookingOneWayFlight() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
      book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      fp.sendKeys(Keys.ARROW_DOWN);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	 Thread.sleep(1000);
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  book.selectDropDown("id","titleAdult0",prop.getProperty("title"));
	  Thread.sleep(2000);
	  book.clearData("id","txtFNAdult0");
	  book.sendData("id","txtFNAdult0", prop.getProperty("fname"));
	  book.clearData("id","txtLNAdult0");
	  book.sendData("id","txtLNAdult0", prop.getProperty("lname"));
	  Thread.sleep(1000);
	  book.sendData("id","txtCPhone", prop.getProperty("phnumber"));
	  book.doClick("id", "spnTransaction");
	 String url= driver.getCurrentUrl();
	 Assert.assertEquals(true,url.contains("https://flight.easemytrip.com/Review/CheckOut"));
	 }
  @Test(priority='b',enabled=false,description="source and destination same error")
  public void sameToAndFromLocation()throws Exception {
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place1"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  Thread.sleep(2000);
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  Alert ac= driver.switchTo().alert();
	  String alert=ac.getText();
	  ac.accept();
	  Assert.assertEquals("Source and Destination cannot be same", alert);
	  
  }
  @Test(priority='d',enabled=false,description="select the insurance")
  public void selectInsurance()throws Exception {
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  String error=driver.findElement(By.id("DivInsuAlert")).getText();
	  Assert.assertEquals("NOTE: Please select Yes or No to continue.",error);
  }
  @Test(priority='e',enabled=false,description="enter the title in passengers details")
  public void enterTheTitle() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	 // book.doClick("id","dwnArrAdult0");
	 // Thread.sleep(2000);
	  book.selectDropDown("id", "titleAdult0", prop.getProperty("title0"));
	  book.clearData("id","txtFNAdult0");
	  book.sendData("id","txtFNAdult0", prop.getProperty("fname"));
	  book.clearData("id","txtLNAdult0");
	  book.sendData("id","txtLNAdult0", prop.getProperty("lname"));
	  Thread.sleep(2000);
	// book.doClick("xpath", "//label[@id='mycheckbox']//span[@class='cmark_cbox']");
	  Thread.sleep(1000);
	  book.clearData("id", "txtCPhone");
	  book.sendData("id","txtCPhone", prop.getProperty("phnumber"));
	  book.doClick("id", "spnTransaction");
	  Thread.sleep(2000);
	 String error= driver.findElement(By.id("spanErrorAdult0")).getText();
	 Assert.assertEquals("Adult 1 title is required",error);
	 }
  @Test(priority='f',enabled=false,description="enter the first name in passengers details")
  public void enterTheFirstName() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  book.doClick("id","dwnArrAdult0");
	  Thread.sleep(2000);
	  book.selectDropDown("id","titleAdult0",prop.getProperty("title"));
	  book.clearData("id","txtFNAdult0");
	  book.clearData("id","txtLNAdult0");
	  book.sendData("id","txtLNAdult0", prop.getProperty("lname"));
	  Thread.sleep(2000);
	  book.doClick("xpath", "//label[@id='mycheckbox']//span[@class='cmark_cbox']");
	  book.clearData("id", "txtCPhone");
	  book.sendData("id","txtCPhone", prop.getProperty("phnumber"));
	  book.doClick("id", "spnTransaction");
	  Thread.sleep(2000);
	 String error= driver.findElement(By.id("spanErrorAdult0")).getText();
	 Assert.assertEquals("Adult 1 First Name should have minimum 1",error);
	 }
  @Test(priority='g',enabled=false,description="enter the last name in passengers details")
  public void enterTheLastName() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  book.doClick("id","dwnArrAdult0");
	  Thread.sleep(2000);
	  book.selectDropDown("id","titleAdult0",prop.getProperty("title"));
	  book.clearData("id","txtFNAdult0");
	  book.sendData("id","txtFNAdult0", prop.getProperty("fname"));
	  book.clearData("id","txtLNAdult0");
	  Thread.sleep(2000);
	  book.doClick("xpath", "//label[@id='mycheckbox']//span[@class='cmark_cbox']");
	  book.clearData("id", "txtCPhone");
	  book.sendData("id","txtCPhone", prop.getProperty("phnumber"));
	  book.doClick("id", "spnTransaction");
	  Thread.sleep(2000);
	 String error= driver.findElement(By.id("spanErrorAdult0")).getText();
	 Assert.assertEquals("Adult 1 Last Name should have minimum 1character.",error);
	 }
  @Test(priority='h',enabled=false,description="enter the phone number ")
  public void enterThePhoneNumber() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  book.doClick("xpath", "//label[@id='mycheckbox']//span[@class='cmark_cbox']");
	  book.clearData("id", "txtCPhone");
	  book.doClick("id", "spnTransaction");
	  Thread.sleep(2000);
	 String error= driver.findElement(By.id("spanError")).getText();
	 Assert.assertEquals("Please enter a valid mobile number",error);
	 }
  @Test(priority='p',enabled=false,description="adding passengers")
  public void addPassengers() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css",prop.getProperty("traveller"));
	  book.doClick("xpath", prop.getProperty("addAdult"));
	  book.doClick("xpath", prop.getProperty("addChild"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath", prop.getProperty("businessClass"));
	  book.doClick("css",prop.getProperty("search"));
	  String url=driver.getCurrentUrl();
	  Assert.assertEquals(true, url.contains("https://flight.easemytrip.com/FlightList/Index"));
	  }
  @Test(priority='n',enabled=false,description="adding privilage")
  public void addPrivilage() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath", prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  Thread.sleep(2000);
	  book.doClick("css",prop.getProperty("search"));
	  String url=driver.getCurrentUrl();
	  Assert.assertEquals(true,url.contains("https://flight.easemytrip.com/FlightList"));
  
  }
  @Test(priority='i',enabled=false,description="Adding a coupon")
  public void addCoupon() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  book.doClick("xpath", "//div[@class='cancl']");
	  book.doClick("xpath", "//span[@id='spnRdoEMTNCF']");
	  Thread.sleep(2000);
	  String msg=driver.findElement(By.cssSelector("p#easeFareDetails1_promodiv")).getText();
	  Assert.assertEquals(true,msg.contains("Congratulations!"));
  }
  @Test(priority='l',enabled=false,description="invalid From-location")
  public void invalidFromLocation() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys("nmnmn");
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  Alert ac=driver.switchTo().alert();
	  String error=ac.getText();
	  ac.accept();
	  Assert.assertEquals("Enter valid origin city", error);
  }
  @Test(priority='m',enabled=false,description="invalid To-location")
  public void invalidToLocation() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys("nmnmn");
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	  book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  Alert ac=driver.switchTo().alert();
	  String error=ac.getText();
	  ac.accept();
	  Assert.assertEquals("Enter valid destination city", error);
  
  }
  @Test(priority='k',enabled=false,description="selecting number of stops")
  public void selectTheStops() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("css", "div[class='shw1'] span[class='cmark_cbox']");
	  book.doClick("xpath","//label[normalize-space()='1 Stop']");
	  Thread.sleep(2000);
	  boolean b=book.getElement("xpath", "//label[normalize-space()='1 Stop']").isEnabled();
      Assert.assertEquals(true, b);
      
  }
  @Test(priority='j',enabled=false,description="invalid coupon")
  public void invalidCoupon() throws Exception{
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(prop.getProperty("place1"));
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(prop.getProperty("place2"));
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",prop.getProperty("emailid"));
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  book.doClick("xpath", "//div[@class='cancl']");
	  book.sendData("xpath", "//input[@id='txtCouponCode']", "abc");
	  book.doClick("xpath", "//div[@class='apl']");
	  Thread.sleep(2000);
	  String msg=driver.findElement(By.cssSelector("p#easeFareDetails1_promodiv")).getText();
	  Assert.assertEquals(true,msg.contains("Invalid"));
  }
  @Test(priority='c',enabled=false,dataProvider = "dp",description="enter valid email id")
  public void enterValidEmailId(String from, String to,String email)throws Exception {
	  prop.load(new FileInputStream("oneway.property"));
	  OneWayTrip book=new OneWayTrip(driver);
	  book.getUrl(prop.getProperty("url"));
	  book.doClick("xpath",prop.getProperty("oneway"));
	  book.clearData("xpath",prop.getProperty("fromCity"));
	  Thread.sleep(3000);
	  WebElement fp1= book.getElement("xpath",prop.getProperty("fromCity"));
	  fp1.sendKeys(from);
	  fp1.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);
	  fp1.sendKeys(Keys.ENTER);
	  book.clearData("xpath",prop.getProperty("toCity"));
	  WebElement fp=book.getElement("xpath",prop.getProperty("toCity"));
	  fp.sendKeys(to);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(2000);
      fp.sendKeys(Keys.ENTER);
	 book.doClick("id","ddate");
	  book.doClick("id",prop.getProperty("date"));
	  book.doClick("css","span.optclass-name");
	  book.doClick("xpath",prop.getProperty("businessClass"));
	  book.doClick("xpath", prop.getProperty("privilage"));
	  book.doClick("css",prop.getProperty("search"));
	  Thread.sleep(2000);
	  book.doClick("xpath",prop.getProperty("bookNow"));
	  Thread.sleep(2000);
	  book.doClick("xpath", prop.getProperty("insurance"));
	  book.clearData("id", "txtEmailId");
	  book.sendData("id","txtEmailId",email);
	  book.doClick("id", "spnVerifyEmail");
	  Thread.sleep(2000);
	  String error=driver.findElement(By.xpath("//span[normalize-space()='Please enter a valid email Id']")).getText();
	  Assert.assertEquals("Please enter a valid email Id", error);
	  
  }

  @DataProvider
  public Object[][] dp()throws Exception {
	  Excel ex=new Excel("E://Location.xls");
	  Object data[][]=new Object[ex.getRowNum("Sheet1")][ex.getColNum("Sheet1")];
	  for(int i=0;i<data.length;i++)
	  {
		  data[i][0]=ex.getData("Sheet1", i, 0);
		  data[i][1]=ex.getData("Sheet1", i, 1);
		  data[i][2]=ex.getData("Sheet1", i, 2);	
			
	  }
	  return data;
}
}
