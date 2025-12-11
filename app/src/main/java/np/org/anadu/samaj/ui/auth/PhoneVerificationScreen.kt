package np.org.anadu.samaj.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import np.org.anadu.samaj.R
import np.org.anadu.samaj.ui.auth.components.SupportText
import np.org.anadu.samaj.ui.auth.viewmodel.PhoneVerificationViewModel

@Preview
@Composable
fun PhoneVerificationScreen(vm: PhoneVerificationViewModel = androidx.lifecycle.viewmodel.compose.viewModel())
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // Header Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
        ){
            Image(
                painter = painterResource(id = R.drawable.bg_login_header),
                contentDescription = "Traditional Boats",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(SinusoidalBottomShape)
            )
        }

        // Form Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.Start
        ){
            // Caption
            Text(
                "छ्याजलो",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            // Body
            Text(
                "तपाईको समाजमा दर्ता भएको मोबाईल नम्बर हाल्नुहोस।",
                style =  MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = vm.phone.value,
                label = { Text("मोबाईल नम्बर") },
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),

                onValueChange = { vm.updatePhoneNumber(it) },

                leadingIcon = {
                    Icon(
                        Icons.Default.Phone,
                        contentDescription = "Phone Icon",
                    )
                },
                trailingIcon = {
                    if (vm.isValid) {
                        Icon(
                            Icons.Default.Done,
                            contentDescription = "Valid Icon",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            )

            // Show error message that the phone number is not 10 digit
            if (vm.phone.value.isNotEmpty() && !vm.isValid) {
                Text(
                    "कृपया १० अंकको नम्बर हाल्नुहोस्।",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(5.dp)
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                onClick = {
                    // Call view model to verify phone number
                    vm.verifyPhone()
                },
            ) {
                Text(
                    "प्रमाणित गर्नुस्",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SupportText()
            }
        }

//        if(vm.isLoading) {
//            CircularProgressIndicator()
//        }
    }
}