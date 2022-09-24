package com.abdallah.ehab.newyorktimesnews.utils

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@BindingAdapter("isVisible")
fun View.isVisible(visible:Boolean){
    if (visible)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}



@BindingAdapter("imageUrl")
fun ImageView.bindImage( imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        this.load(imgUri)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("fromStringDate")
fun TextView.fromStringDate(dateString: String?) {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val date = LocalDate.parse(dateString, formatter)
    this.text = date.toString()

}