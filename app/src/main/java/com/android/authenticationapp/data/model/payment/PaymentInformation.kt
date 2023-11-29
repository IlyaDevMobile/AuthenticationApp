package com.android.authenticationapp.data.model.payment

import com.google.gson.annotations.SerializedName

data class PaymentInformation(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String? = null,
    @SerializedName("amount") val amount: String? = null,
    @SerializedName("created") val created: Int? = null,
)