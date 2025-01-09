package com.example.veterinaria

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.veterinaria.database.AppDatabase
import com.example.veterinaria.fragments.ConsultFragment
import com.example.veterinaria.fragments.HomeFragment
import com.example.veterinaria.fragments.TreatmentFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()
                    true
                }
                R.id.navigation_treatment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TreatmentFragment())
                        .commit()
                    true
                }
                R.id.navigation_consult -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ConsultFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }

        // Set default fragment
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_home
        }

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            when (currentFragment) {
                is ConsultFragment -> {
                    val intent = Intent(this, CreateConsultActivity::class.java)
                    startActivity(intent)
                }

                is TreatmentFragment -> {
                    val intent = Intent(this, CreateTreatmentActivity::class.java)
                    startActivity(intent)
                }

                is HomeFragment -> {
                    val intent = Intent(this, CreateChartActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    // Default action
                }
            }
        }

        // Initialize the Room database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "veterinaria_database"
        ).build()
    }
}