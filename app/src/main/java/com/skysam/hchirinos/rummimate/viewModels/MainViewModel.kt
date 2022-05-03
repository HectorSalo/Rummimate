package com.skysam.hchirinos.rummimate.viewModels

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Hector Chirinos on 02/05/2022.
 */

class MainViewModel: ViewModel() {
 private val _imageTaked = MutableLiveData<Bitmap?>()
 val imageTaked: LiveData<Bitmap?> get() = _imageTaked

 private val _isVisible = MutableLiveData<Boolean>()
 val isVisible: LiveData<Boolean> get() = _isVisible

 fun viewImage(bitmap: Bitmap?) {
  _imageTaked.value = bitmap
 }

 fun visibilityFab(visibility: Boolean) {
  _isVisible.value = visibility
 }
}