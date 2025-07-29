package tr.ba.y.kar.fi.domain.grey

interface NetworkCheckerRepository {
    fun isConnectionAvailable(): Boolean
}