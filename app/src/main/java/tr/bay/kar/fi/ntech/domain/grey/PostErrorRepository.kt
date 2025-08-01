package tr.bay.kar.fi.ntech.domain.grey

import tr.bay.kar.fi.ntech.data.ErrorMessage


interface PostErrorRepository {

    suspend fun postError(message: ErrorMessage)

}