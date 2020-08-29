package com.ui.uitests

import com.utils.DriverFactory.Companion.getChromeDriver
import org.openqa.selenium.WebDriver

open class BaseTestClass {

    protected lateinit var driver: WebDriver

    open fun setUp() {
        driver = getChromeDriver()
    }

    open fun cleanUp() {
        driver.close()
    }

    protected companion object {

        const val USER: String = "izzyjr"

        // URL PATHS
        const val BASE_URL: String = "https://github.com/"
        const val USER_URL: String = "https://github.com/izzyjr"
        const val SDET_REPO: String = "https://github.com/izzyjr/SDET"
        const val REPOS_URL: String = "https://github.com/izzyjr?tab=repositories"

        // XPATH
        const val SDET_REPO_XPATH: String = "//span[text()='SDET']"
        const val REPOSITORIES_XPATH: String = "//a[@itemprop='name codeRepository']"
        const val NEXT_BUTTON_XPATH: String = "//*[text()='Next']"
    }

}