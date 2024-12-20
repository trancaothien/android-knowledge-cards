package com.studio35.knowledgecards.ui.screens.main.myknowledges

import com.studio35.domain.usecases.UseCase
import com.studio35.knowledgecards.ui.base.BaseInput
import com.studio35.knowledgecards.ui.base.BaseOutput
import com.studio35.knowledgecards.ui.base.BaseViewModel
import com.studio35.knowledgecards.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface Input : BaseInput {

}

interface Output : BaseOutput {

}

@HiltViewModel
class MyKnowledgeViewModel @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    useCase: UseCase,
) : BaseViewModel(), Input, Output {

    override val input: BaseInput
        get() = this

    override val output: BaseOutput
        get() = this
}