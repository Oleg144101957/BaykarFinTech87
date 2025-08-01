package tr.bay.kar.fi.ntech.data

import android.content.Context
import tr.bay.kar.fi.ntech.domain.grey.PushServiceInitializer
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
        private const val ONE_SIGNAL_DEV_KEY = "95b301ff-f9b2-4ad8-9c8b-a0e691efd800"
    }
}