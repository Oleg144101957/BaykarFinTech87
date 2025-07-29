package tr.ba.y.kar.fi.domain.grey

import tr.ba.y.kar.fi.data.ErrorMessage


interface PostErrorRepository {

    suspend fun postError(message: ErrorMessage)

}