package main;
import java.util.ArrayList;

public class GameMap {

    private boolean inGame = false;
    private boolean dying = false;
    private int lives, score, eatenPoints;
    private PacMan pacman;
    private ArrayList<Ghost> ghosts = new ArrayList<>();
    private int BLOCK_SIZE = Configuration.BLOCK_SIZE;
    private int N_BLOCKS = Configuration.N_BLOCKS;
    private int N_GHOSTS = Configuration.START_GHOSTS_AMOUNT;
    private int[] validSpeeds = Configuration.VALID_SPEEDS;
    private int currentSpeed = Configuration.CURRENT_SPEED;
    private short[] levelData = Configuration.levelData;
    private short[] screenData;
    private int req_dx, req_dy;

    public GameMap() {
        initVariables();
        initGame();
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isDying() {
        return dying;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }


    public int getReq_dx() {
        return req_dx;
    }

    public void setReq_dx(int req_dx) {
        this.req_dx = req_dx;
    }

    public int getReq_dy() {
        return req_dy;
    }

    public void setReq_dy(int req_dy) {
        this.req_dy = req_dy;
    }

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public int getPacman_x() {
        return pacman.getX();
    }

    public int getPacman_y() {
        return pacman.getY();
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getN_GHOSTS() {
        return N_GHOSTS;
    }
    public short[] getLevelData() {
        return levelData;
    }

    public short[] getScreenData() {
        return screenData;
    }

    public void initVariables() {
        screenData = new short[N_BLOCKS * N_BLOCKS];
    }

    public void playGame() {
        if (isDying()){
            death();
        } else {
            movePacMan();
            moveGhosts();
            checkMaze();
        }
    }

    public void checkMaze() {
        if (eatenPoints > 0 && eatenPoints >= Configuration.LEVEL_POINTS) {
            score += 50;
            if (N_GHOSTS < Configuration.MAX_GHOSTS) {
                N_GHOSTS++;
            }
            if (currentSpeed < Configuration.MAX_SPEED) {
                currentSpeed++;
            }
            initLevel();
        }
    }

    public void death() {
        lives--;
        if (lives == 0) {
            setInGame(false);
        }
        continueLevel();
    }

    public void moveGhosts() {
        int pos;
        for (Ghost g : ghosts) {
            if (g.getX() % BLOCK_SIZE == 0 && g.getY() % BLOCK_SIZE == 0) {
                pos = g.getX() / BLOCK_SIZE + N_BLOCKS * (int) (g.getY() / BLOCK_SIZE);

                int ch = screenData[pos];
                int dx = g.getDx();
                int dy = g.getDy();
                g.setMovedBlocks(g.getMovedBlocks() + 1 );

                int GHOST_MAX_STRAIGHT_MOVE = Configuration.GHOST_MAX_STRAIGHT_MOVE;
                if( (dx < 0 && (ch & 1) != 0) ){
                    g.setMovedBlocks(g.getMovedBlocks() + GHOST_MAX_STRAIGHT_MOVE);
                }
                else if(dx > 0 && (ch & 4) != 0){
                    g.setMovedBlocks(g.getMovedBlocks() + GHOST_MAX_STRAIGHT_MOVE);
                }
                else if(dy < 0 && (ch & 2) != 0){
                    g.setMovedBlocks(g.getMovedBlocks() + GHOST_MAX_STRAIGHT_MOVE);
                }
                else if(dy > 0 && (ch & 8) != 0 ){
                    g.setMovedBlocks(g.getMovedBlocks() + GHOST_MAX_STRAIGHT_MOVE);
                }

                if(g.getMovedBlocks() >= GHOST_MAX_STRAIGHT_MOVE){
                    g.setMovedBlocks((int)(Math.random() * GHOST_MAX_STRAIGHT_MOVE));

                    int randDir = (int)(Math.random() * 4);
                    switch(randDir){
                        case 0:
                            g.setDx(-1);
                            g.setDy(0);
                            if((ch & 1) == 0) break;
                        case 1:
                            g.setDx(0);
                            g.setDy(-1);
                            if((ch & 2) == 0) break;
                        case 2:
                            g.setDx(1);
                            g.setDy(0);
                            if((ch & 4) == 0) break;
                        case 3:
                            g.setDx(0);
                            g.setDy(1);
                            if((ch & 8) == 0) break;
                        case 4: //randDir nigdy nie bedzie >= 4 ale musi byc z powodu braku break
                            g.setDx(-1);
                            g.setDy(0);
                            if((ch & 1) == 0) break;
                        case 5:
                            g.setDx(0);
                            g.setDy(-1);
                            if((ch & 2) == 0) break;
                        default:
                            g.setDx(1);
                            g.setDy(0);
                    }
                }
            }
            g.setX(g.getX() + (g.getDx() * g.getGhostSpeed()));
            g.setY(g.getY() + (g.getDy() * g.getGhostSpeed()));

            if (pacman.getX() > (g.getX() - BLOCK_SIZE/2) && pacman.getX() < (g.getX() + BLOCK_SIZE/2)
                    && pacman.getY() > (g.getY() - BLOCK_SIZE/2) && pacman.getY() < (g.getY() + BLOCK_SIZE/2)
                    && isInGame()) {
                setDying(true);
            }
        }
    }

    public void movePacMan() {
        int pos;
        short ch;

        if (pacman.getX() % BLOCK_SIZE == 0 && pacman.getY() % BLOCK_SIZE == 0) {
            pos = pacman.getX() / BLOCK_SIZE + N_BLOCKS * (int) (pacman.getY() / BLOCK_SIZE);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
                eatenPoints++;
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacman.setDx(req_dx);
                    pacman.setDy(req_dy);
                }
            }
            if ((pacman.getDx() == -1 && pacman.getDy() == 0 && (ch & 1) != 0)
                    || (pacman.getDx() == 1 && pacman.getDy() == 0 && (ch & 4) != 0)
                    || (pacman.getDx() == 0 && pacman.getDy() == -1 && (ch & 2) != 0)
                    || (pacman.getDx() == 0 && pacman.getDy() == 1 && (ch & 8) != 0)) {
                pacman.setDx(0);
                pacman.setDy(0);
            }
        }
        pacman.move();
    }

    public void initGame() {
        lives = 3;
        score = 0;
        initLevel();
        currentSpeed = 1;
        N_GHOSTS = Configuration.START_GHOSTS_AMOUNT;
    }

    public void initLevel() {
        System.arraycopy(levelData, 0, screenData, 0, N_BLOCKS * N_BLOCKS);
        eatenPoints = 0;
        ghosts = new ArrayList<>();
        addGhosts(ghosts);
        continueLevel();
    }

    public void addGhosts(ArrayList<Ghost> ghosts){
        for(int i=0;i<N_GHOSTS;i++){
            ghosts.add(new Ghost());
        }
    }

    public void continueLevel() {
        int dx = 1;
        int random;

        for (Ghost g : ghosts) {
            g.setY(BLOCK_SIZE);
            g.setX(BLOCK_SIZE);
            g.setDy(0);
            g.setDx(dx);
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            g.setGhostSpeed(validSpeeds[random]);
        }

        pacman = new PacMan(14 * BLOCK_SIZE,14 * BLOCK_SIZE, 0 , 0);
        req_dx = 0;
        req_dy = 0;
        setDying(false);
    }
}
