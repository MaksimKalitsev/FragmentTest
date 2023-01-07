package ua.com.foxminded.fragmenttest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel:ViewModel() {
    val messageForActivity:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageForFragmentTop:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageForFragmentBottom:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
}