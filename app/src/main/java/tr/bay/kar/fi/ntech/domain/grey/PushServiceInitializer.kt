package tr.bay.kar.fi.ntech.domain.grey

import android.content.Context

interface PushServiceInitializer {

    fun initializePushService(advertID: String, context: Context)

}