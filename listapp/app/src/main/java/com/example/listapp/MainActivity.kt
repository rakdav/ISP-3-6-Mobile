package com.example.listapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val products = ArrayList<Product>()
        products.add(Product("Картофель", "кг."))
        products.add(Product("Чай", "шт."))
        products.add(Product("Яйца", "шт."))
        products.add(Product("Молоко", "л."))
        products.add(Product("Макароны", "кг."))
        val productList = binding.productList
        val adapter = ProductAdapter(this, R.layout.list_item, products)
        productList.adapter = adapter
    }
}