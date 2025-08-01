package gf.na.chisle.nia.data

import android.content.Context
import gf.na.chisle.nia.domain.grey.GaidRepository
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GaidRepositoryImpl @Inject constructor(
    private val context: Context
) : GaidRepository {

    override suspend fun getGaid(): String {
        return withContext(Dispatchers.IO) {
            try {
                val advertisingIdInfo =
                    AdvertisingIdClient.getAdvertisingIdInfo(context)
                val brinId = advertisingIdInfo.id
                brinId.toString()
            } catch (e: Exception) {
                ERROR
            }
        }
    }

    companion object {
        private const val ERROR = "AD_ID ERROR"
    }
}