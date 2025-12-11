package np.org.anadu.samaj.ui.auth.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.core.net.toUri

@Composable
fun SupportText() {
    Text(
        "प्राविधिक समस्या पर्यो? ",
        style =  MaterialTheme.typography.bodyMedium,
    )

    val context = LocalContext.current

    Text(
        "यहाँ थिचेर फोन गर्नुहोस्",
        style =  MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = "tel:+9779856041419".toUri()
            }

            context.startActivity(intent)
        }
    )
}