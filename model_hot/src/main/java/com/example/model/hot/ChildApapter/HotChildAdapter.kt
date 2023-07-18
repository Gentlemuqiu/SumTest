package com.example.model.hot.ChildApapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HotChildAdapter(
    fm: FragmentManager,
    private val mFragments: List<Fragment>,
    private val mTitleName: List<String>
) :
    FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mTitleName.size
    }

    //显示title
    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleName[position]
    }
}
