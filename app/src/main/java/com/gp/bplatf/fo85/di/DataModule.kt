package com.gp.bplatf.fo85.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.gp.bplatf.fo85.data.AppsRepositoryImpl
import com.gp.bplatf.fo85.data.FBAttrProviderImpl
import gf.na.chisle.nia.data.GaidRepositoryImpl
import com.gp.bplatf.fo85.data.InstallReferrerImpl
import com.gp.bplatf.fo85.data.RemoteConfigRepoImpl
import gf.na.chisle.nia.domain.grey.AppsRepository
import gf.na.chisle.nia.domain.grey.FBAttrProvider
import gf.na.chisle.nia.domain.grey.GaidRepository
import gf.na.chisle.nia.domain.grey.InstallReferrer
import gf.na.chisle.nia.domain.grey.RemoteConfigRepo
import com.gp.bplatf.fo85.data.DataStoreImpl
import com.gp.bplatf.fo85.data.NetworkCheckerRepositoryImpl
import com.gp.bplatf.fo85.data.PostErrorRepositoryImpl
import com.gp.bplatf.fo85.data.PushServiceInitializerImpl
import com.gp.bplatf.fo85.domain.grey.DataStore
import com.gp.bplatf.fo85.domain.grey.NetworkCheckerRepository
import com.gp.bplatf.fo85.domain.grey.PostErrorRepository
import com.gp.bplatf.fo85.domain.grey.PushServiceInitializer
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