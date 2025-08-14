package app.quran_random_ayah.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.quran_random_ayah.domain.model.Ayah
import app.quran_random_ayah.domain.usecase.GetRandomAyahUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AyahUiState(
    val ayah: Ayah? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class AyahViewModel @Inject constructor(
    private val getRandomAyahUseCase: GetRandomAyahUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AyahUiState(isLoading = true))
    val state = _state.asStateFlow()

    init {
        fetchRandomAyah()
    }

    fun fetchRandomAyah() {
        _state.value = AyahUiState(isLoading = true)
        viewModelScope.launch {
            val res = getRandomAyahUseCase()
            if (res.isSuccess) {
                _state.value = AyahUiState(ayah = res.getOrNull())
            } else {
                _state.value = AyahUiState(error = res.exceptionOrNull()?.localizedMessage)
            }
        }
    }

}