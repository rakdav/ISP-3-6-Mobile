package com.example.lab2.database

import androidx.room.Dao
import androidx.room.Query
import com.example.lab2.model.Student
import java.util.UUID

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student")
    fun getStudents():List<Student>
    @Query("SELECT * FROM Student WHERE id=(:id)")
    fun getStudent(id:UUID):Student?
}