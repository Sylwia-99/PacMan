package main;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapDrawer extends JPanel implements ActionListener {
    //view
    private Dimension windowDimension = new Dimension(Configuration.WINDOW_WITH,Configuration.WINDOW_HEIGHT);
    private int SCREEN_SIZE = Configuration.SCREEN_SIZE;
    private Font smallFont = new Font("Arial", Font.BOLD, 14);
    //logic
    private GameMap map;

    public MapDrawer(GameMap map) {
        this.map = map;
        addKeyListener(new KeyboardController(map));
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawBackground(g2d);
        drawMaze(g2d);
        drawScore(g2d);
        drawLives(g2d);

        if (map.isInGame()) {
            map.playGame();
            drawPacman(g2d);
            drawGhosts(g2d);
        } else {
            showMessage(g2d);
        }
    }

    public void drawScore(Graphics2D g2D) {
        g2D.setFont(smallFont);
        g2D.setColor(Color.green);
        String s = "Score: " + map.getScore();
        g2D.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);
    }

    public void drawLives(Graphics2D g2D) {
        for (int i = 0; i < map.getLives(); i++) {
            g2D.drawImage(Configuration.heart, i * 28 + 8, SCREEN_SIZE + 1, null);
        }
    }

    public void drawGhost(Graphics2D g2d, int x, int y) {
        g2d.drawImage(Configuration.ghost, x, y, null);
    }

    public void drawGhosts(Graphics2D g2d){
        for(Ghost ghost : map.getGhosts()){
            drawGhost(g2d, ghost.getX() + 1, ghost.getY() + 1);
        }
    }

    public void drawPacman(Graphics2D g2d) {
        int req_dx = map.getReq_dx();
        int req_dy = map.getReq_dy();
        int pacman_x = map.getPacman_x();
        int pacman_y = map.getPacman_y();

        if (req_dx == -1) {
            g2d.drawImage(Configuration.left, pacman_x + 1, pacman_y + 1, null);
        } else if (req_dx == 1) {
            g2d.drawImage(Configuration.right, pacman_x + 1, pacman_y + 1, null);
        } else if (req_dy == -1) {
            g2d.drawImage(Configuration.up, pacman_x + 1, pacman_y + 1, null);
        } else {
            g2d.drawImage(Configuration.down, pacman_x + 1, pacman_y + 1, null);
        }
    }

    public void drawMaze(Graphics2D g2d) {
        short i = 0;
        int x, y;

        int BLOCK_SIZE = Configuration.BLOCK_SIZE;
        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(Color.blue);
                g2d.setStroke(new BasicStroke(5));

                if ((map.getLevelData()[i] == 0)) {
                    g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                }

                if ((map.getScreenData()[i] & 1) != 0) {
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((map.getScreenData()[i] & 2) != 0) {
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((map.getScreenData()[i] & 4) != 0) {
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((map.getScreenData()[i] & 8) != 0) {
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((map.getScreenData()[i] & 16) != 0) {
                    g2d.setColor(Color.white);
                    g2d.fillOval(x + 10, y + 10, 6, 6);
                }
                i++;
            }
        }
    }

    public void showMessage(Graphics2D g2d) {
        String start = "Press SPACE to start";
        g2d.setColor(Color.yellow);
        g2d.drawString(start, (SCREEN_SIZE)/4, 150);
    }

    public void drawBackground(Graphics2D g2D){
        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, windowDimension.width, windowDimension.height);
    }
}

