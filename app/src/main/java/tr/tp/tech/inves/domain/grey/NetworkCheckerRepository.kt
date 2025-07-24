package tr.tp.tech.inves.domain.grey

interface NetworkCheckerRepository {
    fun isConnectionAvailable(): Boolean
}