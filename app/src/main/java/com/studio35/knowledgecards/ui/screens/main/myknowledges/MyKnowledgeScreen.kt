package com.studio35.knowledgecards.ui.screens.main.myknowledges

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.studio35.knowledgecards.extensions.collectAsEffect
import com.studio35.knowledgecards.ui.base.BaseDestination
import com.studio35.knowledgecards.ui.base.BaseScreen
import com.studio35.knowledgecards.ui.showToast

@Composable
fun MyKnowledgeScreen(
    viewModel: MyKnowledgeViewModel = hiltViewModel(),
    navigator: (destination: BaseDestination) -> Unit
) = BaseScreen {

    val context = LocalContext.current

    viewModel.error.collectAsEffect { e -> e.showToast(context) }
    viewModel.navigator.collectAsEffect { destination -> navigator(destination) }

    val isLoading: Boolean by viewModel.isLoading.collectAsStateWithLifecycle()

    MyKnowledgeScreenContent(
        title = "Knowledge screen",
        isLoading = isLoading
    )
}

@Composable
private fun MyKnowledgeScreenContent(
    title: String,
    isLoading: Boolean = false
) {

}