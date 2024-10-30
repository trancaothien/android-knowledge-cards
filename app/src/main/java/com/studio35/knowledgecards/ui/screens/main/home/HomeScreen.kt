package com.studio35.knowledgecards.ui.screens.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.studio35.designsystem.theme.KnowledgeTheme
import com.studio35.designsystem.theme.LocalAppDimensions
import com.studio35.knowledgecards.R
import com.studio35.knowledgecards.extensions.collectAsEffect
import com.studio35.knowledgecards.ui.base.BaseDestination
import com.studio35.knowledgecards.ui.base.BaseScreen
import com.studio35.knowledgecards.ui.models.UiModel
import com.studio35.knowledgecards.ui.showToast

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: (destination: BaseDestination) -> Unit,
) = BaseScreen {

    val context = LocalContext.current
    viewModel.error.collectAsEffect { e -> e.showToast(context) }
    viewModel.navigator.collectAsEffect { destination -> navigator(destination) }

    val uiModels: List<UiModel> by viewModel.uiModels.collectAsStateWithLifecycle()
    val isLoading: Boolean by viewModel.isLoading.collectAsStateWithLifecycle()

    HomeScreenContent(
        title = stringResource(id = R.string.app_name),
        uiModels = uiModels,
        isLoading = isLoading,
        onNavigateToKnowledge = { viewModel.onNavigateToKnowledge() },
    )
}

@Composable
private fun HomeScreenContent(
    title: String,
    uiModels: List<UiModel>,
    isLoading: Boolean = false,
    onNavigateToKnowledge: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalAppDimensions.current.spacingXLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = onNavigateToKnowledge) {
            Text("Navigate to knowledge screen")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    KnowledgeTheme {
        HomeScreenContent(
            title = stringResource(id = R.string.app_name),
            uiModels = listOf(UiModel(1), UiModel(2), UiModel(3)),
        )
    }
}
