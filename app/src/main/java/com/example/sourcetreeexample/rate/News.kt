package com.example.sourcetreeexample.rate


import com.google.gson.annotations.SerializedName

data class News(
                @SerializedName("name_ru") val name_ru:String,
                @SerializedName("html_ru") var html_ru:String,
                @SerializedName("img") val img:String,
                @SerializedName("start_date") val start_date:String,){

    override fun toString(): String {
        return "Tag='$name_ru', text='$html_ru', image='$img', data='$start_date'"
    }
}