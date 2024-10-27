package src.Main;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    




    public Game() {

        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();

    }

    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        gamePanel.updateGame();
    }

   




  

    @Override
    //Gameloop
    public void run() {

        /*The reason for the large value being divided is becuase the game fps is 
        running off of nanoseconds which are each 1/1000000000 of a second*/
        double timePerFrame = 1000000000.0/FPS_SET;
        double timePerUpdate = 1000000000.0/UPS_SET;

        long previousTime = System.nanoTime();


        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){

            long currentTime = System.nanoTime();

            

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                //update();
                updates++;
                deltaU--;
            }


            if(System.currentTimeMillis() - lastCheck >= 1000){
                gamePanel.follow();
            }

            

            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;   
                deltaF--;
            }

            
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS " + frames + " | UPS " + updates);
            frames = 0;
            updates = 0;
        }
        }

        
    }
}
