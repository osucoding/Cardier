package com.example.cardier.ui.signup

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


internal class SignUpActivityEmailDomainTest {

    @Test
    fun emailTestCase_asu_returnFalse() {
        val result = SignUpTest.validateRegistrationInput("test@asu.edu")
        assertFalse(result)
    }

    @Test
    fun emailTestCase2_osu_returnTrue() {
        val result = SignUpTest.validateRegistrationInput("test@osu.edu")
        assertTrue(result)
    }

    @Test
    fun emailTestCase3_ossu_returnFalse() {
        val result = SignUpTest.validateRegistrationInput("test@ossu.edu")
        assertFalse(result)
    }

    @Test
    fun emailTestCase4_eedu_returnFalse() {
        val result = SignUpTest.validateRegistrationInput("test@osu.eedu")
        assertFalse(result)
    }

    @Test
    fun emailTestCase4_empty_returnFalse() {
        val result = SignUpTest.validateRegistrationInput("")
        assertFalse(result)
    }

    @Test
    fun pwTestCase_empty_returnFalse() {
        val result = SignUpTest.validateRegistrationInputPW("")
        assertFalse(result)
    }

    @Test
    fun pwTestCase_length5_returnFalse() {
        val result = SignUpTest.validateRegistrationInputPW("12345")
        assertFalse(result)
    }

    @Test
    fun pwTestCase_length10_returnFalse() {
        val result = SignUpTest.validateRegistrationInputPW("1234567890")
        assertFalse(result)
    }
}