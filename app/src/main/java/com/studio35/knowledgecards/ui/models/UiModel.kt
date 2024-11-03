package com.studio35.knowledgecards.ui.models

import com.studio35.domain.models.Model

data class UiModel(
    val id: Int
)

fun Model.toUiModel() = UiModel(id = id ?: -1)
