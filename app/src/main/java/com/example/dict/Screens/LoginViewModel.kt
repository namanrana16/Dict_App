package com.example.dict.Screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dict.model.Auth
import com.example.dict.model.MessageItem
import com.example.dict.repo.DictRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val dictRepo: DictRepo) : ViewModel() {
    private val _state = mutableStateOf("")
    val state= _state



      fun auth(email:String,password:String)
      {
          viewModelScope.launch {
              val auth = dictRepo.login(email,password)
              auth.isSuccessful.let{
                  _state.value=auth.body()?.authToken?:"error"
              }

          }
      }


}