package com.framework

import Utils.Companion.BASE_URL
import Utils.Companion.CHROME_PATH
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class FirstUITest {

    private lateinit var options: ChromeOptions
    private lateinit var driver: WebDriver
    private val user: String = "izzyjr"

    @BeforeTest
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH)
        options = ChromeOptions().addArguments("start-fullscreen")
        driver = ChromeDriver(options)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
    }

    @Test(enabled = true)
    fun userNameIsCorrectOnOverviewTab() {

        // Arrange
        driver.get("$BASE_URL$user")

        // Act
        val actualUserName: String = driver.findElement(By.className("p-nickname")).text

        // Assert
        assertEquals(actualUserName, user)
    }

    @Test(enabled = true)
    fun repoLinkGoesToCorrectRepo() {

        // Arrange
        val repoUrl: String = "$BASE_URL$user/Tribute"
        driver.get("$BASE_URL$user")

        // Act
        val repository: WebElement = driver.findElement(By.xpath("//span[text()='Tribute']"))
        repository.click()

        // Assert
        val actualRepoUrl: String = driver.currentUrl
        assertEquals(actualRepoUrl, repoUrl)
    }

    @Test(enabled = true)
    fun countNumberOfRepos() {

        // Arrange
        val expectedRepoCount: Int = 66
        driver.get("$BASE_URL$user?tab=repositories")

        // Act
        var flag: Boolean = true
        var actualRepoCount: Int = 0
        while (flag) {
            val repositories: MutableList<WebElement> = driver.findElements(By.xpath("//a[@itemprop='name codeRepository']"))
            actualRepoCount += repositories.size
            repositories.clear()
            val nextButton: WebElement = driver.findElement(By.xpath("//*[text()='Next']"))
            if (nextButton.isEnabled) {
                nextButton.click()
            } else {
                flag = false
            }
        }

        // Assert
        assertEquals(actualRepoCount, expectedRepoCount)
    }

    @AfterTest
    fun cleanUp() {
        driver.close()
    }

}