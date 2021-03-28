package com.example.islamicfragment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamicfragment.R
import com.example.islamicfragment.fragment.HadethFragment
import com.example.islamicfragment.fragment.QuraanFragment
import com.example.islamicfragment.fragment.RadioFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener { item->

            if (item.itemId == R.id.quraan_navigation){
                pushFragment(QuraanFragment())
            }else if (item.itemId == R.id.hadeth_navigation){
                pushFragment(HadethFragment())
            }else if (item.itemId == R.id.radio_navigation){
                pushFragment(RadioFragment())
            }

            true }
    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.navigation_container,fragment).addToBackStack(null).commit()
    }

}