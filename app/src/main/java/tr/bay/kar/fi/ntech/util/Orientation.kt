package tr.bay.kar.fi.ntech.util

import android.app.Activity
import android.content.pm.ActivityInfo

fun Activity.lockOrientation(orientation: Int) {
    requestedOrientation = orientation
}

fun Activity.unlockOrientation() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
}