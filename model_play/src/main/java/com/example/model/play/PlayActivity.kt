package com.example.model.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.modle.play.R
import com.example.modle.play.databinding.ActivityPlayBinding
import xyz.doikki.videocontroller.StandardVideoController
import xyz.doikki.videocontroller.component.CompleteView
import xyz.doikki.videocontroller.component.ErrorView
import xyz.doikki.videocontroller.component.GestureView
import xyz.doikki.videocontroller.component.VodControlView
import xyz.doikki.videoplayer.player.VideoView

class PlayActivity : AppCompatActivity() {
    private val mBinding: ActivityPlayBinding by lazy {
        ActivityPlayBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.black)
        val BASE_URL =
            "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=223296&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid="
        val controller = StandardVideoController(this)
        controller.addDefaultControlComponent("标题", false)
        controller.setEnableOrientation(false)
        controller.addControlComponent(CompleteView(this)) //自动完成播放界面
        controller.addControlComponent(ErrorView(this)) //错误界面
        controller.addControlComponent(GestureView(this))//滑动控制视图
        controller.addControlComponent(VodControlView(this))
        mBinding.player.setVideoController(controller) //设置控制器
        mBinding.player.setScreenScaleType(VideoView.SCREEN_SCALE_16_9)
        mBinding.player.setUrl(BASE_URL) //设置视频地址
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