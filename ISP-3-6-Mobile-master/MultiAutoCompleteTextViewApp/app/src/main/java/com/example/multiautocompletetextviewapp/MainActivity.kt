package com.example.multiautocompletetextviewapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView.CommaTokenizer
import androidx.appcompat.app.AppCompatActivity
import com.example.multiautocompletetextviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var cities = arrayOf("Москва", "Самара", "Вологда", "Волгоград", "Саратов", "Воронеж")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Получаем ссылку на элемент AutoCompleteTextView в разметке
        val autoCompleteTextView = binding.autocomplete
        // Создаем адаптер для автозаполнения элемента MultiAutoCompleteTextView
        val adapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cities)
        autoCompleteTextView.setAdapter(adapter)
        // установка запятой в качестве разделителя
        autoCompleteTextView.setTokenizer(CommaTokenizer())
    }
}