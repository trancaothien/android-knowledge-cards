package com.studio35.knowledgecards.ui.screens.main.home

import com.studio35.domain.usecases.UseCase
import com.studio35.knowledgecards.ui.base.BaseInput
import com.studio35.knowledgecards.ui.base.BaseOutput
import com.studio35.knowledgecards.ui.base.BaseViewModel
import com.studio35.knowledgecards.ui.models.UiModel
import com.studio35.knowledgecards.ui.screens.main.MainDestination
import com.studio35.knowledgecards.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

interface Input : BaseInput {
    fun onNavigateToKnowledge()
}

interface Output : BaseOutput {
    val uiModels: StateFlow<List<UiModel>>
}


@HiltViewModel
class HomeViewModel @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    useCase: UseCase,
) : BaseViewModel(), Input, Output {

    override val input: BaseInput
        get() = this
    override val output: BaseOutput
        get() = this

    private val _uiModels = MutableStateFlow<List<UiModel>>(emptyList())
    override val uiModels: StateFlow<List<UiModel>>
        get() = _uiModels

    // INPUT
    override fun onNavigateToKnowledge() {
        launch {
            _navigator.emit(MainDestination.MyKnowledge)
        }
    }
}
