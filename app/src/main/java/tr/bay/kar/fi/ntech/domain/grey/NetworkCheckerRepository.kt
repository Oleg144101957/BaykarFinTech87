package tr.bay.kar.fi.ntech.domain.grey

interface NetworkCheckerRepository {
    fun isConnectionAvailable(): Boolean
}