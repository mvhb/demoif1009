package com.example.demoif1009

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class UIAutomatorDemo {

    @Test
    fun openCalculator(){
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val appDrawer = UiScrollable(UiSelector().scrollable(true))
        appDrawer.scrollForward()
        appDrawer.scrollTextIntoView("Calculator")

        val calculator = mDevice.findObject(UiSelector().text("Calculator"))
        calculator.click()

        //val clear = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/clr"))
        //clear.click()

        val numberFour = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_4"))
        numberFour.click()
        val plus = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_add"))
        plus.click()
        val numberFive = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_5"))
        numberFive.click()
        val result = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_preview"))
        assertEquals(result.text.toInt(),9)
    }
}