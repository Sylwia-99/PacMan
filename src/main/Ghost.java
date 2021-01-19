package main;

public class Ghost {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int movedBlocks;
    private int ghostSpeed;

    public Ghost() { }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public int getMovedBlocks() {
        return movedBlocks;
    }

    public void setMovedBlocks(int movedBlocks) {
        this.movedBlocks = movedBlocks;
    }

    public int getGhostSpeed() {
        return ghostSpeed;
    }

    public void setGhostSpeed(int ghostSpeed) {
        this.ghostSpeed = ghostSpeed;
    }
}

