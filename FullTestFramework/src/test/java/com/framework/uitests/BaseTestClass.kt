package com.framework.uitests

import Utils.Companion.CHROME_PATH
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit

open class BaseTestClass {

    private lateinit var options: ChromeOptions
    protected lateinit var driver: WebDriver

    open fun setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH)
        options = ChromeOptions().addArguments("start-fullscreen")
        driver = ChromeDriver(options)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
    }

    open fun cleanUp() {
        driver.close()
    }

    protected companion object {

        const val USER: String = "izzyjr"

        // URL PATHS
        const val BASE_URL: String = "https://github.com/"
        const val USER_URL: String = "https://github.com/izzyjr"
        const val TRIBUTE_REPO: String = "https://github.com/izzyjr/Tribute"
        const val REPOS_URL: String = "https://github.com/izzyjr?tab=repositories"

        // XPATH
        const val TRIBUTE_REPO_XPATH: String = "//span[text()='Tribute']"
        const val REPOSITORIES_XPATH: String = "//a[@itemprop='name codeRepository']"
        const val NEXT_BUTTON_XPATH: String = "//*[text()='Next']"
    }

}