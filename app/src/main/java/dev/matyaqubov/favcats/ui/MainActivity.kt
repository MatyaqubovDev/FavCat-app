package dev.matyaqubov.favcats.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.matyaqubov.favcats.R
import dev.matyaqubov.favcats.ui.fragment.AddPhotoFragment
import dev.matyaqubov.favcats.ui.fragment.MineFragment
import dev.matyaqubov.favcats.ui.fragment.SearchFragment

class MainActivity : AppCompatActivity(){

private lateinit var addButton: FloatingActionButton
private lateinit var bottomNavigationView: BottomNavigationView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initViews()
}

private fun initViews() {
    addButton=findViewById(R.id.fab)
    val searchFragment = SearchFragment()
    val mineFragment = MineFragment()
    bottomNavigationView = findViewById(R.id.bottomNavigationView)
    bottomNavigationView.background = null
    bottomNavigationView.menu.getItem(1).isEnabled = false

    setCurrentFragment(searchFragment)

    bottomNavigationView.setOnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.SearchFragment -> setCurrentFragment(searchFragment)
            R.id.MineFragment -> setCurrentFragment(mineFragment)
        }
        true
    }

    addButton.setOnClickListener {
        var fragment=AddPhotoFragment()
        setCurrentFragment(fragment)
    }

}

fun setCurrentFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
        addToBackStack("back")
        commit()
    }

}
}