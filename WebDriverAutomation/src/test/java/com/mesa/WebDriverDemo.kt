package com.mesa

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class WebDriverDemo {

    private lateinit var driver: WebDriver
    private lateinit var wait: WebDriverWait

    @BeforeMethod
    fun startUpBrowser() {
        System.setProperty("webdriver.chrome.driver", MesaUtils.PATH)
        driver = ChromeDriver()
        driver.get("https://google.com")
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().fullscreen()
    }

//    @Test
//    fun searchMovie() {
//        val searchField: WebElement = driver.findElement(By.xpath(MesaUtils.GOOGLE_SEARCH_BAR))
//        searchField.sendKeys(MesaUtils.MOVIE)
//        val searchButton: WebElement = driver.findElement(By.xpath(MesaUtils.GOOGLE_SEARCH_BUTTON))
//        searchButton.click()
//    }

    @Test
    fun demoTest() {
        val searchField: WebElement = driver.findElement(By.xpath(MesaUtils.GOOGLE_SEARCH_BAR))
        searchField.sendKeys(MesaUtils.SEARCH)
        searchField.submit()
        val imagesLink: WebElement = driver.findElements(By.linkText("Images"))[0]
        imagesLink.click()
        val imageElement: WebElement = driver.findElements(By.cssSelector(MesaUtils.IMAGE))[0]
        imageElement.click()
    }

}
