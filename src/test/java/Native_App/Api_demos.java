package Native_App;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;

import java.util.concurrent.TimeUnit;
//static import for time
import static java.time.Duration.ofSeconds;
//Static imports for long press
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//static import for elements
import static io.appium.java_client.touch.offset.ElementOption.element;


public class Api_demos extends APIdemo_Capabilities{
	
	AndroidDriver<AndroidElement> driver ;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(enabled = false)
	public void preferencesettings() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
	//	driver.findElement(MobileBy.xpath("*//[@text="WiFi settings"]")).click();
		//Another way of using text is 
		//If ur using android ui automator to identify an element using an attribute then u can use ui selector method for selecting the attribute
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Subhan5g");
		driver.findElement(MobileBy.id("android:id/button2")).click();
		
		driver.hideKeyboard();
		//if u want to navigate back to the prev screen
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
				
	}

	@Test(enabled = false)
	public void opennotifications() {
		
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
	}
	
	@Test(enabled = false)
	public void scroll() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//If u have to scroll u need 4 things
		//1.ui automator 2.ui selector 3.ui scrollable 4.scrollIntoView
		//If u want to scroll to a particular element then u use scroll into view 
		
		//driver.findElement(MobileBy.AndroidUIAutomator)
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
			
		
	}
	@Test(enabled = false)
	public void Longpress() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Expandable Lists\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"1. Custom Adapter\")")).click();
    	AndroidElement fishnames = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish Names\")"));
    	
    	TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(fishnames)).withDuration(ofSeconds(3))).release().perform();
		
		
	}
	
	@Test(enabled = true)
	public void typeswipe() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Date Widgets\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"2. Inline\")")).click();
		
		 AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));
		 AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("7"));
		 
		 TouchAction ta = new TouchAction(driver);
		 ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		 
	
	}
	
	@Test(enabled = true)
	public void drag_and_drop() {
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
//		driver.findElement(MobileBy.AccessibilityId("Views")).click();
//		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
//		
//		AndroidElement ele1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
//		AndroidElement ele2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
//		 
//		TouchAction ta = new TouchAction(driver);
//		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		
	
	}
	
	@Test
	public void switchapp() {
		
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		boolean status = driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).isSelected();
		if(status == true)
		{
			System.out.println("Already checked");
		}
		else
		{
			
			driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		}
		driver.hideKeyboard();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650)555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("hmmmmm...!");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_send_message")).click();
		
	//	driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
		driver.activateApp("com.google.android.apps.messaging");
		
		
		String exp = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"You: hmmmmm...!\")")).getText();
		System.out.println(exp);
			
		driver.activateApp("io.appium.android.apis");
		
	}
	
}










