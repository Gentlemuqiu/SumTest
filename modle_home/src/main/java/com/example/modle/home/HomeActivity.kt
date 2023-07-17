package com.example.modle.home


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

@Route(path = "/home/HomeActivity/")
class HomeActivity : AppCompatActivity() {
   private lateinit var mNavigationView: BottomNavigationView
    /*companion object {
        fun startActivity(context: Context, args: String) {
            context.startActivity(
                Intent(
                    context,
                    HomeActivity::class.java
                ).apply { putExtra("我是参数", args) })
        }
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mNavigationView = findViewById(R.id.mBottomNavigationView)
        //initEvent()
    }

   /* fun initEvent() {
        //设置首页的fragment
        val answer: answer = com.example.homework.Fragment.answer.newInstance("首页", "")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_left, answer)
            .commit()
        mNavigationView.setCheckedItem(R.id.menu_answer)
        //设置每个栏目被点击后的事件监听
        mNavigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_daily -> {
                    val answer: answer =
                        com.example.homework.Fragment.answer.newInstance("首页", "")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_left, answer)
                        .commit()
                }

                R.id.item_playGround -> {
                    supportFragmentManager.beginTransaction()
                        .replace().commit()
                }

                R.id.item_discover -> {
                    val tool: tool = com.example.homework.Fragment.tool.newInstance("s", "")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_left, tool)
                        .commit()
                }

                R.id.item_hot -> {
                    val teach: teach = com.example.homework.Fragment.teach.newInstance("1", "")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_left, teach)
                        .commit()
                }

            }
            true
        })
    }*/
}