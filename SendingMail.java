package GMail;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SendingMail {
	AndroidDriver<AndroidElement> driver ;
	
	@BeforeTest
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");		//Pixel 2 XL
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
	
	@Test
	public void SendMail() throws InterruptedException
	{
		driver.findElementById("com.google.android.gm:id/compose_button").click();
		Thread.sleep(2000);
		System.out.println(driver.getContext());
		System.out.println( "+++++++++" + driver.findElementByXPath("//*[@resource-id='com.google.android.gm:id/composearea_tap_trap_bottom']"));
		driver.findElementById("com.google.android.gm:id/composearea_tap_trap_bottom").click();	
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@resource-id='com.google.android.gm:id/composearea_tap_trap_bottom']").sendKeys("HELLO BODY ");
		Thread.sleep(4000);				
		driver.findElementByXPath("//android.widget.EditText[@resource-id='com.google.android.gm:id/subject']").sendKeys("GMail automation: Unable to enter text in mail body... its a webkit element");
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/to").sendKeys("chotucrazy435@gmail.com");
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/send").click();	
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
