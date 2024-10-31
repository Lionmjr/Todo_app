// MainActivity.kt
package com.example.studentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import com.example.todoapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.feedFragment, R.id.calendarFragment, R.id.tasksFragment, R.id.profileFragment)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNav.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.settingsActivity)
                return true
            }
            R.id.about -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.aboutActivity)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
