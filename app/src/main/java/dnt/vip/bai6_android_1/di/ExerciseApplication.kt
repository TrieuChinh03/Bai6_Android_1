package dnt.vip.bai6_android_1.di

import android.app.Application

class ExerciseApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
