package com.gp.bplatf.fo85.domain.grey

import com.gp.bplatf.fo85.data.ErrorMessage


interface PostErrorRepository {

    suspend fun postError(message: ErrorMessage)

}