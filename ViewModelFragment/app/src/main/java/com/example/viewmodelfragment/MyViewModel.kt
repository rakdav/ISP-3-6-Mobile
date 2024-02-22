package com.example.firstvvewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class MyViewModel:ViewModel()
{
    private var isStarted=MutableLiveData<Boolean>(false)
    private var value=MutableLiveData<Int>(0)
    fun getValue():LiveData<Int>{
        if(value==null)
            value=MutableLiveData<Int>(0)
        return value
    }
    fun execute(){
        if(!isStarted.value!!) {
            isStarted.postValue(true)
            val runnable = Runnable {
                for (i in value!!.value!!..100) {
                    try {
                        value!!.postValue(i)
                        Thread.sleep(400)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
            val thread = Thread(runnable)
            thread.start()
        }
    }
}