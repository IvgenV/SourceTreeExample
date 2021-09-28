package com.example.sourcetreeexample.a_b_test

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseOrderStatusFragment:Fragment() {

    abstract fun toast()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toast()
    }

}