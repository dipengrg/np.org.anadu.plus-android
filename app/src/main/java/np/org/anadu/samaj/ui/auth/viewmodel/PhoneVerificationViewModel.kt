package np.org.anadu.samaj.ui.auth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.launch
import np.org.anadu.samaj.network.KtorClient
import np.org.anadu.samaj.network.models.AuthRequest
import np.org.anadu.samaj.network.models.AuthResponse

class PhoneVerificationViewModel : ViewModel() {
    var phone = mutableStateOf("")
    val isValid: Boolean
        get() = phone.value.length == 10

    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)
    val successMessage = mutableStateOf<String?>(null)

    fun updatePhoneNumber(value: String) {
        phone.value = value
        errorMessage.value = null
        successMessage.value = null
    }

    fun verifyPhone() {
        if (!isValid) {
            errorMessage.value = "कृपया १० अंकको नम्बर हाल्नुहोस्।"
            return
        }

        // Launch coroutine to call api
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null
            successMessage.value = null

            try {
                val response: AuthResponse = KtorClient.client.post("https://webhook.site/548b0388-6867-48c4-aa39-e8427bb83a89") {
                    contentType(ContentType.Application.Json)
                    setBody(AuthRequest(phone.value))
                }.body()

                if (response.success) {
                    successMessage.value = response.message
                } else {
                    errorMessage.value = response.message
                }
            } catch (e: Exception) {
                errorMessage.value = "नेटवर्कमा समस्या: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}