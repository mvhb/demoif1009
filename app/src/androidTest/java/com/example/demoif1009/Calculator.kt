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
class Calculator {
    val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setup(){
        mDevice.pressHome()
        val appDrawer = UiScrollable(UiSelector().scrollable(true))
        appDrawer.scrollForward()
        val calculator: UiObject = mDevice.findObject(UiSelector().text("Calculator"))
        calculator.click()
    }
    @Test
    fun sumOfTwoNumbers(){
        val numberFour: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_4"))
        numberFour.click()
        sleep(2000)
        val plus = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_add"))
        plus.click()
        sleep(2000)
        val numberFive: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_5"))
        numberFive.click()
        sleep(2000)
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        sleep(2000)
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),9)
    }
    @Test
    fun diffOfTwoNumbers(){
        val numberSeven: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_7"))
        numberSeven.click()
        sleep(2000)
        val minus: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_sub"))
        minus.click()
        sleep(2000)
        val numberOne: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_1"))
        numberOne.click()
        sleep(2000)
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        sleep(2000)
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),6)
    }
    @Test
    fun divOfTwoNumbers(){
        val numberEight: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_8"))
        numberEight.click()
        sleep(2000)
        val div: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_div"))
        div.click()
        sleep(2000)
        val numberTwo: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_2"))
        numberTwo.click()
        sleep(2000)
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        sleep(2000)
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),4)
    }
    @Test
    fun multOfTwoNumbers(){
        val numberThree: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_3"))
        numberThree.click()
        sleep(2000)
        val mult: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_mul"))
        mult.click()
        sleep(2000)
        val numberSix: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_6"))
        numberSix.click()
        sleep(2000)
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        sleep(2000)
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),18)
    }
    @After
    fun clear(){
        val clear: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/clr"))
        clear.click()
    }
}