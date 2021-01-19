package tests;

import main.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameMapTest {

    @Test
    public void testInitGame() {
        //given
        GameMap gameMap= new GameMap();
        int expectedLives = 3;
        int expectedScore = 0;
        int expectedCurrentSpeed = 1;
        int expectedNumberOfGhosts = 1;

        //when
        gameMap.initGame();

        //then
        assertEquals(expectedLives, gameMap.getLives());
        assertEquals(expectedScore, gameMap.getScore());
        assertEquals(expectedCurrentSpeed, gameMap.getCurrentSpeed());
        assertEquals(expectedNumberOfGhosts, gameMap.getN_GHOSTS());
    }

    @Test
    public void testDeath() {
        //given
        GameMap gameMap= new GameMap();
        int expectedLives = 2;

        //when
        gameMap.death();

        //then
        assertEquals(expectedLives, gameMap.getLives());
    }

    /*@Test
    public void testDeathTwoTimes() {
        //given
        GameMap gameMap= new GameMap();
        int expectedLives = 1;

        //when
        gameMap.death();
        gameMap.death();

        //then
        assertEquals(expectedLives, gameMap.getLives());
    }

    @Test
    public void testDeathThreeTimes() {
        //given
        GameMap gameMap= new GameMap();
        int expectedLives = 0;

        //when
        gameMap.death();
        gameMap.death();
        gameMap.death();

        //then
        assertEquals(expectedLives, gameMap.getLives());
        assertFalse(gameMap.isInGame());
    }*/

    @Test
    public void testContinueLevel() {
        //given
        GameMap gameMap= new GameMap();
        PacMan pacManMock = Mockito.mock(PacMan.class);
        ArrayList<Ghost> ghosts = gameMap.getGhosts();
        int expectedPacManX = 336;
        int expectedPacManY = 336;
        int expectedPacManDx = 0;
        int expectedPacManDy = 0;
        int expectedGhostX = 24;
        int expectedGhostY = 24;
        int expectedGhostDx = 1;
        int expectedGhostDy = 0;
        int notExpectedGhostSpeed = 3;
        int expectedReq_dx = 0;
        int expectedReq_dy = 0;

        //when
        gameMap.continueLevel();

        //then
        assertEquals(expectedGhostX, ghosts.get(0).getX());
        assertEquals(expectedGhostY, ghosts.get(0).getY());
        assertEquals(expectedGhostDx, ghosts.get(0).getDx());
        assertEquals(expectedGhostDy, ghosts.get(0).getDy());
        assertNotEquals(notExpectedGhostSpeed, ghosts.get(0).getGhostSpeed());

        assertEquals(expectedPacManX, gameMap.getPacman_x());
        assertEquals(expectedPacManY, gameMap.getPacman_y());
        assertEquals(expectedPacManDx, pacManMock.getDx());
        assertEquals(expectedPacManDy, pacManMock.getDy());

        assertEquals(expectedReq_dx, gameMap.getReq_dx());
        assertEquals(expectedReq_dy, gameMap.getReq_dy());
        assertFalse(gameMap.isDying());
    }
}
