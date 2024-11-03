package com.studio35.designsystem.component.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.NavigationBarItem

@Composable
fun KnowledgeNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enable: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    label: @Composable () -> Unit,
) {
}