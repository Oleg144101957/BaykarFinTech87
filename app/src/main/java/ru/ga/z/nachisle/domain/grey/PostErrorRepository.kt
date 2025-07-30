package ru.ga.z.nachisle.domain.grey

import ru.ga.z.nachisle.data.ErrorMessage


interface PostErrorRepository {

    suspend fun postError(message: ErrorMessage)

}