package com.example.demoif1009

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class AirplaneMode {
    val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setup(){
        mDevice.pressHome()
        val settings: UiObject = mDevice.findObject(UiSelector().text("Settings"))
        settings.click()
        sleep(3000)
    }
    @Test
    fun enableAirplaneMode(){
        val networkInternet: UiObject = mDevice.findObject(UiSelector().textContains("Network & internet"))
        networkInternet.click()
        sleep(3000)
        val advanced: UiObject = mDevice.findObject(UiSelector().textContains("Advanced"))
        advanced.click()
        sleep(3000)
        val switch: UiObject = mDevice.findObject(UiSelector().resourceId("android:id/switch_widget"))
        switch.click()
        sleep(3000)
        val mobileNetwork: UiObject = mDevice.findObject(UiSelector().textContains("Mobile network"))
        assertFalse(mobileNetwork.isClickable)
        sleep(5000)
    }
    @After
    fun clear(){
        val switch: UiObject = mDevice.findObject(UiSelector().resourceId("android:id/switch_widget"))
        switch.click()
    }
}