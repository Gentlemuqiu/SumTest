package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.model.play.model.Recommend
import com.example.modle.play.databinding.ActivityPlayBinding
import com.example.model.play.viewModel.RecommendViewModel

class TestPlayActivity : AppCompatActivity() {
    private val mBinding: ActivityPlayBinding by lazy {
        ActivityPlayBinding.inflate(layoutInflater)
    }
    private val recommendViewModel by lazy { ViewModelProvider(this)[RecommendViewModel::class.java] }
    private lateinit var list: ArrayList<Recommend>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        recommendViewModel.getRecommendData()
        list = ArrayList<Recommend>()
        recommendViewModel.recommendData.observe(this, Observer {
            data->
            Log.d("nihao", "onCreate: ${data}")
        })
        mBinding.hello.setOnClickListener {
            Log.d("hui", "onCreate: ${list}")
        }
    }
}