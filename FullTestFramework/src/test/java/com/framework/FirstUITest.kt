package com.framework

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.Assert
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class FirstUITest {

    private lateinit var options: ChromeOptions
    private lateinit var driver: WebDriver
    private val user: String = "izzyjr"

    @BeforeTest
    fun startUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/israelmesa/Desktop/ChromeDriver/chromedriver")
        options = ChromeOptions().addArguments("start-fullscreen")
        driver = ChromeDriver(options)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
    }

    @Test(enabled = false)
    fun userNameIsCorrectOnOverviewTab() {

        // Arrange
        driver.get("https://github.com/$user")

        // Act
        val actualUserName: String = driver.findElement(By.className("p-nickname")).text

        // Assert
        Assert.assertEquals(actualUserName, user)

        driver.close()

    }

    @Test(enabled = true)
    fun repoLinkGoesToCorrectRepo() {

        // Arrange
        val repoUrl: String = "https://github.com/izzyjr/Tribute"
        driver.get("https://github.com/$user")

        // Act
        val repository: WebElement = driver.findElement(By.xpath("//span[text()='Tribute']"))
        repository.click()

        // Assert
        val actualRepoUrl: String = driver.currentUrl
        Assert.assertEquals(actualRepoUrl, repoUrl)
        driver.close()

    }

}