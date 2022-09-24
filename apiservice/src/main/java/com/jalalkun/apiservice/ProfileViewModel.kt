package com.jalalkun.apiservice

import androidx.lifecycle.ViewModel
import com.jalalkun.apiservice.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(private val profileRepository: ProfileRepository): ViewModel() {
    private val _getProfiles = MutableStateFlow<Resource>(Resource.Loading)
    var getProfiles = _getProfiles.asStateFlow()
    private val size = 7

    suspend fun getProfiles(){
        _getProfiles.value = profileRepository.getProfiles(size)
    }
}