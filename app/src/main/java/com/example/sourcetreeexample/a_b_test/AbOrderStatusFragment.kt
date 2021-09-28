package com.example.sourcetreeexample.a_b_test

import android.widget.Toast

class AbOrderStatusFragment: BaseOrderStatusFragment() {

    override fun toast() {
        Toast.makeText(requireContext(),"AbOrderStatusFragment", Toast.LENGTH_SHORT).show()
    }

}