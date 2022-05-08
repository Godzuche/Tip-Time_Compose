package com.godzuche.tiptime

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.godzuche.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeScreen()
            }
        }
        composeTestRule.apply {
            onNodeWithText("Bill Amount").performTextInput("10")
            onNodeWithText("Tip (%)").performTextInput("20")
            onNodeWithText("Tip Amount: $2.00").assertExists()
        }
    }
}