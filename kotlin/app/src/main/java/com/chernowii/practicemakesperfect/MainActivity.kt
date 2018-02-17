package com.chernowii.practicemakesperfect

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import com.chernowii.practicemakesperfect.utils.*
import android.util.TypedValue
import android.graphics.Color.parseColor
import android.support.annotation.IdRes
import android.support.v7.widget.CardView
import android.view.View
import java.util.Arrays.asList
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var CardLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val Weather_Madrid = Weather("Madrid")
        val Weather_NewYork = Weather("New York")
        val Weather_Paris = Weather("Paris")
        val NewYork = listOf(Weather_NewYork.getCityName(), Weather_NewYork.getTemperature(), Weather_NewYork.getCondition(), Weather_NewYork.getForecast(), Weather_NewYork.getHumidity())
        val Paris = listOf(Weather_Paris.getCityName(), Weather_Paris.getTemperature(), Weather_Paris.getCondition(), Weather_Paris.getForecast(), Weather_Paris.getHumidity())
        val Madrid = listOf(Weather_Madrid.getCityName(), Weather_Madrid.getTemperature(), Weather_Madrid.getCondition(), Weather_Madrid.getForecast(), Weather_Madrid.getHumidity())
        addCity(NewYork)
        addCity(Madrid)
        addCity(Paris)
        val ACTION_NYC = "com.chernowii.practicemakesperfect.NEW_YORK"
        if (ACTION_NYC.equals(getIntent().getAction())) {
            // Invoked via the manifest shortcut.
            Toast.makeText(applicationContext,"NYC",Toast.LENGTH_SHORT).show()
        }
    }
    fun addCity(c: List<String>){
        val mContext = applicationContext
        CardLayout = findViewById<LinearLayout>(R.id.content_app) as LinearLayout
        val card = CardView(mContext)
        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
        card.layoutParams = params
        card.radius = 9f
        card.setContentPadding(30, 30, 30, 30)
        card.setRadius(9.0F)
        card.preventCornerOverlap = false
        card.useCompatPadding = true
        card.setPadding(15,15,15,15)
        card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"))
        card.maxCardElevation = 15f
        card.cardElevation = 9f
        val tv = TextView(mContext)
        tv.layoutParams = params
        tv.text = c[0]
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f)
        tv.setTextColor(Color.RED)
        card.addView(tv)
        CardLayout.addView(card)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

