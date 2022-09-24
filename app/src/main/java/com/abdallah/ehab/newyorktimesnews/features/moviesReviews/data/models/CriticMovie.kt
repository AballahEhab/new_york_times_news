package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

data class CriticMovie  (
    val display_title : String?,
    val mpaa_rating : String?,
    val critics_pick : String?,
    val byline : String?,
    val headline : String?,
    val summary_short : String?,
    val publication_date : String?,
    val opening_date : String?,
    val date_updated : String?,
    @Expose
    val link : MovieLink?,
    @Expose
    val multimedia : MovieMultimedia?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(MovieLink::class.java.classLoader),
        parcel.readParcelable(MovieMultimedia::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(display_title)
        parcel.writeString(mpaa_rating)
        parcel.writeString(critics_pick)
        parcel.writeString(byline)
        parcel.writeString(headline)
        parcel.writeString(summary_short)
        parcel.writeString(publication_date)
        parcel.writeString(opening_date)
        parcel.writeString(date_updated)
        parcel.writeParcelable(link, flags)
        parcel.writeParcelable(multimedia, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CriticMovie> {
        override fun createFromParcel(parcel: Parcel): CriticMovie {
            return CriticMovie(parcel)
        }

        override fun newArray(size: Int): Array<CriticMovie?> {
            return arrayOfNulls(size)
        }
    }
}

data class MovieLink (
    val type:String?,
    val url:String?,
    val suggested_link_text:String?,
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(url)
        parcel.writeString(suggested_link_text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieLink> {
        override fun createFromParcel(parcel: Parcel): MovieLink {
            return MovieLink(parcel)
        }

        override fun newArray(size: Int): Array<MovieLink?> {
            return arrayOfNulls(size)
        }
    }
}

data class MovieMultimedia (
    val type:String?,
    val src:String?,
    val height:Int?,
    val width:Int?,
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(src)
        parcel.writeValue(height)
        parcel.writeValue(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieMultimedia> {
        override fun createFromParcel(parcel: Parcel): MovieMultimedia {
            return MovieMultimedia(parcel)
        }

        override fun newArray(size: Int): Array<MovieMultimedia?> {
            return arrayOfNulls(size)
        }
    }
}

