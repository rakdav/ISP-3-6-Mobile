package com.example.arrayadaptersproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.arrayadaptersproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    //var countries = arrayOf("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var countriesList=binding.countriesList
        var countries=resources.getStringArray(R.array.countries)
        val adapter:ArrayAdapter<String?> = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice,countries)
        countriesList.adapter=adapter
        countriesList.setOnItemClickListener { parent, view, position, id ->
//            var selected=countries[position]
//            Toast.makeText(applicationContext,selected,Toast.LENGTH_SHORT).show()
            val selected = countriesList.checkedItemPositions
            var selectedItems = ""
            for (i in countries.indices) {
                if (selected[i]) selectedItems += countries[i] + ","
            }
            Toast.makeText(applicationContext,selectedItems,Toast.LENGTH_SHORT).show()
        }
    }
}