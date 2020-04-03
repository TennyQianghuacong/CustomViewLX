package com.qiang.customviewlx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author qhc
 * @time 2020/3/31
 */
class MainActivity : AppCompatActivity() {

    private lateinit var fragments: List<Fragment>
    private lateinit var titles: List<String>
  //  private var viewPager: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViewPager()
    }

    private fun initViewPager() {
        fragments = generateFragments();
        titles = generateTitles();

        view_pager.apply {
            adapter = object : FragmentStateAdapter(this@MainActivity) {
                override fun getItemCount(): Int = fragments.size

                override fun createFragment(position: Int): Fragment = fragments[position]


            }
            this.setPageTransformer { page, position ->
                page.apply {
                    rotation = position * 360
                }
            }
        }

        TabLayoutMediator(tab_layout, view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position -> tab.text = titles[position] }).attach()
    }

    private fun generateFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>()

        fragments.add(ExampleFragment.newInstance(R.layout.fragment_color_view))
        fragments.add(ExampleFragment.newInstance(R.layout.fragment_circle_view))

        return fragments
    }

    private fun generateTitles(): List<String> {
        val titles = ArrayList<String>()

        titles.add("ColorView")
        titles.add("CircleView")

        return titles
    }

}