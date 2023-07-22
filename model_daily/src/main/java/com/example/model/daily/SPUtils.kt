package com.example.model.daily

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/19 19:53
 */
import android.content.Context
import android.content.SharedPreferences
class SPUtils private constructor() {
    fun put(key: String?, value: Any?) {
        if (value is Int) {
            sp!!.edit().putInt(key, (value as Int?)!!).apply()
        } else if (value is String) {
            sp!!.edit().putString(key, value as String?).apply()
        } else if (value is Boolean) {
            sp!!.edit().putBoolean(key, (value as Boolean?)!!).apply()
        } else if (value is Float) {
            sp!!.edit().putFloat(key, (value as Float?)!!).apply()
        } else if (value is Long) {
            sp!!.edit().putLong(key, (value as Long?)!!).apply()
        }
    }

    fun save(keyword: String) {
        // 获取搜索框信息
        val mysp = mContext!!.getSharedPreferences("search_history", 0)
        val old_text = mysp.getString("history", "")
        // 利用StringBuilder.append新增内容，逗号便于读取内容时用逗号拆分开
        val builder = StringBuilder(old_text)
        builder.append("$keyword,")

        // 判断搜索内容是否已经存在于历史文件，已存在则不重复添加
        if (!old_text!!.contains("$keyword,")) {
            val myeditor = mysp.edit()
            myeditor.putString("history", builder.toString())
            myeditor.commit()
        }
    }

    // 获取搜索记录文件内容
    val historyList:
    // 用逗号分割内容返回数组
    // 保留前50条数据
            Array<String>
        get() {
            // 获取搜索记录文件内容
            val sp = mContext!!.getSharedPreferences("search_history", 0)
            val history = sp.getString("history", "")
            // 用逗号分割内容返回数组
            val history_arr =
                history!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            // 保留前50条数据
            if (history_arr.size > 50) {
                val newArrays = arrayOfNulls<String>(50)
                System.arraycopy(history_arr, 0, newArrays, 0, 50)
            }
            return history_arr
        }

    /**
     * 清除搜索记录
     */
    fun cleanHistory() {
        val sp = mContext!!.getSharedPreferences("search_history", 0)
        val editor = sp.edit()
        editor.clear()
        editor.commit()
    }

    companion object {
        private const val spName = "chat"
        private val instance = SPUtils()
        var mContext: Context? = null
        private var sp: SharedPreferences? = null
        @JvmStatic
        fun getInstance(context: Context): SPUtils {
            mContext = context
            if (sp == null) {
                sp = context.applicationContext.getSharedPreferences(spName, Context.MODE_PRIVATE)
            }
            return instance
        }
    }
}