package com.example.sourcetreeexample

import javax.inject.Inject

class Processor @Inject constructor()  {
    override fun toString() = "RYZEN5_2600"
}

class Motherboard @Inject constructor(){
    override fun toString() = "X7 3000"
}

class RAM @Inject constructor() {
    override fun toString() = "16 GB"
}

data class Computer @Inject constructor(
    val processor: Processor,
    val motherboard: Motherboard,
    val ram: RAM
)