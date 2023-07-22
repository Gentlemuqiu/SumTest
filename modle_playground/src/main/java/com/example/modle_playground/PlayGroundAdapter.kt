package com.example.modle_playground

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PlayGroundAdapter(
    fragmentManager:FragmentManager?,
    lifecycle:Lifecycle?
):
  FragmentStateAdapter(
      fragmentManager!!,
      lifecycle!!
  )
{
    private val fragments: MutableList<Fragment> = ArrayList<Fragment>()

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

}