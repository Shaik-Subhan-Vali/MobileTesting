package Native_App;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

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

	@Test(enabled = true)
	public void opennotifications() {
		
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
	}
	
}
