package hu.prooktatas.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), ClickHandler {

    private lateinit var clickFragment: ClickFragment
    private lateinit var resultFragment: ResultFragment

    private var currentValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickFragment = supportFragmentManager.findFragmentById(R.id.clickFragment) as ClickFragment
//        clickFragment.handler = this
        resultFragment = supportFragmentManager.findFragmentById(R.id.resultFragment) as ResultFragment
    }

    override fun buttonClicked() {
        currentValue++
        resultFragment.updateResult(currentValue)
    }
}


const val TAG = "KZs"