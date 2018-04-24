package com.example.vudo.samplekotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by vu.do on 4/17/2018.
 */
data class Coupon(@Expose
                  @SerializedName("id")
                  val id : Long,

                  @Expose
                  @SerializedName("name")
                  val name : String,

                  @Expose
                  @SerializedName("content")
                  val content : String,

                  @Expose
                  @SerializedName("detail")
                  val detail : String,

                  @Expose
                  @SerializedName("category")
                  val category : String,

                  @Expose
                  @SerializedName("is_hot")
                  val is_hot : Boolean,

                  @Expose
                  @SerializedName("cover")
                  val cover : String,

                  @Expose
                  @SerializedName("shop_id")
                  val shopId : Long,

                  @Expose
                  @SerializedName("shop_name")
                  val shopName : String,

                  @Expose
                  @SerializedName("start_date")
                  val startDate : String,

                  @Expose
                  @SerializedName("end_date")
                  val endDate : String,

                  @Expose
                  @SerializedName("deal")
                  val deal : Double) : Serializable