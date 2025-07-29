package tr.ba.y.kar.fi.data

import android.content.Context
import tr.ba.y.kar.fi.domain.grey.PushServiceInitializer
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
        private const val ONE_SIGNAL_DEV_KEY = "df4bced7-22d8-4357-a7ff-74ad40560113"
    }
}