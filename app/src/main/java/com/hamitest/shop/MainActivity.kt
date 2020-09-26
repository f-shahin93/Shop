package com.hamitest.shop

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hamitest.shop.data.di.component.MainActivitySubComponent

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    lateinit var mainActivitySubComponent : MainActivitySubComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        mainActivitySubComponent = (applicationContext as ShopApplication).applicationComponent.mainActivitySubComponent().create()
        mainActivitySubComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_category,
                R.id.navigation_shopping_cart, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onResume() {
        super.onResume()

        if (isNavigateTOShoppingCart)
            navController.navigate(R.id.navigation_shopping_cart)

    }

    companion object {
        var isNavigateTOShoppingCart = false
    }


}