package com.invm.ark.etapp.data

import android.content.Context
import com.invm.ark.etapp.domain.grey.PushServiceInitializer
import com.onesignal.OneSignal
import javax.inject.Inject

class PushServiceInitializerImpl @Inject constructor() :
    PushServiceInitializer {

    override fun initializePushService(advertID: String, context: Context) {
        OneSignal.initWithContext(context, ONE_SIGNAL_DEV_KEY)
        OneSignal.login(advertID)
        OneSignal.User.pushSubscription.optIn()
    }

    companion object {
        private const val ONE_SIGNAL_DEV_KEY = "b4ec2ccd-4328-4d8a-8cea-d46bda492fa6"
    }
}