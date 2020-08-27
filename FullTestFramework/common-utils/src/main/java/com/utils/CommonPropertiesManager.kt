package com.utils

import java.io.FileInputStream
import java.util.*

open class CommonPropertiesManager {

    companion object {

        private val fis: FileInputStream =
                FileInputStream("/Users/israelmesa/Desktop/SDET/FullTestFramework" +
                        "/common-utils/src/main/java/com/utils/properties.properties")
        private val properties: Properties = Properties()

        private fun loadFile() {
            properties.load(fis)
        }

        val initializer = loadFile()

        fun loadProp(prop: String): String {
            return properties.getProperty(prop)
        }
    }
}