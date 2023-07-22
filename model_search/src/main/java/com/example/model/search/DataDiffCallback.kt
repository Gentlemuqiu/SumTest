package com.example.model.search

import androidx.recyclerview.widget.DiffUtil
import com.example.model.search.Bean.Follow

class DataDiffCallback(private val oldList: List<Follow.Item>, private val newList: List<Follow.Item>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // 判断两个数据项是否代表同一个对象
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // 判断两个数据项的内容是否相同
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
