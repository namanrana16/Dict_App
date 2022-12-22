package com.example.dict.Screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dict.model.Definition
import com.example.dict.repo.DictRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val dictRepo: DictRepo) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Definition>())
    val state: StateFlow<List<Definition>>
    get() = _state

    init {
        viewModelScope.launch {

            val dict = dictRepo.getDict(word = "human")
            dict.isSuccessful.let {
                _state.value = dict.body()?.definitions ?: emptyList()
            }
        }
    }
}

