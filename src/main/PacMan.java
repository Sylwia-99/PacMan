package main;

public class PacMan {
    private int x;
    private int y;
    private int dx;
    private int dy;

    public PacMan(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void move() {
        x = x + Configuration.PACMAN_SPEED * dx;
        y = y + Configuration.PACMAN_SPEED * dy;
    }
}

