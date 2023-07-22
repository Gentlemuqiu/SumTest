package com.example.model.daily


import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.model.daily.SPUtils.Companion.getInstance
import com.example.model.daily.banner.Adapter.PagerAdapter
import com.example.model.daily.banner.Adapter.Vp2Adapter
import com.example.model.daily.banner.ScaleTransformer
import com.example.model.daily.banner.ViewModel.BannerViewModel
import com.example.model.daily.net.model.Story
import com.example.model.daily.databinding.FragmentDailyBinding

import java.util.Timer
import java.util.TimerTask


class DailyFragment : Fragment() {

    //用来记录是否按压,如果按压,则不滚动
    var isDown = false
    private lateinit var rvListAdapter: com.example.model.daily.Adapter.RvListAdapter
    private var timer = Timer()

    private val bannerViewModel by lazy { ViewModelProvider(this)[BannerViewModel::class.java] }
//    private lateinit var adapter: Vp2Adapter
    private lateinit var adapter:PagerAdapter
    private val keyViewModel by lazy { ViewModelProvider(this)[com.example.model.daily.ViewModel.KeyViewModel::class.java] }

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
        initSearch()
        initView()
        doLogic()
        doBanner()
    }

    private fun initSearch() {
        initHistory()
        mBinding.etSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val searchKey = mBinding.etSearch.text.toString()
                if (!isNullorEmpty(searchKey)) {
                    val keyWord = mBinding.etSearch.text.toString()
                    if (!isNullorEmpty(keyWord)) {
                        activity?.let { getInstance(it).save(mBinding.etSearch.text.toString()) }
                    }
                    initHistory()
                }
            }
            false
        })
        mBinding.tvClear.setOnClickListener(View.OnClickListener {
            mBinding.listView.removeAllViews()
            activity?.let { it1 -> getInstance(it1).cleanHistory() }
        })

    }


    private fun initView() {
        bannerViewModel.getBannerStory()
//        adapter = Vp2Adapter(this,bannerViewModel.storyList)
        adapter = PagerAdapter(this)

        mBinding.vp2.adapter =adapter
        Log.d("slh", adapter.itemCount.toString())
    }

    private fun doLogic() {
        //对数据进行观察
//        bannerViewModel.bannerLiveData.observe(viewLifecycleOwner) { result ->
//            val data = result.getOrNull()
//            if (data != null) {
//                bannerViewModel.storyList.clear()
//                bannerViewModel.storyList.addAll(data.itemList)
//                adapter.notifyDataSetChanged()
//            }
        bannerViewModel.bannerStoryData.observe(viewLifecycleOwner){
            adapter.submitList(it.itemList)
        }
            mBinding.vp2.adapter = adapter
        }

    private fun doBanner() {

        mBinding.vp2.setPageTransformer(MarginPageTransformer(20))
        mBinding.vp2.offscreenPageLimit = 3
        mBinding.vp2.setPageTransformer(ScaleTransformer())
        //定时器播放ViewPager
        val timerTask: TimerTask = object : TimerTask() {
            override fun run() {
                if (!isDown) {
                    //获取到当前的位置
                    val page = mBinding.vp2.currentItem + 1
                    activity?.runOnUiThread { mBinding.vp2.currentItem = page
                        when(mBinding.vp2.currentItem){
                            21 -> mBinding.vp2.setCurrentItem(0,true)
                        }}

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

    private fun isNullorEmpty(str: String?): Boolean {
        return str == null || "" == str
    }

    //初始化历史列表
    private fun initHistory() {
        val data = requireActivity().let { SPUtils.getInstance(it).historyList }
        val layoutParams =
            ViewGroup.MarginLayoutParams(
                ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                ViewGroup.MarginLayoutParams.WRAP_CONTENT
            )
        mBinding.listView.removeAllViews()
        for (i in data.indices) {
            if (isNullorEmpty(data[i])) {
                return
            }
            //有数据就继续运行
            val paramItemView = layoutInflater.inflate(R.layout.history_view, null)
            val keyWordTv = paramItemView.findViewById<TextView>(R.id.tv_content)
            keyWordTv.text = data[i]
            mBinding.listView.addView(paramItemView, layoutParams)
            keyWordTv.setOnClickListener {
                mBinding.etSearch.setText(data[i])
                mBinding.etSearch.setSelection(data[i].length) //光标在最后
                if (!isNullorEmpty(data[i])) {
                    activity?.let { SPUtils.getInstance(it).save(mBinding.etSearch.text.toString()) }
                }
                //点击事件
            }
            // initautoSearch();
        }
    }
}