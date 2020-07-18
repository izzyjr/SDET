package mesa

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class SearchTest {

    private lateinit var driver: WebDriver
    private lateinit var wait: WebDriverWait

    @BeforeMethod
    fun startUpBrowser() {
        System.setProperty("webdriver.chrome.driver",  "/Users/israelmesa/Desktop/ChromeDriver/chromedriver")
        driver = ChromeDriver()
        driver.get("https://app.pluralsight.com/library/")
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().fullscreen()
        wait = WebDriverWait(driver, 5)
    }

    @Test
    fun basicFilterByTest() {
        // search and enter
        val search: WebElement = driver.findElement(By.className("header_search--input"))
    }

}