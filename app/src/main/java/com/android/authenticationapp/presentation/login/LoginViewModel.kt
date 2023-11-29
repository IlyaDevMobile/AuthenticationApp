package com.android.authenticationapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.authenticationapp.data.model.token.LoginRequest
import com.android.authenticationapp.data.network.ApiFactory
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {


    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean>
        get() = _loginResult

    private val _token = MutableLiveData<String?>()
    val token: LiveData<String?>
        get() = _token


    private fun setToken(token: String?) {
        _token.postValue(token)
    }




    fun authenticate(username: String, password: String) {
        viewModelScope.launch {
            try {
                val login = LoginRequest(username, password)
                val tokenResponse = ApiFactory.apiService.getToken(login)
                if (tokenResponse.isSuccessful) {
                    val result = tokenResponse.body()?.accessToken
                    if (result?.token != null) {
                        _loginResult.value = true
                        setToken(result.token)
                    } else {
                        _loginResult.value = false
                    }
                } else {
                    _loginResult.value = false
                }
            } catch (e: Exception) {
                _loginResult.value = false
            }
        }
    }
//
//    fun authenticate(username: String, password: String) {
//        val loginRequest = LoginRequest(username,password)
//        viewModelScope.launch {
//            val response = ApiFactory.apiService.getToken(loginRequest)
//            if (response.isSuccessful){
//                val responseBody = response.body()
//                val responseToken = responseBody?.accessToken?.token
//            }
//            Toast.
//
//        }
//
//    }

}