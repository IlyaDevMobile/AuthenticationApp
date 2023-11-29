package com.android.authenticationapp.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.android.authenticationapp.data.model.payment.PaymentInformation

object PaymentInformationDiffCallback : DiffUtil.ItemCallback<PaymentInformation>() {

    override fun areItemsTheSame(
        oldItem: PaymentInformation,
        newItem: PaymentInformation
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PaymentInformation,
        newItem: PaymentInformation
    ): Boolean {
        return oldItem == newItem
    }
}
