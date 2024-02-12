package com.example.gridviewapp

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gridviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var countries = arrayOf("Бразилия", "Аргентина", "Чили", "Колумбия", "Уругвай")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // получаем элемент GridView
        val countriesList = binding.gridview
        // создаем адаптер
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries)
        countriesList.adapter = adapter
        val itemListener =
            OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    applicationContext, "Вы выбрали "
                            + parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        countriesList.onItemClickListener = itemListener
    }
}