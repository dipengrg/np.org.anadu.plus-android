package np.org.anadu.plus.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(val phone: String)