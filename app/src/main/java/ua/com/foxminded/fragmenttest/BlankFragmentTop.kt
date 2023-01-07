package ua.com.foxminded.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ua.com.foxminded.fragmenttest.databinding.FragmentBlankTopBinding


class BlankFragmentTop : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlankTopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBlankTopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragmentTop.observe(activity as LifecycleOwner) {
            binding.tvMessage.text = it
        }
        binding.btSendMessageFragmentBottom.setOnClickListener {
            dataModel.messageForFragmentBottom.value = "Hello from fragment top"
        }
        binding.btSendMessageToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment top"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragmentTop()
    }
}