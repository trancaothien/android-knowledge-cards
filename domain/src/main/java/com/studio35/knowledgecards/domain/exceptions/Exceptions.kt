package com.studio35.knowledgecards.domain.exceptions

import com.studio35.knowledgecards.domain.models.Error

object NoConnectivityException : RuntimeException()

data class ApiException(
    val error: Error?,
    val httpCode: Int,
    val httpMessage: String?
) : RuntimeException()
