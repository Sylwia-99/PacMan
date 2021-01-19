package main;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Configuration {

    public static final short[] levelData = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    public static final int BLOCK_SIZE = 24;
    public static final int N_BLOCKS = 15;
    public static final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    public static final int WINDOW_WITH = 380;
    public static final int WINDOW_HEIGHT= 420;
    public static final int START_GHOSTS_AMOUNT= 1;
    public static final int MAX_GHOSTS = 6;
    public static final int GHOST_MAX_STRAIGHT_MOVE = 6;
    public static final int PACMAN_SPEED = 6;
    public static final int LEVEL_POINTS = 194;
    public static final int CURRENT_SPEED = 1;
    public static final int MAX_SPEED = 5;
    public static final int[] VALID_SPEEDS = {1, 2, 3, 4, 6, 8};

    public static Image down = new ImageIcon("src\\main\\images\\down.gif").getImage();
    public static Image up = new ImageIcon("src\\main\\images\\up.gif").getImage();
    public static Image left = new ImageIcon("src\\main\\images\\left.gif").getImage();
    public static Image right = new ImageIcon("src\\main\\images\\right.gif").getImage();
    public static Image ghost = new ImageIcon("src\\main\\images\\ghost.gif").getImage();
    public static Image  heart = new ImageIcon("src\\main\\images\\heart.png").getImage();
}
