package com.mohey

import com.mohey.app.PlayGround
import com.mohey.enums.Move
import com.mohey.enums.MoveResult
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@QuarkusTest
class PlayGroundTest {

    private val playGround = PlayGround()

    @Test()
    fun testMoves() {
        var playerOneMove = Move.ROCK
        var playerTwoMove = Move.PAPER


        val result = playGround.playerOneResult(playerOneMove, playerTwoMove)
        assertEquals(result, MoveResult.LOSE)
    }
}
