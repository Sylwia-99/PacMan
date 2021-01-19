package tests;
import main.PacMan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacManTest {

    private static int x = 1;
    private static int y = 1;
    private static int dx = 1;
    private static int dy = 1;

    @Test
    public void testGetX(){
        //given
        int expectedX = 1;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);

        //then
        assertEquals(expectedX, pacman.getX());
    }

    @Test
    public void testGetY(){
        //given
        int expectedY = 1;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);

        //then
        assertEquals(expectedY, pacman.getY());
    }

    @Test
    public void testGetDx(){
        //given
        int expectedDx = 1;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);

        //then
        assertEquals(expectedDx, pacman.getDx());
    }

    @Test
    public void testGetDy(){
        //given
        int expectedDy = 1;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);

        //then
        assertEquals(expectedDy, pacman.getDy());
    }

    @Test
    public void testSetDx(){
        //given
        int expectedDx = 5;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);
        pacman.setDx(5);

        //then
        assertEquals(expectedDx,pacman.getDx());
    }

    @Test
    public void testSetDy(){
        //given
        int expectedDy = 5;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);
        pacman.setDy(5);

        //then
        assertEquals(expectedDy,pacman.getDy());
    }

    @Test
    public void TestMove() {
        //given
        int expectedX = 7;
        int expectedY = 7;

        //when
        PacMan pacman = new PacMan(x, y, dx, dy);
        pacman.move();
        //then
        assertEquals(expectedX,pacman.getX());
        assertEquals(expectedY,pacman.getY());
    }
}
