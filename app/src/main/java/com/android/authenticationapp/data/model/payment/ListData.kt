package com.android.authenticationapp.data.model.payment

import com.google.gson.annotations.SerializedName

data class ListData(
    @SerializedName("response")val paymentInformation: List<PaymentInformation>,
)