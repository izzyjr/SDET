package com.mesa

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestingWebDriver {

    private lateinit var driver: WebDriver

    @BeforeMethod
    fun startUpBrowser() {
        System.setProperty("webdriver.chrome.driver", MesaUtils.CHROME)
        driver = ChromeDriver()
    }

    @Test(enabled = false)
    fun searchMovie() {
        driver.get("https://google.com")
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().fullscreen()
        val searchField: WebElement = driver.findElement(By.xpath(MesaUtils.GOOGLE_SEARCH_BAR))
        searchField.sendKeys(MesaUtils.MOVIE)
        val searchButton: WebElement = driver.findElement(By.xpath(MesaUtils.GOOGLE_SEARCH_BUTTON))
        searchButton.click()
    }

    @Test(enabled = false)
    fun googleImageTest() {
        driver.get("https://google.com")
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().fullscreen()
        val searchField: WebElement = driver.findElement(By.xpath(MesaUtils.GOOGLE_SEARCH_BAR))
        searchField.sendKeys(MesaUtils.SEARCH)
        searchField.submit()
        val imagesLink: WebElement = driver.findElements(By.linkText("Images"))[0]
        imagesLink.click()
        val imageElement: WebElement = driver.findElements(By.cssSelector(MesaUtils.IMAGE))[0]
        imageElement.click()
    }

    @Test(enabled = false)
    fun radioButtonTest() {
        driver.get("http://localhost:63342/WebDriverAutomation/src/main/webapp/WebElementTest.html")
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().fullscreen()
        val radioButtons: List<WebElement> = driver.findElements(By.name("color"))
        radioButtons[1].click()
        for (radioButton in radioButtons) {
            if(radioButton.isSelected) {
                println(radioButton.getAttribute("value"))
            }
        }
    }

    @Test(enabled = true)
    fun checkboxTest() {
        driver.get("http://localhost:63342/WebDriverAutomation/src/main/webapp/WebElementTest.html")
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().fullscreen()
        val checkbox: WebElement = driver.findElement(By.id("turkeyCheckbox"))
        checkbox.click()
        println(checkbox.getAttribute("value"))
    }

}
