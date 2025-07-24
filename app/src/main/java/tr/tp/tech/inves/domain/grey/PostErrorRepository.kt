package tr.tp.tech.inves.domain.grey

import tr.tp.tech.inves.data.ErrorMessage


interface PostErrorRepository {

    suspend fun postError(message: ErrorMessage)

}