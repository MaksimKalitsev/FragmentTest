package ua.com.foxminded.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import ua.com.foxminded.fragmenttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFragment(BlankFragmentTop.newInstance(), R.id.FrameLayoutTestTop)
        startFragment(BlankFragmentBottom.newInstance(), R.id.FrameLayoutTestBottom)

        dataModel.messageForActivity.observe(this) {
            binding.textViewActivity.text = it
        }


    }

    private fun startFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder, f).commit()
    }
}