package com.invm.ark.etapp.ui.screens.analytic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.invm.ark.etapp.R
import com.invm.ark.etapp.ui.elements.Background
import com.invm.ark.etapp.ui.elements.GreenButton
import com.invm.ark.etapp.ui.screens.add_info.ExpensesViewModel
import java.util.Calendar

@Composable
fun AnalyticsScreen(
    navController: NavController,
    viewModel: ExpensesViewModel = hiltViewModel()
) {
    val expenses = viewModel.expenses
    val blacklist = viewModel.unwantedExpenses

    val currentMonth = Calendar.getInstance().get(Calendar.MONTH)

    val monthlyExpenses = expenses.filter {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = it.timestamp
        calendar.get(Calendar.MONTH) == currentMonth
    }

    val total = monthlyExpenses.sumOf { it.amount.toDoubleOrNull() ?: 0.0 }
    val categoryMap = monthlyExpenses.groupBy { it.category }
        .mapValues { entry ->
            entry.value.sumOf { it.amount.toDoubleOrNull() ?: 0.0 }
        }

    val topCategory =
        categoryMap.maxByOrNull { it.value }?.key ?: stringResource(R.string.no_data_advice)
    val topCategoryAmount = categoryMap[topCategory] ?: 0.0

    val advice = when {
        monthlyExpenses.isEmpty() -> stringResource(R.string.no_data_advice)
        topCategory == "Еда" && topCategoryAmount > total * 0.5 -> stringResource(R.string.food_advice)
        total > 10000 -> stringResource(R.string.high_spending_advice)
        else -> stringResource(R.string.good_expenses_advice)
    }

    Background()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.monthly_report_title),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = White
        )
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.monthly_expenses_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "%.0f ₽".format(total), fontSize = 24.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.top_category_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "$topCategory: %.0f ₽".format(topCategoryAmount),
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.blacklist_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                if (blacklist.isEmpty()) {
                    Text(
                        text = stringResource(R.string.blacklist_empty),
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                } else {
                    blacklist.forEach { item ->
                        Text("🚫 $item", fontSize = 16.sp, color = Color.Black)
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.advice_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(advice, fontSize = 16.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        GreenButton(R.string.back, modifier = Modifier.fillMaxWidth()) {
            navController.popBackStack()
        }
    }
}

