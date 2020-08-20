package hu.prooktatas.fragmentdemo

import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class TabHostingActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_hosting)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        viewPager.adapter = TabContentAdapter(
            arrayOf(getString(R.string.developers), getString(R.string.languages), getString(R.string.jobs)),
            supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }


}

class TabContentAdapter(private val titles: Array<String>, mgr: FragmentManager): FragmentStatePagerAdapter(mgr) {
    override fun getItem(position: Int): Fragment {
        return TabContentFragment.newInstance(position + 1)
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}


