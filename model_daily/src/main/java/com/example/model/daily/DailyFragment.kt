package com.example.model.daily


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.daily.BelowBanner.Adapter.BelowBannerAdapter
import com.example.model.daily.BelowBanner.ViewModel.BelowBannerViewModel
import com.example.model.daily.BelowStory.Adapter.BelowStoryAdapter
import com.example.model.daily.BelowStory.Net.Model.BelowStory
import com.example.model.daily.BelowStory.Viewmodel.BelowStoryViewModel
import com.example.model.daily.BelowStory.Viewmodel.NewBelowStoryViewModel
import com.example.model.daily.CustomView.ArcUpTransformer
import com.example.model.daily.CustomView.ScaleTransformer
import com.example.model.daily.Recommend.Adapter.RecommendAdapter
import com.example.model.daily.Recommend.ViewModel.RecommendViewModel
import com.example.model.daily.Search.Adapter.RvListAdapter
import com.example.model.daily.Search.SPUtils
import com.example.model.daily.Search.SPUtils.Companion.getInstance
import com.example.model.daily.Search.ViewModel.KeyViewModel
import com.example.model.daily.TopBanner.Adapter.Vp2Adapter
import com.example.model.daily.TopBanner.ViewModel.BannerViewModel
import com.example.model.daily.databinding.FragmentDailyBinding
import java.util.Timer
import java.util.TimerTask


@Route(path = "/daily/DailyFragment/")
class DailyFragment : Fragment() {

    //用来记录是否按压,如果按压,则不滚动
    var isDown = false

    var isStart = false



    private var url: String? = null

    private var timer = Timer()

    private lateinit var  timerTask: TimerTask

    private  var isLoading = false;

    private val bannerViewModel by lazy { ViewModelProvider(this)[BannerViewModel::class.java] }

    private val recommendViewModel by lazy { ViewModelProvider(this)[RecommendViewModel::class.java] }

    private val belowBannerViewModel by lazy { ViewModelProvider(this)[BelowBannerViewModel::class.java] }

    private val belowStoryViewModel by lazy { ViewModelProvider(this)[BelowStoryViewModel::class.java] }

    private val newBelowStoryViewModel by lazy { ViewModelProvider(this)[NewBelowStoryViewModel::class.java] }

    private lateinit var adapter: Vp2Adapter

    private lateinit var rvAdapter: RvListAdapter

    private lateinit var rAdapter: RecommendAdapter

    private lateinit var belowBannerAdapter: BelowBannerAdapter

    private lateinit var belowStoryAdapter: BelowStoryAdapter

    private var data: MutableList<BelowStory.Item> = mutableListOf()



    //    private lateinit var adapter: PagerAdapter
    private val keyViewModel by lazy { ViewModelProvider(this)[KeyViewModel::class.java] }

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


