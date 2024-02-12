package com.example.countryadapter

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.countryadapter.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var countries: MutableList<Country> = mutableListOf()
    var countriesList: ListView? = null
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val australia=Country("Австралия","Канбера",R.drawable.australia)
        val austia=Country("Австрия","Вена",R.drawable.austria)
        val burundi=Country("Бурунди","Бурунди",R.drawable.burundi)
        val azer=Country("Азербайджан","Баку",R.drawable.azerbaijan)
        countries.add(australia)
        countries.add(austia)
        countries.add(burundi)
        countries.add(azer)
        countriesList=binding.countriesList
        val stateAdapter = CountryAdapter(this,R.layout.country_item,countries)
        countriesList!!.adapter=stateAdapter;
        val itemListener =
            OnItemClickListener { parent, v, position, id -> // получаем выбранный пункт
                val selectedState: Country = parent.getItemAtPosition(position) as Country
                Toast.makeText(
                    applicationContext, "Был выбран пункт " + selectedState.name,
                    Toast.LENGTH_SHORT
                ).show()
            }
        countriesList!!.onItemClickListener = itemListener
    }
}