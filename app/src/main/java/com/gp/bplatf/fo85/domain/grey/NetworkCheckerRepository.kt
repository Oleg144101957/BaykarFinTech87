package com.gp.bplatf.fo85.domain.grey

interface NetworkCheckerRepository {
    fun isConnectionAvailable(): Boolean
}