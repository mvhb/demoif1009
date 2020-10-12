package com.example.demoif1009

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChangePreferredNetworkType {
    val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setup(){
        mDevice.pressHome()
        val settings: UiObject = mDevice.findObject(UiSelector().text("Settings"))
        settings.click()
    }
    @Test
    fun changePreferredNetworkType(){
        val networkInternet: UiObject = mDevice.findObject(UiSelector().textMatches("Network & internet"))
        networkInternet.click()
        val mobileNetwork: UiObject = mDevice.findObject(UiSelector().textMatches("Mobile network"))
        mobileNetwork.click()
        val advanced: UiObject = mDevice.findObject(UiSelector().textMatches("Advanced"))
        advanced.click()
        val networkType: UiObject = mDevice.findObject(UiSelector().textMatches("Preferred network type"))
        networkType.click()
        val secondOption: UiObject = mDevice.findObject(UiSelector().textMatches("3G"))
        secondOption.click()
        networkType.click()
        assertTrue(secondOption.isChecked)
        assertTrue(secondOption.isEnabled)
    }
    @After
    fun clear(){
        val firstOption: UiObject = mDevice.findObject(UiSelector().textMatches("4G"))
        firstOption.click()
    }
}