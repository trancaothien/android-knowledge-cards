package com.studio35.knowledgecards.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.studio35.designsystem.theme.KnowledgeTheme
import com.studio35.knowledgecards.ui.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KnowledgeTheme {
                AppNavGraph(navController = rememberNavController())
            }
        }
    }
}
