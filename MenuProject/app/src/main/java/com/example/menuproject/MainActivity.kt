package com.example.menuproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.menuproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val headerView = binding.selectedMenuItem
        when (id) {
            R.id.action_settings -> {
                headerView.text = "Настройки"
                return true
            }
            R.id.open_settings -> {
                headerView.text = "Открыть"
                return true
            }
            R.id.save_settings -> {
                headerView.text = "Сохранить"
                return true
            }
        }
        //headerView.text = item.title;
        return super.onOptionsItemSelected(item)
    }
}