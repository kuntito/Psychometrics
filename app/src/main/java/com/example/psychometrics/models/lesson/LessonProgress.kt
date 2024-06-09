package com.example.psychometrics.models.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class LessonProgress(max: Int) {
    private val progressUnit = 1f/max
    private var _progress = MutableLiveData(0f)
    val progress: LiveData<Float>
        get() = _progress

    fun increment() {
        _progress.value = _progress.value?.plus(progressUnit)
    }

    fun reset() {
        _progress.value = 0f
    }
}