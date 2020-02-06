package com.example.pickeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class ZomatoViewModel : ViewModel(){
    private val zomatoRepo = ZomatoRepo()

    val zomatoResponse = MutableLiveData<ZomatoResponse>()

    val error = MutableLiveData<Boolean>(false)

    fun attemptToGet(type: String) {

        thread {

            zomatoRepo.getRestaurant(type) { newZomatoRepo ->

                if (newZomatoRepo != null) {
                    zomatoResponse.postValue(newZomatoRepo)
                } else {
                    error.postValue(true)

                }
            }
        }
    }
}