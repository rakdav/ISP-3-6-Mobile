package com.example.autocompletetextviewapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.autocompletetextviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var cities = arrayOf("Москва", "Самара", "Вологда", "Волгоград", "Саратов", "Воронеж")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Получаем ссылку на элемент AutoCompleteTextView в разметке
        val autoCompleteTextView =binding.autocomplete
        // Создаем адаптер для автозаполнения элемента AutoCompleteTextView
        val adapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, cities)
        autoCompleteTextView.setAdapter(adapter)
    }
}