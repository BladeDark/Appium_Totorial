import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Gesture {

	@Test
	public void test() throws MalformedURLException {
		
		File appDir = new File("src");   
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		System.out.println(driver.isLocked());//LOcked condition
		System.out.println(driver.getContext());
		List<WebElement> abc=driver.findElements(By.className("android.widget.TextView"));
		
		TouchAction t=new TouchAction(driver);
		t.tap(abc.get(2)).perform();
		//TouchAction t1=new TouchAction(driver).longPress(el);
		
		
		
		//driver.installApp("");
		driver.closeApp();
		
		//driver.currentActivity();
		//driver.context(name)
		//driver.zoom(el);
		
	}

}
