package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController extends KeyAdapter{

    private GameMap map;

    public KeyboardController(GameMap map) {
        this.map = map;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        boolean isInGame = map.isInGame();

        if (isInGame) {
            if (key == KeyEvent.VK_LEFT) {
                map.setReq_dx(-1);
                map.setReq_dy(0);
            } else if (key == KeyEvent.VK_RIGHT) {
                map.setReq_dx(1);
                map.setReq_dy(0);
            } else if (key == KeyEvent.VK_UP) {
                map.setReq_dx(0);
                map.setReq_dy(-1);;
            } else if (key == KeyEvent.VK_DOWN) {
                map.setReq_dx(0);
                map.setReq_dy(1);
            } else if (key == KeyEvent.VK_ESCAPE) {
                map.setInGame(false);
            }
        } else {
            if (key == KeyEvent.VK_SPACE) {
                map.setInGame(true);
                map.initGame();
            }
        }
    }
}

