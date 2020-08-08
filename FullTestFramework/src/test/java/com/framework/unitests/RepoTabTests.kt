package com.framework.unitests

import Utils.Companion.BASE_URL
import Utils.Companion.USER
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class RepoTabTests : BaseTestClass() {


    @BeforeTest
    override fun setUp() {
        super.setUp()
    }

    @Test(enabled = true)
    fun repoLinkGoesToCorrectRepo() {

        // Arrange
        val repoUrl: String = "$BASE_URL$USER/Tribute"
        driver.get("$BASE_URL$USER")

        // Act
        val repository: WebElement = driver.findElement(By.xpath("//span[text()='Tribute']"))
        repository.click()

        // Assert
        val actualRepoUrl: String = driver.currentUrl
        Assert.assertEquals(actualRepoUrl, repoUrl)
    }

    @Test(enabled = true)
    fun countNumberOfRepos() {

        // Arrange
        val expectedRepoCount: Int = 66
        driver.get("$BASE_URL$USER?tab=repositories")

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
        Assert.assertEquals(actualRepoCount, expectedRepoCount)
    }

    @AfterTest
    override fun cleanUp() {
        super.cleanUp()
    }

}