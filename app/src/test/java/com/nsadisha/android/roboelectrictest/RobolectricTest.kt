package com.nsadisha.android.roboelectrictest

import android.widget.TextView
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RobolectricTest {

    @Test
    fun is_text_view_available_with_hello_world(){
        val mainActivity: MainActivity = Robolectric.setupActivity(MainActivity::class.java)

        val textView: TextView = mainActivity.findViewById(R.id.textView)

        Assert.assertEquals("Hello World", textView.text.toString())
    }
}