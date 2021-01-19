package tests;

import main.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;

public class MapDrawerTest {
    @Test
    public void testDrawScore() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        Font expectedFont = new Font("Arial", Font.BOLD, 14);
        Color expectedColor = Color.green;
        String expectedMessage = "Score: " + 0;
        int expectedWidth = 276;
        int expectedHeight = 376;

        //when
        mapDrawer.drawScore(gMock);

        //then
        Mockito.verify(gMock).setFont(expectedFont);
        Mockito.verify(gMock).setColor(expectedColor);
        Mockito.verify(gMock).drawString(expectedMessage, expectedWidth, expectedHeight);
    }

    @Test
    public void testDrawLives1() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedWidth = 8;
        int expectedHeight = 361;
        Image expectedHeart = Configuration.heart;

        //when
        mapDrawer.drawLives(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedHeart, expectedWidth, expectedHeight, null);
    }

    /*@Test
    public void testDrawLives2() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedWidth = 36;
        int expectedHeight = 361;
        Image expectedHeart = Configuration.heart;

        //when
        mapDrawer.drawLives(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedHeart, expectedWidth, expectedHeight, null);
    }

    @Test
    public void testDrawLives3() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedWidth = 64;
        int expectedHeight = 361;
        Image expectedHeart = Configuration.heart;

        //when
        mapDrawer.drawLives(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedHeart, expectedWidth, expectedHeight, null);
    }*/

    @Test
    public void testDrawGhost() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedGhostX = 5;
        int expectedGhostY = 5;
        Image expectedGhost = Configuration.ghost;

        //when
        mapDrawer.drawGhost(gMock, expectedGhostX, expectedGhostY);

        //then
        Mockito.verify(gMock).drawImage(expectedGhost, expectedGhostX, expectedGhostY, null);
    }

    @Test
    public void testDrawGhosts() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        Image expectedGhost = Configuration.ghost;
        ArrayList<main.Ghost> expectedGhosts = gameMap.getGhosts();
        Ghost ghost = expectedGhosts.get(0);
        int expectedGhostX = ghost.getX() + 1;
        int expectedGhostY = ghost.getY() + 1;

        //when
        mapDrawer.drawGhosts(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedGhost, expectedGhostX, expectedGhostY, null);
    }

    @Test
    public void testDrawPacmanLeft() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Image expectedLeft = Configuration.left;
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedPacManX = gameMap.getPacman_x() + 1;
        int expectedPacManY = gameMap.getPacman_y() + 1;

        //when
        gameMap.setReq_dx(-1);
        mapDrawer.drawPacman(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedLeft, expectedPacManX, expectedPacManY, null);
    }

    @Test
    public void testDrawPacmanRight() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Image expectedRight = Configuration.right;
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedPacManX = gameMap.getPacman_x() + 1;
        int expectedPacManY = gameMap.getPacman_y() + 1;

        //when
        gameMap.setReq_dx(1);
        mapDrawer.drawPacman(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedRight, expectedPacManX, expectedPacManY, null);
    }

    @Test
    public void testDrawPacmanUp() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Image expectedUp = Configuration.up;
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedPacManX = gameMap.getPacman_x() + 1;
        int expectedPacManY = gameMap.getPacman_y() + 1;

        //when
        gameMap.setReq_dy(-1);
        mapDrawer.drawPacman(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedUp, expectedPacManX, expectedPacManY, null);
    }

    @Test
    public void testDrawPacmanDown() {
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Image expectedDown = Configuration.down;
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        int expectedPacManX = gameMap.getPacman_x() + 1;
        int expectedPacManY = gameMap.getPacman_y() + 1;

        //when
        mapDrawer.drawPacman(gMock);

        //then
        Mockito.verify(gMock).drawImage(expectedDown, expectedPacManX, expectedPacManY, null);
    }

    @Test
    public void testShowMessage(){
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        String expectedMessage = "Press SPACE to start";
        Color expectedColor = Color.yellow;
        int expectedX = (15*24)/4;
        int expectedY = 150;
        //when
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        mapDrawer.showMessage(gMock);
        //then
        Mockito.verify(gMock).setColor(expectedColor);
        Mockito.verify(gMock).drawString(expectedMessage, expectedX, expectedY);
    }

    @Test
    public void testDrawBackground(){
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Color expectedColor = Color.black;
        int expectedX = 0;
        int expectedY = 0;
        int expectedWidth = 380;
        int expectedHeight = 420;

        //when
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        mapDrawer.drawBackground(gMock);

        //then
        Mockito.verify(gMock).setColor(expectedColor);
        Mockito.verify(gMock).fillRect(expectedX,expectedY,expectedWidth, expectedHeight);
    }

    @Test
    public void testDrawMazeExteriorWall(){
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        int expectedBlockSize = 24;
        int x[] ={0, 24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360};
        int y[] ={0, 24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360};
        //when
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        mapDrawer.drawMaze(gMock);

        //then
        //&1
        Mockito.verify(gMock).drawLine(x[0], y[0], x[0], y[0] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[1], x[0], y[1] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[2], x[0], y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[6], y[2], x[6], y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[6], y[3], x[6], y[3] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[4], x[0], y[4] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[5], x[0], y[5] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14], y[5], x[14], y[5] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[6], x[0], y[6] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14], y[6], x[14], y[6] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[7], x[0], y[7] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14], y[7], x[14], y[7] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[8], x[0], y[8] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5], y[8], x[5], y[8] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[9], x[0], y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5], y[9], x[5], y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[10], x[0], y[10] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[8], y[10], x[8], y[10] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[11], x[0], y[11] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5], y[11], x[5], y[11] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[12], x[0], y[12] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5], y[12], x[5], y[12] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[13], x[0], y[13] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5], y[13], x[5], y[13] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0], y[14], x[0], y[14] + expectedBlockSize - 1);

        //&2
        Mockito.verify(gMock).drawLine(x[0], y[0], x[0] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[1], y[0], x[1] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[2], y[0], x[2] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[3], y[0], x[3] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[4], y[0], x[4] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[5], y[0], x[5] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[6], y[0], x[6] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[7], y[0], x[7] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[8], y[0], x[8] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[9], y[0], x[9] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[10], y[0], x[10] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[11], y[0], x[11] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[12], y[0], x[12] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[13], y[0], x[13] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[14], y[0], x[14] + expectedBlockSize - 1, y[0]);
        Mockito.verify(gMock).drawLine(x[0], y[4], x[0] + expectedBlockSize - 1, y[4]);
        Mockito.verify(gMock).drawLine(x[1], y[4], x[1] + expectedBlockSize - 1, y[4]);
        Mockito.verify(gMock).drawLine(x[2], y[4], x[2] + expectedBlockSize - 1, y[4]);
        Mockito.verify(gMock).drawLine(x[3], y[4], x[3] + expectedBlockSize - 1, y[4]);
        Mockito.verify(gMock).drawLine(x[4], y[4], x[4] + expectedBlockSize - 1, y[4]);
        Mockito.verify(gMock).drawLine(x[5], y[4], x[5] + expectedBlockSize - 1, y[4]);
        Mockito.verify(gMock).drawLine(x[10], y[8], x[10] + expectedBlockSize - 1, y[8]);
        Mockito.verify(gMock).drawLine(x[11], y[8], x[11] + expectedBlockSize - 1, y[8]);
        Mockito.verify(gMock).drawLine(x[12], y[8], x[12] + expectedBlockSize - 1, y[8]);
        Mockito.verify(gMock).drawLine(x[13], y[8], x[13] + expectedBlockSize - 1, y[8]);
        Mockito.verify(gMock).drawLine(x[1], y[11], x[1] + expectedBlockSize - 1, y[11]);
        Mockito.verify(gMock).drawLine(x[2], y[11], x[2] + expectedBlockSize - 1, y[11]);
        Mockito.verify(gMock).drawLine(x[3], y[11], x[3] + expectedBlockSize - 1, y[11]);
        Mockito.verify(gMock).drawLine(x[5], y[11], x[5] + expectedBlockSize - 1, y[11]);
        Mockito.verify(gMock).drawLine(x[6], y[11], x[6] + expectedBlockSize - 1, y[11]);
        Mockito.verify(gMock).drawLine(x[7], y[11], x[7] + expectedBlockSize - 1, y[11]);
        Mockito.verify(gMock).drawLine(x[4], y[14], x[4] + expectedBlockSize - 1, y[14]);

        //&4
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[0], x[14] + expectedBlockSize - 1, y[0] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[1], x[14] + expectedBlockSize - 1, y[1] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[4] + expectedBlockSize - 1, y[2], x[4] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[2], x[14] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[3], x[14] + expectedBlockSize - 1, y[3] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[4], x[14] + expectedBlockSize - 1, y[4] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[5], x[14] + expectedBlockSize - 1, y[5] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[9] + expectedBlockSize - 1, y[5], x[9] + expectedBlockSize - 1, y[5] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[5], x[14] + expectedBlockSize - 1, y[5] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[9] + expectedBlockSize - 1, y[6], x[9] + expectedBlockSize - 1, y[6] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[6], x[14] + expectedBlockSize - 1, y[6] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[9] + expectedBlockSize - 1, y[7], x[9] + expectedBlockSize - 1, y[7] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[7], x[14] + expectedBlockSize - 1, y[7] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] + expectedBlockSize - 1, y[8], x[3] + expectedBlockSize - 1, y[8] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[8], x[14] + expectedBlockSize - 1, y[8] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] + expectedBlockSize - 1, y[9], x[3] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[9], x[14] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0] + expectedBlockSize - 1, y[10], x[0] + expectedBlockSize - 1, y[10] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[10], x[14] + expectedBlockSize - 1, y[10] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] + expectedBlockSize - 1, y[11], x[3] + expectedBlockSize - 1, y[11] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[11], x[14] + expectedBlockSize - 1, y[11] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] + expectedBlockSize - 1, y[12], x[3] + expectedBlockSize - 1, y[12] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[12], x[14] + expectedBlockSize - 1, y[12] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] + expectedBlockSize - 1, y[13], x[3] + expectedBlockSize - 1, y[13] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] + expectedBlockSize - 1, y[13], x[14] + expectedBlockSize - 1, y[13] + expectedBlockSize - 1);

        //&8
        Mockito.verify(gMock).drawLine(x[5] , y[1] + expectedBlockSize - 1, x[5] + expectedBlockSize - 1, y[1] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0] , y[2] + expectedBlockSize - 1, x[0] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[1] , y[2] + expectedBlockSize - 1, x[1] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[2] , y[2] + expectedBlockSize - 1, x[2] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] , y[2] + expectedBlockSize - 1, x[3] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[4] , y[2] + expectedBlockSize - 1, x[4] + expectedBlockSize - 1, y[2] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[10] , y[4] + expectedBlockSize - 1, x[10] + expectedBlockSize - 1, y[4] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[11] , y[4] + expectedBlockSize - 1, x[11] + expectedBlockSize - 1, y[4] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[12] , y[4] + expectedBlockSize - 1, x[12] + expectedBlockSize - 1, y[4] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[13] , y[4] + expectedBlockSize - 1, x[13] + expectedBlockSize - 1, y[4] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[4] , y[7] + expectedBlockSize - 1, x[4] + expectedBlockSize - 1, y[7] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[1] , y[9] + expectedBlockSize - 1, x[1] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[2] , y[9] + expectedBlockSize - 1, x[2] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] , y[9] + expectedBlockSize - 1, x[3] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5] , y[9] + expectedBlockSize - 1, x[5] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[6] , y[9] + expectedBlockSize - 1, x[6] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[7] , y[9] + expectedBlockSize - 1, x[7] + expectedBlockSize - 1, y[9] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[0] , y[14] + expectedBlockSize - 1, x[0] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[1] , y[14] + expectedBlockSize - 1, x[1] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[2] , y[14] + expectedBlockSize - 1, x[2] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[3] , y[14] + expectedBlockSize - 1, x[3] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[4] , y[14] + expectedBlockSize - 1, x[4] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[5] , y[14] + expectedBlockSize - 1, x[5] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[6] , y[14] + expectedBlockSize - 1, x[6] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[7] , y[14] + expectedBlockSize - 1, x[7] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[8] , y[14] + expectedBlockSize - 1, x[8] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[9] , y[14] + expectedBlockSize - 1, x[9] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[10] , y[14] + expectedBlockSize - 1, x[10] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[11] , y[14] + expectedBlockSize - 1, x[11] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[12] , y[14] + expectedBlockSize - 1, x[12] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[13] , y[14] + expectedBlockSize - 1, x[13] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
        Mockito.verify(gMock).drawLine(x[14] , y[14] + expectedBlockSize - 1, x[14] + expectedBlockSize - 1, y[14] + expectedBlockSize - 1);
    }

    @Test
    public void testDrawMazeInteriorWals(){
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        int expectedBlockSize = 24;
        int x[] ={0, 24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360};
        int y[] ={0, 24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360};
        //when
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        mapDrawer.drawMaze(gMock);
        //then
        Mockito.verify(gMock).fillRect(x[5], y[2], expectedBlockSize, expectedBlockSize);

        Mockito.verify(gMock).fillRect(x[0], y[3], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[1], y[3], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[2], y[3], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[3], y[3], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[3], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[5], y[2], expectedBlockSize, expectedBlockSize);

        Mockito.verify(gMock).fillRect(x[10], y[5], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[11], y[5], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[12], y[5], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[13], y[5], expectedBlockSize, expectedBlockSize);

        Mockito.verify(gMock).fillRect(x[10], y[6], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[11], y[6], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[12], y[6], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[13], y[6], expectedBlockSize, expectedBlockSize);

        Mockito.verify(gMock).fillRect(x[10], y[7], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[11], y[7], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[12], y[7], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[13], y[7], expectedBlockSize, expectedBlockSize);

        Mockito.verify(gMock).fillRect(x[4], y[8], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[9], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[11], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[12], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[13], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[1], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[2], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[3], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[4], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[5], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[6], y[10], expectedBlockSize, expectedBlockSize);
        Mockito.verify(gMock).fillRect(x[7], y[10], expectedBlockSize, expectedBlockSize);
    }

    @Test
    public void testDrawMazeBalls(){
        //given
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        int x[] ={0, 24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360};
        int y[] ={0, 24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360};
        //when
        GameMap gameMap= new GameMap();
        MapDrawer mapDrawer = new MapDrawer(gameMap);
        mapDrawer.drawMaze(gMock);
        //then

        Mockito.verify(gMock).fillOval(x[0] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[0] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[0] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[1] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[1] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[2] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[2] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[6] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[3] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[3] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[4] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[4] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[5] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[5] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[6] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[6] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[7] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[7] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[8] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[8] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[9] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[9] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[10] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[10] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[11] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[11] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[12] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[12] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[13] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[13] + 10, 6,6);

        Mockito.verify(gMock).fillOval(x[0] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[1] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[2] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[3] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[4] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[5] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[6] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[7] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[8] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[9] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[10] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[11] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[12] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[13] + 10, y[14] + 10, 6,6);
        Mockito.verify(gMock).fillOval(x[14] + 10, y[14] + 10, 6,6);
    }
}
