package com.studio35.knowledgecards.ui.base

import androidx.compose.runtime.Composable

@Composable
fun BaseScreen(
    // TODO Base parameters to request on all screens here
    content: @Composable () -> Unit,
) {
    // TODO Base logic for all screens here

    content()
}
