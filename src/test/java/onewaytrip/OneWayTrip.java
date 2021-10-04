package onewaytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OneWayTrip {
	WebDriver driver;
	public OneWayTrip(WebDriver driver)
	{
		this.driver=driver;
	}
	public void getUrl(String url)
	{
		driver.get(url);
	}
	public void doClick(String ltype,String lvalue)
	{
		getElement(ltype,lvalue).click();
	}
	public void sendData(String ltype,String lvalue,String data)
	{
		
		getElement(ltype,lvalue).sendKeys(data);
	}
	
	public void selectDropDown(String ltype,String lvalue,String data)
	{
		
		Select s1=new Select(getElement(ltype,lvalue));
		s1.selectByVisibleText(data);
	}
	public void clearData(String ltype,String lvalue)
	{
		getElement(ltype,lvalue).clear();
	}
	public String doCheck(String ltype,String lvalue)
	{
		String s=getElement(ltype,lvalue).getText();
		return s;
	}
	public WebElement getElement(String ltype,String lvalue)
	{
		WebElement fp=null;
		if(ltype.equals("id"))
		{
			fp=driver.findElement(By.id(lvalue));
			
		}
		else if(ltype.equals("name"))
		{
			fp=driver.findElement(By.name(lvalue));
				
		}
		else if(ltype.equals("text"))
		{
			fp=driver.findElement(By.linkText(lvalue));
			
		}
		else if(ltype.equals("css"))
		{
			fp=driver.findElement(By.cssSelector(lvalue));
					
		}
		else if(ltype.equals("xpath"))
		{
			fp=driver.findElement(By.xpath(lvalue));
			
		}
		else
		{
			System.out.println("invalid ltype");
		}
		return fp;
		
	}

}
