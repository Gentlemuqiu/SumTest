package com.example.model.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.play.Adapter.TopAdapter
import com.example.model.play.ViewModel.RelatedViewModel
import com.example.model.play.databinding.ActivityPlayBinding
import xyz.doikki.videocontroller.StandardVideoController
import xyz.doikki.videocontroller.component.CompleteView
import xyz.doikki.videocontroller.component.ErrorView
import xyz.doikki.videocontroller.component.GestureView
import xyz.doikki.videocontroller.component.VodControlView
import xyz.doikki.videoplayer.player.VideoView

@Route(path = "/play/PlayActivity/")
class PlayActivity : AppCompatActivity() {
    private val mBinding: ActivityPlayBinding by lazy {
        ActivityPlayBinding.inflate(layoutInflater)
    }
    private val relatedViewModel by lazy { ViewModelProvider(this)[RelatedViewModel::class.java] }

    private lateinit var topAdapter: TopAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initWindow()
        val playUrl = intent.getStringExtra("playUrl")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val category = intent.getStringExtra("category")
        val shareCount = intent.getIntExtra("shareCount", 0)
        val likeCount = intent.getIntExtra("likeCount", 0)
        val commentCount = intent.getIntExtra("commentCount", 0)
        val id = intent.getIntExtra("id", 0)
        mBinding.apply {
            tvPlayTitle.text = title
            tvPlayDescription.text = description
            tvPlayCategory.text = category
            tvPlayShare.text = shareCount.toString()
            tvPlayLike.text = likeCount.toString()
            tvPlayComment.text = commentCount.toString()
            loser.requestFocus()
        }
        relatedViewModel.getRelated(id)
        topAdapter = TopAdapter()
        relatedViewModel.relatedData.observe(this) {
            val list=it.itemList.filter { element ->
                element.type=="videoSmallCard"
            }
            topAdapter.submitList(list)
        }
        mBinding.rvPlay.layoutManager = LinearLayoutManager(this)
        mBinding.rvPlay.adapter = topAdapter
        initPlayer(playUrl!!)
    }

    private fun initWindow() {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.black)
    }

    private fun initPlayer(url: String) {
        val controller = StandardVideoController(this)
        controller.addDefaultControlComponent("标题", false)
        controller.setEnableOrientation(false)
        controller.addControlComponent(CompleteView(this)) //自动完成播放界面
        controller.addControlComponent(ErrorView(this)) //错误界面
        controller.addControlComponent(GestureView(this))//滑动控制视图
        controller.addControlComponent(VodControlView(this))
        mBinding.player.setVideoController(controller) //设置控制器
        mBinding.player.setScreenScaleType(VideoView.SCREEN_SCALE_16_9)
        mBinding.player.setUrl(url) //设置视频地址
        mBinding.player.release()
        mBinding.player.start() //开始播放，不调用则不自动播放
    }

    override fun onPause() {
        super.onPause()
        mBinding.player.pause()
    }

    override fun onResume() {
        super.onResume()
        mBinding.player.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding.player.release()
    }


    override fun onBackPressed() {
        if (!mBinding.player.onBackPressed()) {
            super.onBackPressed()
        }
    }
}