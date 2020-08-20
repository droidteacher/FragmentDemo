package hu.prooktatas.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_TAB_INDEX = "param1"

class TabContentFragment : Fragment() {

    private var tabIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabIndex = it.getInt(ARG_TAB_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tab_content, container, false)

        val tv = rootView.findViewById<TextView>(R.id.tvTabIndex)
        tv.text = "TAB CONTENT ${tabIndex}"

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            TabContentFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TAB_INDEX, param1)
                }
            }
    }
}