package com.example.lab2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Student(@PrimaryKey val id:UUID=UUID.randomUUID(),
                   val name:String,val group:String,
    val birthYear:Int,val phis:Int,val math:Int,val inf:Int)