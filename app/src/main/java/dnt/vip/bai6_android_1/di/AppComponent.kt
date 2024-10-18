package dnt.vip.bai6_android_1.di

import dagger.Component
import dnt.vip.bai6_android_1.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}

