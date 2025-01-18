package com.mohey.enums

enum class Move {
    ROCK, PAPER, SCISSOR;

    companion object {
        fun random(): Move = entries.random()
    }
}
