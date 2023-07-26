package com.example.modle.home


import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.daily.DailyFragment
import com.example.model.hot.HotFragment
import com.example.model.search.SearchFragment
import com.example.modle.home.databinding.ActivityHomeBinding
import com.example.modle_playground.PlayGroundFragment

@Route(path = "/home/HomeActivity/")
class HomeActivity : AppCompatActivity() {
    private val mBinding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.white)
        val searchFragment = SearchFragment()
        val hotFragment = HotFragment()
        val playGroundFragment = PlayGroundFragment()
        val dailyFragment = DailyFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_fragment, dailyFragment)
            .commit()

        mBinding.mBottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_daily -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_fragment, dailyFragment)
                        .commit()
                }

                R.id.item_hot -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_fragment, hotFragment)
                        .commit()
                }

                R.id.item_playGround -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_fragment, playGroundFragment)
                        .commit()
                }

                R.id.item_discover -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_fragment, searchFragment)
                        .commit()
                }
            }
            true
        }


    }


}