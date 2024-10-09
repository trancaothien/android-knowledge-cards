package com.studio35.knowledgecards.ui.screens.main.home

import androidx.lifecycle.viewModelScope
import com.studio35.knowledgecards.domain.usecases.UseCase
import com.studio35.knowledgecards.ui.base.BaseViewModel
import com.studio35.knowledgecards.ui.models.UiModel
import com.studio35.knowledgecards.ui.models.toUiModel
import com.studio35.knowledgecards.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    useCase: UseCase,
) : BaseViewModel() {

    private val _uiModels = MutableStateFlow<List<UiModel>>(emptyList())
    val uiModels = _uiModels.asStateFlow()

    init {
        useCase()
            .injectLoading()
            .onEach { result ->
                val uiModels = result.map { it.toUiModel() }
                _uiModels.emit(uiModels)
            }
            .flowOn(dispatchersProvider.io)
            .catch { e -> _error.emit(e) }
            .launchIn(viewModelScope)
    }
}
