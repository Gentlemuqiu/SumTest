package com.example.model.daily


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.model.daily.banner.Adapter.PagerAdapter
import com.example.model.daily.banner.ScaleTransformer
import com.example.model.daily.banner.ViewModel.BannerViewModel
import com.example.model.daily.databinding.FragmentDailyBinding

import java.util.Timer
import java.util.TimerTask


class DailyFragment : Fragment() {

    //用来记录是否按压,如果按压,则不滚动
    var isDown = false

    private var timer = Timer()

    private val bannerViewModel by lazy { ViewModelProvider(this)[BannerViewModel::class.java] }
    private lateinit var adapter: PagerAdapter

    private val mBinding: FragmentDailyBinding by lazy {
        FragmentDailyBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initView()
        doLogic()
        doBanner()
    }


    private fun initView() {
        bannerViewModel.getBannerStory()
        adapter = PagerAdapter(this)

        mBinding.vp2.adapter =adapter
        Log.d("slh", adapter.itemCount.toString())
    }

    private fun doLogic() {
        //对数据进行观察
        bannerViewModel.bannerStoryData.observe(viewLifecycleOwner) {
            adapter.submitList(it.itemList)
        }
        mBinding.vp2.adapter = adapter
    }



    private fun doBanner() {

        mBinding.vp2.setPageTransformer(MarginPageTransformer(20))
        mBinding.vp2.offscreenPageLimit = 3
        mBinding.vp2.currentItem = 1
        mBinding.vp2.setPageTransformer(ScaleTransformer())
        //定时器播放ViewPager
        val timerTask: TimerTask = object : TimerTask() {
            override fun run() {
                if (!isDown) {
                    //获取到当前的位置
                    val page = mBinding.vp2.currentItem + 1
                    activity?.runOnUiThread { mBinding.vp2.currentItem = page }
                }
            }
        }
        // 每2.5秒执行一次
        timer.schedule(timerTask, 0, 2500)
        mBinding.vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //viewPager滑动的时候,设置不让滚动
                isDown = true
            }

            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {
                //ViewPager不点击了让滚动
                isDown = false
            }
        })
    }

}


