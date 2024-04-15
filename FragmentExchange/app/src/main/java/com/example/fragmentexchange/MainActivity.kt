package com.example.fragmentexchange

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentexchange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ListFragment.OnFragmentSendDataListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSendData(data: String) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment?
        if (fragment != null && fragment.isVisible) fragment.setSelectedItem(data) else {
            val intent = Intent(
                applicationContext,
                DetailActivity::class.java
            )
            intent.putExtra(DetailActivity.SELECTED_ITEM, data)
            startActivity(intent)
        }
    }
}