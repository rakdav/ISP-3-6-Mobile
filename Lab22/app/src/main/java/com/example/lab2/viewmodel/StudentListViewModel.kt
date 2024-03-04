package com.example.lab2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab2.model.Student

class StudentListViewModel:ViewModel() {
    var students = mutableListOf<Student>()
    init {
        students.add(Student("Коваленко","22-ИСП-3/2",1793,45,68,45))
        students.add(Student("Зиновьев","22-ИСП-3/2",1242,2,1,80))
        students.add(Student("АндрюшкинStudio","22-ИСП-3/2",1983,67,79,90))
    }
}