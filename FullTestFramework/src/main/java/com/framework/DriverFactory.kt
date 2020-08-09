package com.framework

import Utils.Companion.CHROME_PATH
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit

class DriverFactory {

    companion object {

        fun getChromeDriver(): WebDriver {
            System.setProperty("webdriver.chrome.driver", CHROME_PATH)
            val options: ChromeOptions = ChromeOptions().addArguments("start-fullscreen")
            val driver: WebDriver = ChromeDriver(options)
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
            return driver
        }

    }

}