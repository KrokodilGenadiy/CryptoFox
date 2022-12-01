package com.zaus_app.cryptofox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.zaus_app.cryptofox.databinding.ActivityMainBinding
import com.zaus_app.cryptofox.view.HomeFragment
import com.zaus_app.cryptofox.view.NewsFragment
import com.zaus_app.cryptofox.view.SearchFragment
import com.zaus_app.cryptofox.view.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
    }

    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .commit()
    }
    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it) {
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: HomeFragment(), tag)
                }
                R.id.search -> {
                    val tag = "search"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: SearchFragment(), tag)
                }
                R.id.news -> {
                    val tag = "news"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: NewsFragment(), tag)
                }
                R.id.settings -> {
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: SettingsFragment(), tag)
                }
            }
        }
        binding.bottomNavigation.setItemSelected(R.id.home)
    }
}