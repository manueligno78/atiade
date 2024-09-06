package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenshotUtil
{
    public static byte[] takeScreenshot(WebDriver driver)
    { return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); }
}