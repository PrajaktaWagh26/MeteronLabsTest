package meteronlabs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTranslate {

	private WebDriver _driver;
	WebDriverWait _wait;
	public GoogleTranslate(WebDriver driver) {
		_driver = driver;
		_wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void SetSourceText() {
		SetSourceLanguage();
		GetSourceTextBox().sendKeys("Test");
	}
	
	public String TranslateText() {
		SetSourceText();
		SetTargetLanguage();
		return GetTargetTranslationTextElement().getText();
	}
	
	public void SetTargetLanguage() {
		GetTargetExpandArrow().click();
		GetTargetLanguage().click();
	}
	
	private void SetSourceLanguage() {
		GetSourceExpandArrow().click();
		GetSourceLanguage().click();
	}
	
	private WebElement GetSourceExpandArrow() {
		return _driver.findElement(By.cssSelector("button[aria-label='More source languages']"));
	}
	
	private WebElement GetSourceLanguagesPane() {
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dykxn MeCBDd j33Gae'][1]")));
		return _driver.findElement(By.xpath("//div[@class='dykxn MeCBDd j33Gae'][1]"));
	}
	
	private WebElement GetSourceLanguage() {
		return GetSourceLanguagesPane().findElement(By.cssSelector("div[data-language-code='en']"));
	}
	
	private WebElement GetSourceTextBox() {
		return _driver.findElement(By.cssSelector("textarea[aria-label='Source text']"));
	}
	
	private WebElement GetTargetExpandArrow() {
		return _driver.findElement(By.cssSelector("button[aria-label='More target languages']"));
	}
	
	private WebElement GetTargetLanguagesPane() {
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='dykxn MeCBDd j33Gae'])[2]")));
		return _driver.findElement(By.xpath("(//div[@class='dykxn MeCBDd j33Gae'])[2]"));
	}
	
	private WebElement GetTargetLanguage() {
		return GetTargetLanguagesPane().findElement(By.cssSelector("div[data-language-code='hi']"));
	}
	
	private WebElement GetTargetTranslationTextElement() {
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[lang='hi']")));
		return _driver.findElement(By.cssSelector("span[lang='hi']"));
	}
	
}

