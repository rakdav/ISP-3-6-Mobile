package com.example.firstvvewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.firstvvewmodel.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var model=ViewModelProvider(this)[MyViewModel::class.java]
        model.getValue()?.observe(this){
            binding.progressBar.progress=it
            binding.textView.text="Status:${it}"
        }
        binding.button.setOnClickListener {
            model.execute()
//            val runnable= Runnable {
//                val cal=Calendar.getInstance();
//                val hour=cal.get(Calendar.HOUR_OF_DAY)
//                val minute=cal.get(Calendar.MINUTE)
//                val second=cal.get(Calendar.SECOND)
//                val str="${hour}:${minute}:${second}"
//                binding.textView.post(Runnable {
//                    binding.textView.text=str
//                })
//            }
//            val thread=Thread(runnable)
//            thread.start()
//            val runnable= Runnable {
//                for (currentValue in 1 ..100){
//                    try
//                    {
//                        binding.textView.post(Runnable {
//                            binding.progressBar.progress=currentValue
//                            binding.textView.text="Status:${currentValue}"
//                        })
//                        Thread.sleep(400);
//                    }
//                    catch (ex:InterruptedException){
//                        ex.printStackTrace()
//                    }
//                }
//            }
//            val thread=Thread(runnable)
//            thread.start()
        }
    }
}