package com.example.cardier.ui.item

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cardier.R
import com.example.cardier.databinding.ActivityMainBinding
import com.example.cardier.ui.user.UserSettingUpActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        // set navigation header name as the user email
        var header = binding.mainDrawerView.getHeaderView(0)
        var headerTextView = header.findViewById<TextView>(R.id.header_nav)
        headerTextView.text = MyApplication.email.toString()
        // onClickListener to address the user to user info activity
        headerTextView.setOnClickListener{
            val intent = Intent(this, UserSettingUpActivity::class.java)
            startActivity(intent)
        }

        var drawerMenu = binding.mainDrawerView.menu

        // Toggle that
        toggle = ActionBarDrawerToggle(this, binding.drawer,
            R.string.drawer_opened,
            R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        // Click listener when the user click the menu items
        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("User", "navigation item click... ${it.title}")
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}