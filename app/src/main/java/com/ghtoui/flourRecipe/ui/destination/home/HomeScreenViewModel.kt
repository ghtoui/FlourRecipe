package com.ghtoui.flourRecipe.ui.destination.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.domain.repository.SaveFlourRecipeUseCase
import com.ghtoui.domain.usecase.GetRecipeListUseCase
import com.ghtoui.flourRecipe.ui.destination.home.model.HomeState
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeScreenViewModel @Inject constructor(
    private val getRecipeListUseCase: GetRecipeListUseCase,
    private val saveFlourRecipeUseCase: SaveFlourRecipeUseCase,
) : ViewModel() {
    private val flourRecipes: MutableStateFlow<List<FlourRecipe>> = MutableStateFlow(emptyList())
    val state: StateFlow<HomeState> = flourRecipes.map {
        HomeState(
            flourRecipes = it
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeState.initial()
    )
    init {
        viewModelScope.launch {
            val dummyFlourRecipe = getDummyRecipes().first()
            saveFlourRecipeUseCase(
                dummyFlourRecipe
            )
            getRecipeListUseCase().collect { _flourRecipes ->
                flourRecipes.update { _flourRecipes }
            }
        }
    }

    fun onAddClick() {
        viewModelScope.launch {
            val dummyFlourRecipe = getDummyRecipes().first()
            saveFlourRecipeUseCase(
                dummyFlourRecipe
            )
        }
    }
}
