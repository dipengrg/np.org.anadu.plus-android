package np.org.anadu.plus.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(val success: Boolean, val message: String)