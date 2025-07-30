package ru.ga.z.nachisle.domain.grey

interface NetworkCheckerRepository {
    fun isConnectionAvailable(): Boolean
}