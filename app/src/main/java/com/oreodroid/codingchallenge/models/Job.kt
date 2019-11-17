package com.oreodroid.codingchallenge.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "job_table")
data class Job (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val  id: Int,
                @ColumnInfo(name = "customer_name") val customerName: String,
                @ColumnInfo(name = "distance") val distance: Double,
                @ColumnInfo(name = "job_date") val jobDate: String,
                @ColumnInfo(name = "extras") val extras: String,
                @ColumnInfo(name = "order_duration") val orderDuration: Double,
                @ColumnInfo(name = "order_id") val orderId: String,
                @ColumnInfo(name = "order_time") val orderTime: String,
                @ColumnInfo(name = "payment_method") val paymentMethod: String,
                @ColumnInfo(name = "price") val price: Double,
                @ColumnInfo(name = "recurrency") val recurrency: Int,
                @ColumnInfo(name = "job_city") val jobCity: String,
                @ColumnInfo(name = "job_latitude") val jobLatitude: Double,
                @ColumnInfo(name = "job_longitude") val jobLongitude: Double,
                @ColumnInfo(name = "job_postal_code") val jobPostalCode: Int,
                @ColumnInfo(name = "job_street") val jobStreet: String,
                @ColumnInfo(name = "status") val status: String )