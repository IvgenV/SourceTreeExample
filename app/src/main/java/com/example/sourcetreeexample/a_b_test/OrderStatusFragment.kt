package com.example.sourcetreeexample.a_b_test

import android.widget.Toast

class OrderStatusFragment: BaseOrderStatusFragment() {


    override fun toast() {
        Toast.makeText(requireContext(),"OrderStatusFragment",Toast.LENGTH_SHORT).show()
    }

}