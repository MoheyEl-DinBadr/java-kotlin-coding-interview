package com.mohey.app

import com.mohey.enums.Move
import com.mohey.enums.MoveResult
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import org.slf4j.LoggerFactory

@ApplicationScoped
class PlayGround {
    companion object {
        val logger = LoggerFactory.getLogger(PlayGround::class.java)!!
    }

    fun onStart(@Observes ev: StartupEvent) {
        play(100)
    }

    fun play(moves: Int): Map<MoveResult, Int> {

        var playerAResults = ArrayList<MoveResult>();


        repeat(moves) {
            val playerAMove = Move.random()
            val playerBMove = Move.ROCK

            val result = playerOneResult(playerAMove, playerBMove)
            playerAResults.add(result)
        }

        val resultCountPerValue = playerAResults.groupingBy { it }.eachCount()
        logger.info(
            """
            
            "Player A wins ${resultCountPerValue[MoveResult.WIN]} of $moves games"
            "Player B wins ${resultCountPerValue[MoveResult.LOSE]} of $moves games"
            "Draws: ${resultCountPerValue[MoveResult.DRAW]} of $moves games"
        """.trimIndent()
        )

        return resultCountPerValue
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
