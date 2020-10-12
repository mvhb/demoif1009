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
class TurnOffWifi {
    val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setup(){
        mDevice.pressHome()
        val settings: UiObject = mDevice.findObject(UiSelector().text("Settings"))
        settings.click()
        sleep(3000)
    }
    @Test
    fun turnOffWifi(){
        val networkInternet: UiObject = mDevice.findObject(UiSelector().textContains("Network & internet"))
        networkInternet.click()
        val switch: UiObject = mDevice.findObject(UiSelector().resourceId("com.android.settings:id/switchWidget"))
        switch.click()
        sleep(3000)
        val wifiSummary: UiObject = mDevice.findObject(UiSelector().resourceId("android:id/summary"))
        assertEquals(wifiSummary.text,"Off")
        sleep(5000)
    }
    @After
    fun clear(){
        val switch: UiObject = mDevice.findObject(UiSelector().resourceId("com.android.settings:id/switchWidget"))
        switch.click()
    }
}