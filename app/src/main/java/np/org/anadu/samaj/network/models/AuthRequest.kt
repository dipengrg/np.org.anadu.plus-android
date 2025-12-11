package np.org.anadu.samaj.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(val phone: String)