package tr.bay.kar.fi.ntech.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                fontSize = 18.sp,
                color = White
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedTextColor = White,
            unfocusedTextColor = White,
            focusedContainerColor = Transparent,
            unfocusedContainerColor = Transparent,
            cursorColor = White,
            focusedIndicatorColor = White,
            unfocusedIndicatorColor = White
        ),
        textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
    )
}
