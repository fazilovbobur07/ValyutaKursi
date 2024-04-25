package com.example.valyutakursi.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class StateAdapters(val list:ArrayList<PagerItem>, fragment: Fragment)
    : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> ValyutaListFragment()
            1-> ValyutaConverterFragment()
            else-> ValyutaListFragment()
        }
    }
}