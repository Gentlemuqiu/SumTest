package com.example.model.search

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.model.search.SPUtils.Companion.getInstance
import com.example.model.searh.R
import com.example.model.searh.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val mBinding: FragmentSearchBinding by lazy{
        FragmentSearchBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        initHistory()
        mBinding.etSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val searchKey = mBinding.etSearch.text.toString()
                if (!isNullorEmpty(searchKey)) {
                    val keyWord = mBinding.etSearch.text.toString()
                    if (!isNullorEmpty(keyWord)) {
                        activity?.let { getInstance(it).save(mBinding.etSearch.getText().toString()) }
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

    private fun isNullorEmpty(str: String?): Boolean {
        return str == null || "" == str
    }

    //初始化历史列表
    private fun initHistory() {
        val data = activity!!.let { SPUtils.getInstance(it).historyList }
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