package com.example.firstviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.firstviewmodel.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private var currentValue=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.button.setOnClickListener {
//            var runnable: Runnable = Runnable {
//                for (currentValue in 1..100) {
//                    try {
//                        binding.textView.post(Runnable {
//                            binding.progressBar.progress = currentValue
//                            binding.textView.text = "Status " + currentValue.toString()
//                        })
//                        Thread.sleep(400)
//                    } catch (e: InterruptedException) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//                val thread: Thread = Thread(runnable)
//                thread.start()
//            }
        var model:MyViewMode= ViewModelProvider(this)[MyViewMode::class.java]
        model.getValue()?.observe(this) {
            binding.progressBar.progress = it
            binding.textView.text = "Status:" + it
        }
        binding.button.setOnClickListener { model.execute() }
    }
}

