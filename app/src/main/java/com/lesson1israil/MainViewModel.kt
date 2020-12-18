package com.lesson1israil

import androidx.lifecycle.ViewModel

@Suppress("ControlFlowWithEmptyBody")
class MainViewModel : ViewModel() {
    var result: Int = 0
    var error = "Ошибка"

    fun method(first: Int?= null, second: Int?= null, s: String? = null): String {
        if (first == 0 || second == 0) {
            return error
        } else {
            when (s) {
                "+" -> result = first!! + second!!
                "*" -> result = first!! * second!!
                "/" -> result = first!! / second!!
                "-" -> result = first!! - second!!
            }
        }

        return result.toString()
    }
}