package com.android.authenticationapp.data.model.token

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class TokenResponse(
    @SerializedName("response") val accessToken : AccessToken
) : Parcelable