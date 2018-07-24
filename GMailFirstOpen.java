package NonRefined;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GMailFirstOpen {

	@BeforeTest
    public void OpenGmailApp() throws InterruptedException, IOException
    {		
		//AppiumDriverLocalService service = null;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My device");
		
		cap.setCapability("appPackage", "com.google.android.gm");
		cap.setCapability("appActivity", "com.google.android.gm/com.google.android.gm.ConversationListActivityGmail");		
		cap.setCapability("noReset", "true");
		//GMail activities: com.google.android.gm/com.google.android.gm.welcome.WelcomeTourActivity
		//com.google.android.gm/com.google.android.gm.ConversationListActivityGmail
		//com.google.android.gm/com.google.android.gm.welcome.SetupAddressesActivity
		//cap.setCapability("fullReset", "true");
		//cap.setCapability("fastReset", "true");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		//driver.findElementById("com.google.android.gm:id/setup_addresses_add_another").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Google']").click();
		Thread.sleep(5000);

    }
	
	@Test
	public void OpeningMail()
	{
		
	}
	
}
