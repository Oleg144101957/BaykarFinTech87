package tr.bay.kar.fi.ntech.ui.screens.unwatned_expenses

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tr.bay.kar.fi.ntech.R
import tr.bay.kar.fi.ntech.ui.elements.Background
import tr.bay.kar.fi.ntech.ui.elements.CustomOutlinedTextField
import tr.bay.kar.fi.ntech.ui.elements.GreenButton
import tr.bay.kar.fi.ntech.util.lockOrientation

@Composable
fun UnwantedExpensesScreen(
    navController: NavController,
    viewModel: UnwantedExpensesViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val activity = context as? Activity
    activity?.lockOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val unwantedExpenses = viewModel.unwantedExpenses
    var newExpense by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.unwanted_expense_title),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            CustomOutlinedTextField(
                value = newExpense,
                onValueChange = { newExpense = it },
                labelText = stringResource(R.string.unwanted_expense_hint)
            )

            GreenButton(
                textRes = R.string.add_expense,
                onClick = {
                    if (newExpense.isNotBlank()) {
                        viewModel.addExpense(newExpense)
                        newExpense = ""
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            unwantedExpenses.forEach { item ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(item, color = Color.Black)
                        IconButton(onClick = { viewModel.removeExpense(item) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = stringResource(R.string.delete),
                                tint = Color.Red
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            GreenButton(
                textRes = R.string.back,
                onClick = { navController.popBackStack() }
            )
        }
    }
}


