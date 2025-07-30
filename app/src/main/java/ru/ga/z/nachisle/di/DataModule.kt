package ru.ga.z.nachisle.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.ga.z.nachisle.data.AppsRepositoryImpl
import ru.ga.z.nachisle.data.FBAttrProviderImpl
import gf.na.chisle.nia.data.GaidRepositoryImpl
import ru.ga.z.nachisle.data.InstallReferrerImpl
import ru.ga.z.nachisle.data.RemoteConfigRepoImpl
import gf.na.chisle.nia.domain.grey.AppsRepository
import gf.na.chisle.nia.domain.grey.FBAttrProvider
import gf.na.chisle.nia.domain.grey.GaidRepository
import gf.na.chisle.nia.domain.grey.InstallReferrer
import gf.na.chisle.nia.domain.grey.RemoteConfigRepo
import ru.ga.z.nachisle.data.DataStoreImpl
import ru.ga.z.nachisle.data.NetworkCheckerRepositoryImpl
import ru.ga.z.nachisle.data.PostErrorRepositoryImpl
import ru.ga.z.nachisle.data.PushServiceInitializerImpl
import ru.ga.z.nachisle.domain.grey.DataStore
import ru.ga.z.nachisle.domain.grey.NetworkCheckerRepository
import ru.ga.z.nachisle.domain.grey.PostErrorRepository
import ru.ga.z.nachisle.domain.grey.PushServiceInitializer
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