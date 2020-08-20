package hu.prooktatas.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val ARG_INIT_VALUE = "param1"

class ResultFragment : Fragment() {

    private lateinit var textView: TextView

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_result, container, false)
        textView = rootView.findViewById(R.id.tvResult)
        return rootView
    }

    override fun onStart() {
        super.onStart()

        val initVal = arguments?.let {
            it.getString(ARG_INIT_VALUE)?.toIntOrNull()
        } ?: 0

        updateResult(initVal)
    }

    fun updateResult(num: Int?) {
        textView.text = num.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(initValue: Int) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_INIT_VALUE, initValue)
                }
            }
    }
}