package ua.com.foxminded.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ua.com.foxminded.fragmenttest.databinding.FragmentBlankBottomBinding


class BlankFragmentBottom : Fragment() {
    lateinit var binding: FragmentBlankBottomBinding
    private val dataModel:DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBottomBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragmentBottom.observe(activity as LifecycleOwner) {
            binding.tvMessage.text = it
        }
        binding.btSendMessageFragmentTop.setOnClickListener {
            dataModel.messageForFragmentTop.value = "Hello from fragment bottom"
        }
        binding.btSendMessageToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment bottom"
        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = BlankFragmentBottom()
    }
}