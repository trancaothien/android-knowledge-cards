package com.studio35.data.remote.models.responses

import com.studio35.domain.models.Model
import com.squareup.moshi.Json

data class Response(
    @Json(name = "id") val id: Int?
)

private fun Response.toModel() = Model(id = this.id)

fun List<Response>.toModels() = this.map { it.toModel() }
