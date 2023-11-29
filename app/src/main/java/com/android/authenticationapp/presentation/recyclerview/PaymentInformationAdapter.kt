package com.android.authenticationapp.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.android.authenticationapp.data.model.payment.PaymentInformation
import com.android.authenticationapp.databinding.ItemInfoBinding

class PaymentInformationAdapter :
    ListAdapter<PaymentInformation, PaymentInformationViewHolder>(PaymentInformationDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaymentInformationViewHolder {
        val binding = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentInformationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentInformationViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}