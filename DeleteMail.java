package GMail;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DeleteMail {
	AndroidDriver<AndroidElement> driver ;
	
	@BeforeTest
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");	
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");		
		cap.setCapability("noReset", "true");
		//GMail activities: com.google.android.gm/com.google.android.gm.welcome.WelcomeTourActivity
		//com.google.android.gm/com.google.android.gm.ConversationListActivityGmail
		//com.google.android.gm/com.google.android.gm.welcome.SetupAddressesActivity
		//cap.setCapability("fullReset", "true");
		//cap.setCapability("fastReset", "true");		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(2000);
    }
	
	@Test  (priority=1)
	public void OpeningMail() throws InterruptedException
	{
		
		System.out.println("Insideeeeeeeeeeeeee");
		driver.findElementByXPath("//android.view.View[1]").findElementByAndroidUIAutomator("content-desc(\"Select this conversation\")").isDisplayed();
		
	//	AndroidElement elem = driver.findElementByAndroidUIAutomator("content-desc(\"Select this conversation\")");
		
		//WebElement elem = driver.findElementByXPath("//android.view.View[1]");
	//	System.out.println("elem text   : " + elem.getText());
		
		TouchAction ta= new TouchAction(driver);
		//ta.tap(p)
	//	driver.findElement)
		
	//	List<AndroidElement> list = driver.findElementsByXPath("//*//android.view.View//android.view.View[1]");
		//list.get(0).click();
		driver.findElementById("com.google.android.gm:id/delete").click();
	}
	
	@AfterTest
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
