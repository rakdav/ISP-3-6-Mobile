package com.example.lab2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab2.StudentRepository
import com.example.lab2.model.Student
import java.util.UUID

class StudentListViewModel:ViewModel() {
    private val studentRepository=StudentRepository.get();
    val studentListLiveData=studentRepository.getStudents()
    fun Load(){
        studentRepository.insertStudent(Student(
            UUID.randomUUID(),"Ivanov","20-isp-1",
            2008,4,3,5))
    }
}