package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import static java.time.Duration.ofMillis;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public final class MobileActions extends BaseClass {
	public AndroidDriver androiddriver= (AndroidDriver) getandroidDriver();
	public void click(By by) throws Exception {
		try {
			System.out.println("in click action");
			WebElement element=androiddriver.findElement(by);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("not able to click");
		}
	}
	public String gettext(By by) throws Exception {
		
			WebElement element = androiddriver.findElement(by);
			String text = element.getText();
			return text;
			
	}
	public boolean isDisplayed(By by) {
		WebElement element = androiddriver.findElement(by);
		boolean bool= element.isDisplayed();
		return bool;
	}
	
	public void scrolldown() {
		Dimension size = androiddriver.manage().window().getSize();
		int width = size.width / 2;	
		int startPoint = (int) (size.getHeight() * 0.20);
		int endPoint = (int) (size.getHeight() * 0.80);		
		for(int i=0;i<2;i++) {		
		new TouchAction(androiddriver).press(PointOption.point(width, startPoint)).waitAction(waitOptions(ofMillis(2000)))
		.moveTo(PointOption.point(width, endPoint)).release().perform();	
		}
	}
	public void scrolltoelement(By by){
		androiddriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		WebElement element=androiddriver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)getandroidDriver();
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		System.out.println("Element exist");
	}
	

}
