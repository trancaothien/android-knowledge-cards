package com.studio35.knowledgecards.ui.screens.main.home

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.studio35.knowledgecards.R
import com.studio35.domain.usecases.UseCase
import com.studio35.knowledgecards.test.MockUtil
import com.studio35.knowledgecards.ui.base.BaseDestination
import com.studio35.knowledgecards.ui.screens.BaseScreenTest
import com.studio35.knowledgecards.ui.screens.MainActivity
import com.studio35.knowledgecards.ui.theme.ComposeTheme
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class HomeScreenTest : BaseScreenTest() {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private val mockUseCase: UseCase = mockk()

    private lateinit var viewModel: HomeViewModel
    private var expectedDestination: BaseDestination? = null

    @Before
    fun setUp() {
        every { mockUseCase() } returns flowOf(MockUtil.models)
    }

    @Test
    fun `When entering the Home screen, it shows UI correctly`() = initComposable {
        onNodeWithText(activity.getString(R.string.app_name)).assertIsDisplayed()
    }

    @Test
    fun `When entering the Home screen and loading the data failure, it shows the corresponding error`() {
        setStandardTestDispatcher()

        val error = Exception()
        every { mockUseCase() } returns flow { throw error }

        initComposable {
            composeRule.waitForIdle()
            advanceUntilIdle()

            ShadowToast.showedToast(activity.getString(R.string.error_generic)) shouldBe true
        }
    }

    private fun initComposable(
        testBody: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.() -> Unit,
    ) {
        initViewModel()

        composeRule.activity.setContent {
            ComposeTheme {
                HomeScreen(
                    viewModel = viewModel,
                    navigator = { destination -> expectedDestination = destination }
                )
            }
        }
        testBody(composeRule)
    }

    private fun initViewModel() {
        viewModel = HomeViewModel(
            coroutinesRule.testDispatcherProvider,
            mockUseCase,
        )
    }
}
