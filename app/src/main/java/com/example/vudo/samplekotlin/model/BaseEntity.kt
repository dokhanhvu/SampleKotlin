package com.example.vudo.samplekotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by vu.do on 4/17/2018.
 */
data class BaseEntity<out T>(@Expose
                         @SerializedName("err_code")
                         val errorCode : String,

                         @Expose
                         @SerializedName("err_msg")
                         val errorMsg : String,

                         @Expose
                         @SerializedName("data")
                         val data : T)