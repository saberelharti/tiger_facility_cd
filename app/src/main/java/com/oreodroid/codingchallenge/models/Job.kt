package com.oreodroid.codingchallenge.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
@Entity(tableName = "job_table")
data class Job(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @Expose
    @SerializedName("customer_name")
    @ColumnInfo(name = "customer_name")
    val customerName: String,

    @Expose
    @SerializedName("distance")
    @ColumnInfo(name = "distance")
    val distance: String,

    @Expose
    @SerializedName("job_date")
    @ColumnInfo(name = "job_date")
    val jobDate: String,

    @Expose
    @SerializedName("extras")
    @ColumnInfo(name = "extras")
    val extras: String,

    @Expose
    @SerializedName("order_duration")
    @ColumnInfo(name = "order_duration")
    val orderDuration: String,

    @Expose
    @SerializedName("order_id")
    @ColumnInfo(name = "order_id")
    val orderId: String,

    @Expose
    @SerializedName("order_time")
    @ColumnInfo(name = "order_time")
    val orderTime: String,

    @Expose
    @SerializedName("payment_method")
    @ColumnInfo(name = "payment_method")
    val paymentMethod: String,

    @Expose
    @SerializedName("price")
    @ColumnInfo(name = "price")
    val price: String,

    @Expose
    @SerializedName("recurrency")
    @ColumnInfo(name = "recurrency")
    val recurrency: Int,

    @Expose
    @SerializedName("job_city")
    @ColumnInfo(name = "job_city")
    val jobCity: String,

    @Expose
    @SerializedName("job_latitude")
    @ColumnInfo(name = "job_latitude")
    val jobLatitude: String,

    @Expose
    @SerializedName("job_longitude")
    @ColumnInfo(name = "job_longitude")
    val jobLongitude: String,

    @Expose
    @SerializedName("job_postalcode")
    @ColumnInfo(name = "job_postal_code")
    val jobPostalCode: Int,

    @Expose
    @SerializedName("job_street")
    @ColumnInfo(name = "job_street")
    val jobStreet: String,

    @Expose
    @SerializedName("status")
    @ColumnInfo(name = "status")
    val status: String
) : Parcelable