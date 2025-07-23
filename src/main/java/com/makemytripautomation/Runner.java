package com.makemytripautomation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.makemytrip.com/");

		clickCloseOnModal(wait);
		clickForCity(wait);
		enterTextInFromTextBox(wait, "Cheannai");

		// =============================================//

		By suggestionsLocator = By.xpath("//p[contains(text(),'SUGGESTIONS')]/../following-sibling::ul/li");
		Boolean state = wait
				.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionsLocator),
						ExpectedConditions.numberOfElementsToBeMoreThan(suggestionsLocator, 5)));
		List<WebElement> suggestionList = null;

		if (state) {
			suggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionsLocator));
		}

		for (WebElement suggestion : suggestionList) {
			System.out.println(suggestion.getText());
		}

		suggestionList.get(0).click();

		// =============================================//

		By toCityLabelLocator = By.xpath("//label[@for=\"toCity\"]");
		WebElement toCityLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(toCityLabelLocator));
		toCityLabel.click();

		By toCityInputTextboxLocator = By.xpath("//input[@placeholder='To']");
		WebElement forCityInputTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(toCityInputTextboxLocator));
		forCityInputTextBox.sendKeys("Mumbai");

		By toSuggestionsLocator = By.xpath("//p[contains(text(),'SUGGESTIONS')]/../following-sibling::ul/li");

		state = wait
				.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionsLocator),
						ExpectedConditions.numberOfElementsToBeMoreThan(toSuggestionsLocator, 5)));
		List<WebElement> toSuggestionList = null;

		if (state) {
			toSuggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toSuggestionsLocator));
		}

		for (WebElement suggestion : toSuggestionList) {
			System.out.println(suggestion.getText());
		}

		toSuggestionList.get(0).click();

		// =============================================//

		LocalDate targetDate = LocalDate.now();
		targetDate = targetDate.plusDays(3);
		int dayOfMonth = targetDate.getDayOfMonth();

		String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int targetYear = targetDate.getYear();

		By calendarMonthLocator = By.xpath(
				"//div[text()='" + targetMonth + " " + targetYear + "']//ancestor::div[@class='DayPicker-Month']");
		WebElement calendarMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarMonthLocator));
		By dateLocator = By.xpath(".//p[text()='" + dayOfMonth + "']//ancestor::div[contains(@class,'DayPicker-Day')]");
		
		WebElement date = calendarMonth.findElement(dateLocator);
		date.click();
		
		driver.close();
		driver.quit();

	}

	private static void clickCloseOnModal(WebDriverWait wait) {
		By closeModallocator = By.xpath("//span[@data-cy=\"closeModal\"]");
		WebElement closeModal = wait.until(ExpectedConditions.elementToBeClickable(closeModallocator));
		closeModal.click();
	}

	private static void clickForCity(WebDriverWait wait) {
		By forCityLocator = By.xpath("//label[@for=\"fromCity\"]");
		WebElement forCity = wait.until(ExpectedConditions.visibilityOfElementLocated(forCityLocator));
		forCity.click();
	}

	private static void enterTextInFromTextBox(WebDriverWait wait, String location) {
		By forCityInputTextBoxLocator = By.xpath("//input[@placeholder='From']");
		WebElement forCityInputTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(forCityInputTextBoxLocator));
		forCityInputTextBox.sendKeys(location);
	}

}
