package gf.na.chisle.nia.domain.grey

import android.content.Context

interface AppsRepository {

    suspend fun provideFlyer(contextActivity: Context, appsDevKey: String): MutableMap<String, Any?>

    suspend fun provideDIUU(contextActivity: Context): String
}