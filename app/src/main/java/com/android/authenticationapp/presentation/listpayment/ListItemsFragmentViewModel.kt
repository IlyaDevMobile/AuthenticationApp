package com.android.authenticationapp.presentation.listpayment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.authenticationapp.data.model.payment.PaymentInformation
import com.android.authenticationapp.data.network.ApiFactory

class ListItemsFragmentViewModel : ViewModel() {

    private val _result = MutableLiveData<List<PaymentInformation>>()
    val result: LiveData<List<PaymentInformation>>
        get() = _result


    suspend fun getPaymentInformation(token: String) {
        val item = ApiFactory.apiService.getList(token)
        _result.postValue(item.paymentInformation)
    }

}