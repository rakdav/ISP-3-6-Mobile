package com.example.lab2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Student(@PrimaryKey val id:UUID=UUID.randomUUID(),
    var fio:String="",var group:String="",var year:Int,
    var phys:Int,var mathem:Int,var info:Int)