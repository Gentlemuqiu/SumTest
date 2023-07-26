package com.example.model.photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.model.photo.Adapter.PhotoAdapter
import com.example.model.photo.databinding.ActivityPhotoBinding

@Route(path = "/photo/PhotoActivity/")
class PhotoActivity : AppCompatActivity() {
    private val mBinding: ActivityPhotoBinding by lazy {
        ActivityPhotoBinding.inflate(layoutInflater)
    }

    private lateinit var  adapter: PhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val list = intent.getStringArrayListExtra("list")
        list as List<String>
        adapter= PhotoAdapter(list)
        mBinding.vpPhoto.adapter=adapter
    }
}