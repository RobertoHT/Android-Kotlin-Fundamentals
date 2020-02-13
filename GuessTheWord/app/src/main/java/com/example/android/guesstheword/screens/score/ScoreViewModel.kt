package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Roberto Hdez on 2020-02-13
 */

class ScoreViewModel(finalScore: Int) :ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventPlay = MutableLiveData<Boolean>()
    val eventPlay: LiveData<Boolean>
        get() = _eventPlay

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        _score.value = finalScore
    }

    fun onPlayAgain() {
        _eventPlay.value = true
    }

    fun onPlayAgainCompleted() {
        _eventPlay.value = false
    }
}