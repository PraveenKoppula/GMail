package GMail;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class StarringMailAfterOpening {

	AndroidDriver<AndroidElement> driver ;	
	List<AndroidElement> listOfStarredMails;
	
	@BeforeTest
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");		//Pixel 2 XL
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");		
		cap.setCapability("noReset", "true");		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(2000);
    }
	
	@Test (priority=0)
	public void CountOfStarredMails() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.LinearLayout//android.widget.TextView[@text='Starred']").click();
		Thread.sleep(2000);
		
		listOfStarredMails = driver.findElementsByXPath("//*//android.view.View//android.view.View[@index=0]");
		System.out.println("Starred emails count: " + listOfStarredMails.size());
		driver.navigate().back();
	}
	
	@Test (priority=1)
	public void SendMail() throws InterruptedException
	{
		driver.findElementById("com.google.android.gm:id/compose_button").click();
		Thread.sleep(2000);
		System.out.println(driver.getContext());
		driver.findElementByXPath("//android.widget.EditText[@resource-id='com.google.android.gm:id/subject']").sendKeys("To check starring a mail");
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/to").sendKeys("chotucrazy435@gmail.com");
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/send").click();	
		Thread.sleep(2000);		
	}
	
	@Test (priority=2)
	public void StarringMail() throws InterruptedException
	{
		driver.findElementByXPath("//*//android.view.View[@index=0]//android.view.View[@index=0]").click();
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/conversation_header_star").click();
		driver.navigate().back();
	}

	
	@Test (priority=3)
	public void StarredMailsList() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.ImageButton").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.LinearLayout//android.widget.TextView[@text='Starred']").click();
		Thread.sleep(2000);
		
		listOfStarredMails = driver.findElementsByXPath("//*//android.view.View//android.view.View[@index=0]");
		System.out.println("Starred emails count: " + listOfStarredMails.size());
		driver.navigate().back();
	}

	/*
	@AfterTest
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	*/
}
