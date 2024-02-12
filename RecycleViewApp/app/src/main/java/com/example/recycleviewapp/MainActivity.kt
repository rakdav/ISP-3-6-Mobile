package com.example.recycleviewapp


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewapp.databinding.ActivityMainBinding
import com.example.recycleviewapp.StateAdapter.OnStateClickListener


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var states = ArrayList<State>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.list
        setInitialData()
        val stateClickListener: OnStateClickListener = object : OnStateClickListener {
            override fun onStateClick(state: State?, position: Int) {
                Toast.makeText(
                    applicationContext, "Был выбран пункт " + state!!.name,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
// создаем адаптер
        val adapter = StateAdapter(this,R.layout.list_item,states,stateClickListener)
// устанавливаем для списка адаптер
        recyclerView.adapter = adapter
    }
    private fun setInitialData() {
        states.add(State("Албания", "Тирана", R.drawable.albania))
        states.add(State("Аджир", "Аджир", R.drawable.algeria))
        states.add(State("Австрия", "Вена", R.drawable.austria))
        states.add(State("Азербайджан", "Баку", R.drawable.azer))
        states.add(State("Албания", "Тирана", R.drawable.albania))
        states.add(State("Аджир", "Аджир", R.drawable.algeria))
        states.add(State("Австрия", "Вена", R.drawable.austria))
        states.add(State("Азербайджан", "Баку", R.drawable.azer))
        states.add(State("Албания", "Тирана", R.drawable.albania))
        states.add(State("Аджир", "Аджир", R.drawable.algeria))
        states.add(State("Австрия", "Вена", R.drawable.austria))
        states.add(State("Азербайджан", "Баку", R.drawable.azer))
        states.add(State("Албания", "Тирана", R.drawable.albania))
        states.add(State("Аджир", "Аджир", R.drawable.algeria))
        states.add(State("Австрия", "Вена", R.drawable.austria))
        states.add(State("Азербайджан", "Баку", R.drawable.azer))
    }
}