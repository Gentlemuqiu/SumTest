package com.example.modle.home


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.hot.HotFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

@Route(path = "/home/HomeActivity/")
class HomeActivity : AppCompatActivity() {
    private lateinit var navigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.openeyes) as NavHostFragment
        val navController=host.navController
        navigationView=findViewById(R.id.mBottomNavigationView)
        navigationView.setupWithNavController(navController)
    }
}