package com.nsadisha.android.roboelectrictest

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.TextView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RobolectricTest {

    private var activity: MainActivity? = null
    private var fragment: FirstFragment? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fragment = FirstFragment()
        activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment!!, null)
        fragmentTransaction.commit()
    }

    @Test
    fun is_text_view_available_in_Main_activity(){
        val textView: TextView = activity!!.findViewById(R.id.activityText)
        Assert.assertEquals("Hello World from MainActivity", textView.text.toString())
    }

    @Test
    fun is_text_view_available_in_fragment(){
        val textView: TextView = activity!!.findViewById(R.id.fragmentText)
        Assert.assertEquals("Hello World from Fragment", textView.text.toString())
    }
}