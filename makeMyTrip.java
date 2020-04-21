package makeMyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class makeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByLinkText("Hotels").click();
		Thread.sleep(2000);
		// driver.findElementByXPath("(//div[@class='hsw_inner']//div)[1]").click();
		driver.findElementByXPath("(//span[@class='lbl_input latoBold  appendBottom5'])").click();
		driver.findElementByXPath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("goa");
		Thread.sleep(3000);
		driver.findElementByXPath("//p[contains(text(),'Goa, India')]").click();
		driver.findElementById("checkin").click();
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		String chkin = driver.findElementByXPath("(//div[@class='DayPicker-Month'])[2]").getText();
		driver.findElementByXPath("(//div[text()='20'])[2]").click();
		driver.findElementById("guest").click();
		driver.findElementByXPath("(//li[text()='2'])[1]").click();
		driver.findElementByXPath("(//li[text()='1'])[2]").click();
		WebElement ele = driver.findElementByXPath("//select[@class='ageSelectBox']");
		Select age = new Select(ele);
		age.selectByVisibleText("8");
		driver.findElementByXPath("//button[text()='APPLY']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//button[@id='hsw_search_button']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[text()='Baga']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[text()='5 Star']").click();
		//driver.findElementByXPath("(//div[@class='listingRow  bdr    '])[1]").click();
		driver.findElementByXPath("//span[@id='htl_id_seo_201801171522004728'])[1]").click();
		Thread.sleep(3000);
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> Listofwindows = new ArrayList<String>();
		Listofwindows.addAll(windowhandles);
		driver.switchTo().window(Listofwindows.get(2));
		Thread.sleep(2000);
		String hotelname = driver.findElementById("detpg_hotel_name").getText();
		System.out.println("Hotel Name is:" + hotelname);
		driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='SELECT'])[1]").click();
		driver.findElementByXPath("//span[@class='close']").click();
		driver.findElement(By.linkText("BOOK THIS NOW")).click();
		String amount = driver.findElement(By.id("revpg_total_payable_amt")).getText();
		String totalbillamt = amount.replaceAll("[^0-9]", "");
		System.out.println("Total Bill Amount: Rs." + totalbillamt);
		driver.quit();
		
		
	}

}
