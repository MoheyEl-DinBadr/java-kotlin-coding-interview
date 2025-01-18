package com.mohey.app

import com.mohey.enums.Move
import com.mohey.enums.MoveResult
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PlayGround {


    fun playerOneResult(playerOneMove: Move, playerTwoMove: Move): MoveResult {
        return when (playerOneMove) {
            playerTwoMove -> MoveResult.DRAW
            Move.ROCK -> if (playerTwoMove == Move.PAPER) MoveResult.LOSE else MoveResult.WIN
            Move.PAPER -> if (playerTwoMove == Move.ROCK) MoveResult.WIN else MoveResult.LOSE
            Move.SCISSOR -> if (playerTwoMove == Move.PAPER) MoveResult.WIN else MoveResult.LOSE
        }
    }
}
