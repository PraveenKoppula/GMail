package GMail;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class All {
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
	
	@Test  (priority=1)
	public void OpeningMail() throws InterruptedException
	{
		System.out.println(driver.getContext());
		List<AndroidElement> convList = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView//android.view.View//android.view.View[@index=0]");
		System.out.println("Total count of mails appearing:" + convList.size() );
		
		for(int i=7; i < convList.size() ; i++)
		{
			convList.get(i).click();
			Thread.sleep(2000);
			int j = i+1;
			System.out.println("Mail-"+ j + " title: " + driver.findElement(By.id("com.google.android.gm:id/subject_and_folder_view")).getText());
			driver.navigate().back();
		}
		System.out.println("Done");
		Thread.sleep(3000);
	}
	
	@Test (priority=2)
	public void SendMail() throws InterruptedException
	{
		driver.findElementById("com.google.android.gm:id/compose_button").click();
		Thread.sleep(2000);
		System.out.println(driver.getContext());
		driver.findElementByXPath("//android.widget.EditText[@resource-id='com.google.android.gm:id/subject']").sendKeys("GMail automation: Unable to enter text in mail body... its a webkit element");
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gm:id/to").sendKeys("chotucrazy435@gmail.com");
		Thread.sleep(2000);
		//driver.findElementById("com.google.android.gm:id/wc_body").click();
		driver.findElementById("com.google.android.gm:id/send").click();	
		
		//driver.findElementByXPath("/html/body/div[1]").sendKeys("it worked...coool");
		//driver.findElementById("com.google.android.gm:id/wc_body").sendKeys("Just to inform you i have started GMail automation.");
		//Thread.sleep(2000);
	}
	
	@Test (priority=3)
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
