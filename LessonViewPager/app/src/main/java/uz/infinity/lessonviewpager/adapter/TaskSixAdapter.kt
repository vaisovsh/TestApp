package uz.infinity.lessonviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.infinity.lessonviewpager.page.FirstPage
import uz.infinity.lessonviewpager.page.SecondPage
import uz.infinity.lessonviewpager.page.ThirdPage

class TaskSixAdapter(fmActivity: FragmentActivity) : FragmentStateAdapter(fmActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstPage()
            1 -> SecondPage()
            else -> ThirdPage()
        }
    }
}