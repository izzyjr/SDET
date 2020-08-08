package com.framework.unitests

import Utils.Companion.CHROME_PATH
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit

open class BaseTestClass {

    private lateinit var options: ChromeOptions
    protected lateinit var driver: WebDriver

    fun setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH)
        options = ChromeOptions().addArguments("start-fullscreen")
        driver = ChromeDriver(options)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
    }

    open fun cleanUp() {
        driver.close()
    }

    protected companion object {
        const val BASE_URL: String = "https://github.com/"
        const val USER: String = "izzyjr"
    }

}