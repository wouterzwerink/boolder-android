package com.boolder.boolderflo.view.areadetails.areacircuit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boolder.boolderflo.data.database.repository.CircuitRepository
import com.boolder.boolderflo.data.database.repository.ProblemRepository
import com.boolder.boolderflo.domain.model.CircuitColor
import com.boolder.boolderflo.domain.model.Problem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class AreaCircuitViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val circuitRepository: CircuitRepository,
    private val problemRepository: ProblemRepository
) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            val circuitId = savedStateHandle.get<Int>("circuit_id") ?: return@launch
            val circuit = circuitRepository.getCircuitById(circuitId) ?: return@launch

            val problems = problemRepository.problemsForCircuit(circuitId)

            _screenState.value = ScreenState.Content(
                circuitColor = circuit.color,
                isBeginnerFriendly = circuit.isBeginnerFriendly,
                isDangerous = circuit.isDangerous,
                problems = problems
            )
        }
    }

    sealed interface ScreenState {
        data object Loading : ScreenState
        data class Content(
            val circuitColor: CircuitColor,
            val isBeginnerFriendly: Boolean,
            val isDangerous: Boolean,
            val problems: List<Problem>
        ) : ScreenState
    }
}
