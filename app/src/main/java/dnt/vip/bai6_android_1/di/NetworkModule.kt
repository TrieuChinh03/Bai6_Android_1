package dnt.vip.bai6_android_1.di

import dagger.Module
import dagger.Provides
import dnt.vip.bai6_android_1.data.remote.api.ApiUser
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    //===   Cung cấp đối tượng Retrofit  ===
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //===   Cung cấp đối tượng ApiUserService   ===
    @Provides
    @Singleton
    fun provideApiUser(retrofit: Retrofit): ApiUser {
        return retrofit.create(ApiUser::class.java)
    }
}
