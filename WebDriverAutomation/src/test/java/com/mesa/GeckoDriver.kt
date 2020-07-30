package com.mesa

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

fun main() {

    System.setProperty("webdriver.gecko.driver", MesaUtils.GECKO)

    val driver: WebDriver = FirefoxDriver()

    driver.get("https://www.google.com")

}