    @SuppressLint("ClickableViewAccessibility", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearch()
        initView()
        doLogic()
        doBanner()
        doBelowBanner()
        doSearch()

        doRefresh()


        mBinding.rvBelowStory.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                if (totalItemCount - 1 == lastVisibleItemPosition&& !recyclerView.canScrollVertically(1)) {
                    Log.d("slh", "onScrolled: +1")
                }
            }
        })

    }


    private fun doRefresh() {
        mBinding.sf.setOnRefreshListener {
            //刷新时,再次请求一次数据
            bannerViewModel.getBannerStory()
            recommendViewModel.getRecommend()
            belowBannerViewModel.getBelowBannerStory()
            belowStoryViewModel.getBelowStory()
            //将刷新状态取消
            mBinding.sf.isRefreshing = false
        }
    }


    private fun initSearch() {
        initHistory()
        mBinding.etSearch.setTextColor(Color.BLACK)
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

    }

        private fun doSearch() {
            mBinding.tvClear.setOnClickListener(View.OnClickListener {
                mBinding.listView.removeAllViews()
                activity?.let { it1 -> getInstance(it1).cleanHistory() }
            })
//            mBinding.etSearch.setOnClickListener(View.OnClickListener {
//                mBinding.searchHistory.visibility = View.VISIBLE
//                mBinding.sf.visibility = View.GONE
//                initKeyHot()
//            })

            mBinding.searchBack.setOnClickListener(View.OnClickListener {
                mBinding.searchHistory.visibility = View.GONE
                mBinding.sf.visibility = View.VISIBLE
                mBinding.etSearch.clearFocus()
                mBinding.etSearch.setText("")
                fun hideKeyboard(context: Context, editText: EditText) {
                    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(editText.windowToken, 0)
                }
                context?.let { it1 -> hideKeyboard(it1, mBinding.etSearch) }
            })

            class EtOnTouchListener() : OnTouchListener {
                var touch_flag = 0
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    touch_flag++
                    if (touch_flag == 2) {
                        touch_flag = 0
                        mBinding.searchHistory.visibility = View.VISIBLE
                        mBinding.sf.visibility = View.GONE
                        initKeyHot()
                    }
                    return false
                }
            }


            mBinding.etSearch.setOnTouchListener(EtOnTouchListener())

        }

        private fun initView() {
            bannerViewModel.getBannerStory()
            adapter = Vp2Adapter(this, bannerViewModel.storyList)

            mBinding.vp2.adapter = adapter

            keyViewModel.getKey()
            rvAdapter = RvListAdapter(this)

            recommendViewModel.getRecommend()
            rAdapter = RecommendAdapter(this,recommendViewModel.recommendList)

            belowBannerViewModel.getBelowBannerStory()
            belowBannerAdapter = BelowBannerAdapter(this,belowBannerViewModel.belowStoryList)

            belowStoryViewModel.getBelowStory()
            belowStoryAdapter = BelowStoryAdapter(this,belowStoryViewModel.belowStoryList)
        }


        private fun doLogic() {
            //对数据进行观察
            bannerViewModel.bannerLiveData.observe(viewLifecycleOwner) { result ->
                val data = result.getOrNull()
                if (data != null) {
                    bannerViewModel.storyList.clear()
                    for (i in 1..10) {
                        bannerViewModel.storyList.add(data.itemList[i])
                    }
                    for (i in 12..21) {
                        bannerViewModel.storyList.add(data.itemList[i])
                    }
                    adapter.notifyDataSetChanged()
                }
//        bannerViewModel.bannerStoryData.observe(viewLifecycleOwner){
//            adapter.submitList(it.itemList)
//            adapter.submitList(it.itemList)
            }

//            keyViewModel.keyData.observe(viewLifecycleOwner){
//                rvAdapter.submitList(it)
//            }


            keyViewModel.keyData.observe(viewLifecycleOwner) { result ->
                if (result != null) {
                    keyViewModel.keyHotList.clear()
                    keyViewModel.keyHotList.addAll(result)
                    rvAdapter.notifyDataSetChanged()
                }

            }

            recommendViewModel.recommendData.observe(viewLifecycleOwner) { result ->

                recommendViewModel.recommendList.clear()
                for (i in 1..3) {
                    recommendViewModel.recommendList.add(result.itemList[i])
                }
                for (i in 5..7) {
                    recommendViewModel.recommendList.add(result.itemList[i])
                }

                rAdapter.notifyDataSetChanged()


                mBinding.rvRecommend.layoutManager = LinearLayoutManager(context)
                mBinding.rvRecommend.adapter = rAdapter
            }

            belowBannerViewModel.belowBannerData.observe(viewLifecycleOwner) { result ->

                    belowBannerViewModel.belowStoryList.clear()
                    for (i in 1..3) {
                        belowBannerViewModel.belowStoryList.add(result.itemList[i])
                    }
                    for (i in 5..7) {
                        belowBannerViewModel.belowStoryList.add(result.itemList[i])
                    }
//                belowBannerViewModel.belowStoryList.addAll(result.itemList)
                    belowBannerAdapter.notifyDataSetChanged()
                }
            mBinding.belowBanner.adapter = belowBannerAdapter





            belowStoryViewModel.belowStoryData.observe(viewLifecycleOwner) { result ->

                belowStoryViewModel.belowStoryList.clear()
                for (i in 1..3) {
                    belowStoryViewModel.belowStoryList.add(result.itemList[i])
                }
                for (i in 5..7) {
                    belowStoryViewModel.belowStoryList.add(result.itemList[i])
                }

                belowStoryAdapter.notifyDataSetChanged()

                url = result.nextPageUrl
                Log.d("slh", "doLogic: ${url}")
                mBinding.rvBelowStory.layoutManager = LinearLayoutManager(context)
                mBinding.rvBelowStory.adapter = belowStoryAdapter
            }

        }


        private fun doBanner() {
            mBinding.vp2.setCurrentItem(100,true)
            mBinding.vp2.setPageTransformer(MarginPageTransformer(20))
            mBinding.vp2.offscreenPageLimit = 3
            mBinding.vp2.setPageTransformer(ScaleTransformer())
            //定时器播放ViewPager
            timerTask = object : TimerTask() {
                override fun run() {
                    if (!isDown) {
                        //获取到当前的位置
                        val page = mBinding.vp2.currentItem + 1
                        activity?.runOnUiThread {
                            mBinding.vp2.currentItem = page
                        }

                    }
                }
            }

            if (!isStart){
            // 每2.5秒执行一次
            timer.schedule(timerTask, 0, 2500)
            }

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

    private fun doBelowBanner(){

        mBinding.belowBanner.setPageTransformer(ArcUpTransformer())
        mBinding.belowBanner.offscreenPageLimit = 5
        //定时器播放ViewPager
        val timerTask: TimerTask = object : TimerTask() {
            override fun run() {
                if (!isDown) {
                    //获取到当前的位置
                    val page = mBinding.belowBanner.currentItem + 1
                    activity?.runOnUiThread {
                        mBinding.belowBanner.currentItem = page
                    }

                }
            }
        }
        // 每2.5秒执行一次
        if (!isStart){
            timer.schedule(timerTask, 0, 2500)
            isStart = true
        }

        mBinding.belowBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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


    @SuppressLint("SuspiciousIndentation")
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
                        activity?.let {
                            SPUtils.getInstance(it).save(mBinding.etSearch.text.toString())
                        }
                    }
                    //点击事件
                }
                // initautoSearch();
            }
        }

    private fun initKeyHot() {
        val data = keyViewModel.keyHotList
        Log.d("slh", "initKeyHot: ${data}")
        val layoutParams =
            ViewGroup.MarginLayoutParams(
                ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                ViewGroup.MarginLayoutParams.WRAP_CONTENT
            )
        Log.d("slh", "initKeyHot:${layoutParams}")
        mBinding.rv.removeAllViews()
        Log.d("slh", "initKeyHot:${mBinding.rv}")
        for (i in 0 until data.size) {
            if (isNullorEmpty(data[i])) {
                return
            }
            //有数据就继续运行
            val paramItemView = layoutInflater.inflate(R.layout.history_view, null)
            val keyWordTv = paramItemView.findViewById<TextView>(R.id.tv_content)
            keyWordTv.text = data[i]
            mBinding.rv.addView(paramItemView, layoutParams)
            keyWordTv.setOnClickListener {
                mBinding.etSearch.setText(data[i])
                mBinding.etSearch.setSelection(data[i].length) //光标在最后
                }
                //点击事件
            }
            // initautoSearch();
        }
}
