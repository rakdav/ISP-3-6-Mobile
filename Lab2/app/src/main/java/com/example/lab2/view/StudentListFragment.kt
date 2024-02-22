package com.example.lab2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.databinding.FragmentStudentListBinding
import com.example.lab2.model.Student
import com.example.lab2.viewmodel.StudentListViewModel

private const val TAG="StudentListFragment"

class StudentListFragment:Fragment(R.layout.fragment_student_list) {
    private lateinit var binding: FragmentStudentListBinding
    private val studentListViewModel:StudentListViewModel by lazy {
        ViewModelProvider(this)[StudentListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"Total students:${studentListViewModel.students.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentStudentListBinding.inflate(layoutInflater,
            container,false)
        binding.studentRecyclerView.layoutManager=LinearLayoutManager(context)
        return binding.root
    }
    private inner class StudentHolder(view:View):RecyclerView.ViewHolder(view){
        val studentNameTextView:TextView=itemView.findViewById(R.id.student_name)
        val studentGroupTextView:TextView=itemView.findViewById(R.id.student_group)
        val studentYear:TextView=itemView.findViewById(R.id.student_year)
        val markPhys:TextView=itemView.findViewById(R.id.markPhys)
        val markMath:TextView=itemView.findViewById(R.id.markMath)
        val markInfo:TextView=itemView.findViewById(R.id.markInfo)
    }
    private inner class StudentAdapter(var students:List<Student>):
                RecyclerView.Adapter<StudentHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            TODO("Not yet implemented")
        }

    }
    companion object{
        fun newInstance():StudentListFragment{
            return StudentListFragment()
        }
    }
}