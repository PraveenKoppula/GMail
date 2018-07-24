package GMail;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class SearchingMail {

	AndroidDriver<AndroidElement> driver ;	
	
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
	
	@Test
	public void SearchAMail() throws InterruptedException
	{
		driver.findElementById("com.google.android.gm:id/search").click();
		Thread.sleep(2000);
		if(driver.isKeyboardShown())
		{
			System.out.println("Keyboard displayed");
		}
		driver.findElementById("com.google.android.gm:id/search_actionbar_query_text").sendKeys("Google Lens");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();	
	}
	
}
