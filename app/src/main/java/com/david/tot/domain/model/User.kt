package com.david.tot.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id") val local_id: Int = 0,
    @ColumnInfo(name = "remote_id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "password") val password: String
    )
fun User.toDomain() = User(local_id,id,name,password)
//fun User.toDatabase() = Product(local_id=local_id, id=id, name=name, image=image, description = description, price = price, requested_amount = requested_amount, is_milligram = is_milligram, is_unit = is_unit)