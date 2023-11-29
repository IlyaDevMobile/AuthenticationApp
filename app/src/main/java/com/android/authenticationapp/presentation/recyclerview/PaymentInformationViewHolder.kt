package com.android.authenticationapp.presentation.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.android.authenticationapp.data.model.payment.PaymentInformation
import com.android.authenticationapp.databinding.ItemInfoBinding
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class PaymentInformationViewHolder(private val binding: ItemInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PaymentInformation) {
        binding.textViewName.text = item.title
        binding.textViewAmount.text = item.amount
        binding.textViewCreated.text = convertTimestampToTime(item.created)
    }
}

private fun convertTimestampToTime(timestamp: Int?): String {
    if (timestamp == null) return ""
    val stamp = Timestamp((timestamp * 1000).toLong())
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}