package com.studio35.knowledgecards.ui

import android.content.Context
import com.studio35.knowledgecards.R
import com.studio35.knowledgecards.domain.exceptions.ApiException
import com.studio35.knowledgecards.extensions.showToast

fun Throwable.userReadableMessage(context: Context): String {
    return when (this) {
        is ApiException -> error?.message
        else -> message
    } ?: context.getString(R.string.error_generic)
}

fun Throwable.showToast(context: Context) =
    context.showToast(userReadableMessage(context))
