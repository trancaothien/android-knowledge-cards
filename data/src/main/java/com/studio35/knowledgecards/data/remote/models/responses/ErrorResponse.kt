package com.studio35.knowledgecards.data.remote.models.responses

import com.studio35.knowledgecards.domain.models.Error
import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "message")
    val message: String
)

internal fun ErrorResponse.toModel() = Error(message = message)
