package com.example.addremlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.addremlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var users = ArrayList<String>()
    var selectedUsers = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    var userList: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userList=binding.usersList
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, users)
        userList!!.setAdapter(adapter);
        userList!!.setOnItemClickListener { parent, view, position, id ->
            val user = adapter!!.getItem(position)
            if (userList!!.isItemChecked(position))
                selectedUsers.add(user!!) else selectedUsers.remove(user)
        }
        var add=binding.add
        add.setOnClickListener {
            add()
        }
        var remove=binding.remove
        remove.setOnClickListener {
            remove()
        }
    }
    fun add() {
        val userName = binding.userName
        val user = userName.text.toString()
        if (!user.isEmpty()) {
            adapter!!.add(user)
            userName.setText("")
            adapter!!.notifyDataSetChanged()
        }
    }
    fun remove() {
        for (i in selectedUsers.indices) {
            adapter!!.remove(selectedUsers[i])
        }
        userList?.clearChoices()
        selectedUsers.clear()
        adapter!!.notifyDataSetChanged()
    }
}