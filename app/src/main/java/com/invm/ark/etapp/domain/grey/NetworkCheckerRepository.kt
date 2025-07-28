package com.invm.ark.etapp.domain.grey

interface NetworkCheckerRepository {
    fun isConnectionAvailable(): Boolean
}