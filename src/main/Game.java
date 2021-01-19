package main;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame {

    private MapDrawer mapDrawer;
    private static Timer timer;

    public Game(){
        GameMap map = new GameMap();
        mapDrawer = new MapDrawer(map);
        add(mapDrawer);
    }

    public MapDrawer getMapDrawer() {
        return mapDrawer;
    }

    public static void main(String[] args){
        Game pac = new Game();
        pac.setVisible(true);
        pac.setTitle("PacMan");
        pac.setSize(Configuration.WINDOW_WITH, Configuration.WINDOW_HEIGHT);
        pac.setResizable(false);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setLocationRelativeTo(null);

        timer = new Timer(40,pac.getMapDrawer());
        //start game
        timer.start();
    }
}
