package hu.prooktatas.fragmentdemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

interface ClickHandler {
    fun buttonClicked()
}

class ClickFragment() : Fragment() {

    private var handler:ClickHandler? = null

    private lateinit var button: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickHandler) {
            handler = context as ClickHandler
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_click, container, false)

        button = rootView.findViewById(R.id.btnIncrementer)

        button.setOnClickListener {
            handler?.buttonClicked()
        }

        return rootView
    }



}