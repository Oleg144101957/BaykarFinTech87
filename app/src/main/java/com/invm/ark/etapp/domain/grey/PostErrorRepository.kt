package com.invm.ark.etapp.domain.grey

import com.invm.ark.etapp.data.ErrorMessage


interface PostErrorRepository {

    suspend fun postError(message: ErrorMessage)

}