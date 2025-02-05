package com.mohey.enums

enum class MoveResult {
    WIN, DRAW, LOSE;

    companion object {
        fun revert(result: MoveResult): MoveResult {
            if(result == LOSE) return WIN
            else if(result == WIN) return LOSE

            return DRAW
        }
    }


}
