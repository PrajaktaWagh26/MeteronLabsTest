package meteronlabstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import meteronlabs.GoogleTranslate;

import org.junit.Assert; 

public class GoogleTranslateTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://translate.google.co.in/");
		GoogleTranslate googleTransLate = new GoogleTranslate(driver);
		String translatedText = googleTransLate.TranslateText();
		Assert.assertEquals("Given transaltion is incorrect.","परीक्षण", translatedText);
		driver.quit();
	}
}
