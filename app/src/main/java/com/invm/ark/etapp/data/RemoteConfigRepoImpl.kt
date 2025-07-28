package com.invm.ark.etapp.data

import android.content.Context
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import gf.na.chisle.nia.domain.grey.RemoteConfigRepo
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RemoteConfigRepoImpl @Inject constructor() : RemoteConfigRepo {

    override suspend fun takeDataFromADistantStorage(context: Context): Map<String, String> =
        suspendCoroutine { cont ->

            val unrealRemote = Firebase.remoteConfig

            unrealRemote.fetchAndActivate()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val zuckerbergID = unrealRemote.getString(ZUCKERBERGID)
                        val zuckerbergAccessToken = unrealRemote.getString(ZUCKERBERGACCESSTOKEN)
                        val appsAttrDevKey = unrealRemote.getString(APPSATTRDEVKEY)
                        val domain = unrealRemote.getString(DOMAIN)

                        val mutableMapWithDataFromRemoteConfig = mutableMapOf<String, String>()
                        mutableMapWithDataFromRemoteConfig[ZUCKERBERGID] = zuckerbergID
                        mutableMapWithDataFromRemoteConfig[ZUCKERBERGACCESSTOKEN] =
                            zuckerbergAccessToken
                        mutableMapWithDataFromRemoteConfig[APPSATTRDEVKEY] = appsAttrDevKey
                        mutableMapWithDataFromRemoteConfig[DOMAIN] = domain

                        Log.v("123123", "$mutableMapWithDataFromRemoteConfig")
                        cont.resume(mutableMapWithDataFromRemoteConfig)
                    } else {
                        cont.resume(emptyMap())
                    }
                }
        }

    companion object {
        const val ZUCKERBERGID = "invest_fb_id"
        const val ZUCKERBERGACCESSTOKEN = "invest_fb_token"
        const val APPSATTRDEVKEY = "invest_fb_appsfly"
        const val DOMAIN = "deferred_link"
    }
}