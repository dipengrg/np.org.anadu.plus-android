package np.org.anadu.samaj.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(val success: Boolean, val message: String)