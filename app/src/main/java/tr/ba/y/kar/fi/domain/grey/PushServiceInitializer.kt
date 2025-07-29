package tr.ba.y.kar.fi.domain.grey

import android.content.Context

interface PushServiceInitializer {

    fun initializePushService(advertID: String, context: Context)

}