package e2e;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestArraysChallenge extends TestCase {

	WebDriver driver;
	public int n;
	public int arr[];
	public int index;

	@Given("User is on Home page")
	public void userOnHomePage() {
		System.setProperty("webdriver.chrome.driver", "./arrayschallenge1/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@And("And user has a set of array values as (\\d+)(\\d+)(\\d+)(\\d+)(\\d+)(\\d+)(\\d+)(\\d+)(\\d+)")
	public void retrieveSetOfArrayValue(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8,
			int num9) throws InterruptedException {
		int arr[] = { num1, num2, num3, num4, num5, num6, num7, num8, num9 };

	}

	@When("user find the sum of integers at the index on the left is equal to the sum of integers on the right")
	public void findindIndex() throws InterruptedException {
		n = arr.length;
		index = findElement(arr, n);

	}

	@Then("user return the index of array")
	public void returnIndex() {
		System.out.println("Index of the intger is: " +findElement(arr, n));
	}

	// Finds an element in an array such that
	// left and right side sums are equal
	static int findElement(int arr[], int n) {
		// Forming prefix sum array from 0
		int[] prefixSum = new int[n];
		prefixSum[0] = arr[0];
		for (int i = 1; i < n; i++)
			prefixSum[i] = prefixSum[i - 1] + arr[i];

		// Forming suffix sum array from n-1
		int[] suffixSum = new int[n];
		suffixSum[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suffixSum[i] = suffixSum[i + 1] + arr[i];

		// Find the point where prefix and suffix
		// sums are same.
		for (int i = 1; i < n - 1; i++)
			if (prefixSum[i] == suffixSum[i])
				return arr[i];

		return -1;
	}

	@And("user exit the page")
	public void tearDown() {
		driver.quit();
	}
}
