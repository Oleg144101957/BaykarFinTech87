package tr.ba.y.kar.fi.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tr.ba.y.kar.fi.data.AppsRepositoryImpl
import tr.ba.y.kar.fi.data.FBAttrProviderImpl
import gf.na.chisle.nia.data.GaidRepositoryImpl
import tr.ba.y.kar.fi.data.InstallReferrerImpl
import tr.ba.y.kar.fi.data.RemoteConfigRepoImpl
import gf.na.chisle.nia.domain.grey.AppsRepository
import gf.na.chisle.nia.domain.grey.FBAttrProvider
import gf.na.chisle.nia.domain.grey.GaidRepository
import gf.na.chisle.nia.domain.grey.InstallReferrer
import gf.na.chisle.nia.domain.grey.RemoteConfigRepo
import tr.ba.y.kar.fi.data.DataStoreImpl
import tr.ba.y.kar.fi.data.NetworkCheckerRepositoryImpl
import tr.ba.y.kar.fi.data.PostErrorRepositoryImpl
import tr.ba.y.kar.fi.data.PushServiceInitializerImpl
import tr.ba.y.kar.fi.domain.grey.DataStore
import tr.ba.y.kar.fi.domain.grey.NetworkCheckerRepository
import tr.ba.y.kar.fi.domain.grey.PostErrorRepository
import tr.ba.y.kar.fi.domain.grey.PushServiceInitializer
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