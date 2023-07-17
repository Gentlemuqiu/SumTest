package com.example.modle.home


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.hot.HotFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

@Route(path = "/home/HomeActivity/")
class HomeActivity : AppCompatActivity() {
   private lateinit var mNavigationView: BottomNavigationView
   private lateinit var hot: HotFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mNavigationView = findViewById(R.id.mBottomNavigationView)
    }
}