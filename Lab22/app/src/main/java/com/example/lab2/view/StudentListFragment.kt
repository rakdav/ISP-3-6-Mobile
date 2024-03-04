package com.example.lab2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.databinding.FragmentStudentListBinding
import com.example.lab2.databinding.ListItemStudentBinding
import com.example.lab2.model.Student
import com.example.lab2.viewmodel.StudentListViewModel

private const val TAG="StudentListFragment"
class StudentListFragment:Fragment(R.layout.fragment_student_list) {
    private lateinit var binding: FragmentStudentListBinding
    private lateinit var adapter: StudentAdapter
    private val studentListViewModel:StudentListViewModel by lazy {
        ViewModelProvider(this)[StudentListViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"${studentListViewModel.students.size}")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentStudentListBinding.inflate(layoutInflater,
            container,false)
        binding.studentRecycleView.layoutManager=LinearLayoutManager(context)
        val students=studentListViewModel.students
        adapter=StudentAdapter(students)
        binding.studentRecycleView.adapter=adapter
        return binding.root
    }

    companion object{
        fun newInstance():StudentListFragment{
            return StudentListFragment()
        }
    }
    private inner class StudentAdapter(var students:List<Student>):
        RecyclerView.Adapter<StudentAdapter.StudentHolder>()
    {
        private inner class StudentHolder(view: View):RecyclerView.ViewHolder(view),
        View.OnClickListener{
            private lateinit var student:Student
            init {
                itemView.setOnClickListener(this)
            }
            val bindingHolder=view.let{ListItemStudentBinding.bind(it)}
            val fioView=bindingHolder.tvFio
            val groupView=bindingHolder.tvGroup
            val yearView=bindingHolder.tvYear

            fun bind(student:Student){
                this.student=student
                fioView.text=student.fio
                groupView.text=student.group
                yearView.text=student.year.toString()
            }
            override fun onClick(v: View?) {
                Toast.makeText(context, student.fio,Toast.LENGTH_SHORT).show()
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
            val view=layoutInflater.inflate(R.layout.list_item_student,parent,false)
            return StudentHolder(view)
        }

        override fun getItemCount()=students.size

        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            val student=students[position]
            holder.bind(student)
        }
    }
}