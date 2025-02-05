package com.mohey

import com.mohey.app.PlayGround
import com.mohey.enums.Move
import com.mohey.enums.MoveResult
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@QuarkusTest
class PlayGroundTest {
    val playGround: PlayGround = PlayGround()
    /*
    * SCISSORS -> 0
    * PAPER -> 1
    * ROCK -> 2
    * LIZARD -> 3
    * SPOCK -> 4
    *
    *
    * */

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Move.ROCK, Move.ROCK, MoveResult.DRAW),
                Arguments.of(Move.ROCK, Move.PAPER, MoveResult.LOSE),
                Arguments.of(Move.ROCK, Move.SCISSOR, MoveResult.WIN),


                Arguments.of(Move.PAPER, Move.ROCK, MoveResult.WIN),
                Arguments.of(Move.PAPER, Move.PAPER, MoveResult.DRAW),
                Arguments.of(Move.PAPER, Move.SCISSOR, MoveResult.LOSE),

                Arguments.of(Move.SCISSOR, Move.ROCK, MoveResult.LOSE),
                Arguments.of(Move.SCISSOR, Move.PAPER, MoveResult.WIN),
                Arguments.of(Move.SCISSOR, Move.SCISSOR, MoveResult.DRAW),

            )
        }
    }


    @ParameterizedTest
    @MethodSource("provideParameters")
    fun testMovesResults(playerAMove: Move, playerBMove: Move, expectedResult: MoveResult) {
        val result = playGround.playerOneResult(playerAMove, playerBMove)
        assertEquals(expectedResult, result)
    }


    @Test
    fun testPlayMethodResultsCount() {
        val moves = 10
        val resultMap = playGround.play(10)
        val resultSum = resultMap.map { it.value }.sum()
        assertEquals(moves, resultSum)
    }


}
