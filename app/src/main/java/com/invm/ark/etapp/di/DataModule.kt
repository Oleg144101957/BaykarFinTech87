package com.invm.ark.etapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.invm.ark.etapp.data.AppsRepositoryImpl
import com.invm.ark.etapp.data.FBAttrProviderImpl
import gf.na.chisle.nia.data.GaidRepositoryImpl
import com.invm.ark.etapp.data.InstallReferrerImpl
import com.invm.ark.etapp.data.RemoteConfigRepoImpl
import gf.na.chisle.nia.domain.grey.AppsRepository
import gf.na.chisle.nia.domain.grey.FBAttrProvider
import gf.na.chisle.nia.domain.grey.GaidRepository
import gf.na.chisle.nia.domain.grey.InstallReferrer
import gf.na.chisle.nia.domain.grey.RemoteConfigRepo
import com.invm.ark.etapp.data.DataStoreImpl
import com.invm.ark.etapp.data.NetworkCheckerRepositoryImpl
import com.invm.ark.etapp.data.PostErrorRepositoryImpl
import com.invm.ark.etapp.data.PushServiceInitializerImpl
import com.invm.ark.etapp.domain.grey.DataStore
import com.invm.ark.etapp.domain.grey.NetworkCheckerRepository
import com.invm.ark.etapp.domain.grey.PostErrorRepository
import com.invm.ark.etapp.domain.grey.PushServiceInitializer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideNetwork(@ApplicationContext context: Context): NetworkCheckerRepository {
        return NetworkCheckerRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideUserDataStorage(@ApplicationContext context: Context): DataStore {
        return DataStoreImpl(context)
    }

    @Provides
    @Singleton
    fun provideRemote(): RemoteConfigRepo {
        return RemoteConfigRepoImpl()
    }


    @Provides
    @Singleton
    fun provideGaid(@ApplicationContext context: Context): GaidRepository {
        return GaidRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun providePostError(): PostErrorRepository {
        return PostErrorRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideApps(): AppsRepository {
        return AppsRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideFB(): FBAttrProvider {
        return FBAttrProviderImpl()
    }

    @Provides
    @Singleton
    fun provideReferrer(@ApplicationContext context: Context): InstallReferrer {
        return InstallReferrerImpl(context)
    }

    @Provides
    @Singleton
    fun providePush(): PushServiceInitializer {
        return PushServiceInitializerImpl()
    }

}