package com.example.model.introduce

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.introduce.Adapter.RelatedIntroduceAdapter
import com.example.model.introduce.ViewModel.IntroduceViewModel
import com.example.model.introduce.ViewModel.NewCateGoryViewModel
import com.example.model.introduce.databinding.ActivityIntroduceBinding

@Route(path = "/introduce/IntroduceActivity/")
class IntroduceActivity : AppCompatActivity() {
    private val mBinding: ActivityIntroduceBinding by lazy {
        ActivityIntroduceBinding.inflate(layoutInflater)
    }
    private val introduceViewModel by lazy {
        ViewModelProvider(this)[IntroduceViewModel::class.java]
    }

    private val newCategoryViewModel by lazy {
        ViewModelProvider(this)[NewCateGoryViewModel::class.java]
    }
    private lateinit var adapter: RelatedIntroduceAdapter

    private var data: MutableList<RelatedCategory.Item> = mutableListOf()

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(com.example.model.play.R.color.black)
        val description = intent.getStringExtra("description")
        val id = intent.getIntExtra("id", 0)
        introduceViewModel.getRelatedCategoryData(id)
        mBinding.run {
            tlToolBar.title = description
            tlToolBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
            setSupportActionBar(tlToolBar)
        }
        mBinding.tlToolBar.setNavigationOnClickListener {
            finish()
        }
        adapter = RelatedIntroduceAdapter(this)
        introduceViewModel.relatedCategoryData.observe(this) {
            val list = it.itemList.filter { element ->
                element.data.content.data.author != null
            }
            data.addAll(list)
            adapter.submitList(data)
            url = it.nextPageUrl
        }
        mBinding.rvIntroduce.adapter = adapter
        mBinding.rvIntroduce.layoutManager = LinearLayoutManager(this)

    }

    fun doLoad(url: String) {
        newCategoryViewModel.getNewCateGory(url)
        newCategoryViewModel.newCateGoryData.observe(this) {
            //修复重复添加元素而出现的bug
            for (newItem in it.itemList) {
                var exists = false
                for (existingItem in data) {
                    if (existingItem.data.header.id === newItem.data.header.id) {
                        exists = true
                        break
                    }
                }
                if (!exists) {
                    data.add(newItem)
                }
            }
            adapter.submitList(data)
            adapter.notifyItemRangeChanged(0, data.size)
            this.url = it.nextPageUrl
        }
    }
}
