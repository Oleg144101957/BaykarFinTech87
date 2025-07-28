package com.invm.ark.etapp.domain.grey

import android.content.Context

interface PushServiceInitializer {

    fun initializePushService(advertID: String, context: Context)

}