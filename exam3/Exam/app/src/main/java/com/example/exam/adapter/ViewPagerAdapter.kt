package com.example.exam.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.exam.page.Pages

class ViewPagerAdapter(FMActivity: FragmentActivity) : FragmentStateAdapter(FMActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = Pages()
        val bundle = Bundle()
        bundle.putInt("Position", position)
        fragment.arguments = bundle
        return fragment
    }

}