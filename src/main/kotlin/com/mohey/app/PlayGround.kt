package com.mohey.app

import com.mohey.enums.Move
import com.mohey.enums.MoveResult
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PlayGround {

    fun play(moves: Int) {

        var playerAResults = ArrayList<MoveResult>();


        repeat(moves) {
            val playerAMove = Move.random()
            val playerBMove = Move.ROCK

            val result = playerOneResult(playerAMove, playerBMove)
            playerAResults.add(result)
        }

        val resultCountPerValue = playerAResults.groupingBy { it }.eachCount()

        println("""
            "Player A wins ${resultCountPerValue[MoveResult.WIN]} of $moves games"
            "Player B wins ${resultCountPerValue[MoveResult.LOSE]} of $moves games"
            "Draws: ${resultCountPerValue[MoveResult.DRAW]} of $moves games"
        """.trimIndent())
    }


    fun playerOneResult(playerAMove: Move, playerBMove: Move): MoveResult {
        return when (playerAMove) {
            playerBMove -> MoveResult.DRAW
            Move.ROCK -> if (playerBMove == Move.PAPER) MoveResult.LOSE else MoveResult.WIN
            Move.PAPER -> if (playerBMove == Move.ROCK) MoveResult.WIN else MoveResult.LOSE
            Move.SCISSOR -> if (playerBMove == Move.PAPER) MoveResult.WIN else MoveResult.LOSE
        }
    }
}
