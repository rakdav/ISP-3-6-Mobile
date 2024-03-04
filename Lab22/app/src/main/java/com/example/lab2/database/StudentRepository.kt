package com.example.lab2.database

import android.content.Context
import androidx.room.Room
import com.example.lab2.model.Student
import java.lang.IllegalStateException
import java.util.UUID

private const val DATABASE_NAME="student-database"
class StudentRepository private constructor(context:Context){
    private val database:StudentDatabase=Room.databaseBuilder(
        context.applicationContext,
        StudentDatabase::class.java,
        DATABASE_NAME
    ).build()
    private val studentDao=database.studentDao()
    fun getStudents():List<Student> = studentDao.getStudents()
    fun getStudent(id:UUID):Student?=studentDao.getStudent(id)
    companion object{
        private var INSTANCE:StudentRepository?=null
        fun initialize(context: Context){
            if(INSTANCE==null)
                INSTANCE= StudentRepository(context)
        }
        fun get():StudentRepository{
            return INSTANCE ?:throw
                IllegalStateException("StudentRepository must be " +
                        "initialized")
        }
    }
}