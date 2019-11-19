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
class Calculator {
    val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setup(){
        mDevice.pressHome()
        val appDrawer = UiScrollable(UiSelector().scrollable(true))
        appDrawer.scrollForward()
        appDrawer.scrollTextIntoView("Calculator")
        val calculator: UiObject = mDevice.findObject(UiSelector().text("Calculator"))
        calculator.click()
    }
    @Test
    fun sumOfTwoNumbers(){
        val numberFour: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_4"))
        numberFour.click()
        val plus = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_add"))
        plus.click()
        val numberFive: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_5"))
        numberFive.click()
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),9)
    }
    @Test
    fun diffOfTwoNumbers(){
        val numberSeven: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_7"))
        numberSeven.click()
        val minus: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_sub"))
        minus.click()
        val numberOne: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_1"))
        numberOne.click()
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),6)
    }
    @Test
    fun divOfTwoNumbers(){
        val numberEight: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_8"))
        numberEight.click()
        val div: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_div"))
        div.click()
        val numberTwo: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_2"))
        numberTwo.click()
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),4)
    }
    @Test
    fun multOfTwoNumbers(){
        val numberThree: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_3"))
        numberThree.click()
        val mult: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/op_mul"))
        mult.click()
        val numberSix: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/digit_6"))
        numberSix.click()
        val equals: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/eq"))
        equals.click()
        val result: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/result_final"))
        assertEquals(result.text.toInt(),18)
    }
    @After
    fun clear(){
        val clear: UiObject = mDevice.findObject(UiSelector().resourceId("com.google.android.calculator:id/clr"))
        clear.click()
    }
}