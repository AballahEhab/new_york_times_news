package com.abdallah.ehab.newyorktimesnews

import android.app.Application
import com.abdallah.ehab.newyorktimesnews.di.ApplicationComponent
import com.abdallah.ehab.newyorktimesnews.di.DaggerApplicationComponent


class NewYorkApplication : Application() {

    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()

}