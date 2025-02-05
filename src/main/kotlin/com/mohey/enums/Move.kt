package com.mohey.enums

enum class Move(val order: Int) {
    ROCK(0), PAPER(1), SCISSOR(2), SPOCK(3), LIZARD(4);

    companion object {
        fun random(): Move = entries.random()
    }
}
