package src.Main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


//Creates and controls components to be drawn to the frame
public class GamePanel extends JPanel {

    private float xDelta = 0, yDelta = 0;
    private BufferedImage img;
    private BufferedImage[] idleAni = new BufferedImage[2];
    private int aniTick, aniIndex, aniSpeed = 30;
    private int xEnemy = 500, yEnemy = 500;
    public long currentTime = System.nanoTime();
    public long prevTime = System.nanoTime();
    public String direction;
    public int yEnemyDist;
    public int xEnemyDist;


    public GamePanel() {
        setPanelSize();
        addKeyListener(new src.inputs.KeyboardInputs(this));
        importImage();
        loadAnimations();
        }

        private void loadAnimations(){

            for(int i = 0; i < idleAni.length; i++)
                idleAni[i] = img.getSubimage(i*60, 0, 60, 60);
            
        }
 
        public void changexDelta(int value){
            this.xDelta += value;
        }

        public void changeyDelta(int value){
            this.yDelta += value;
        } 

    public void setPanelSize(){
        Dimension size = new Dimension(1200, 720);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void importImage(){
        InputStream is = getClass().getResourceAsStream("img.png");

        try{
            img = ImageIO.read(is);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                is.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    public void updateGame(){
        /*updateAnimationTick();
        
          setAnimation();
          updatePos();
         */
    }

    public void updateAnimationTick(){
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 15;
            aniIndex++;
            if(aniIndex >= idleAni.length){
                aniIndex = 0;
            }
        }
    }

    public void follow(){

        xEnemyDist = Math.max(xEnemy, (int)xDelta + 40) - Math.min(xEnemy, (int)xDelta);
        yEnemyDist = Math.max(yEnemy, (int)yDelta + 39) - Math.min(yEnemy, (int)yDelta);

        if(xEnemyDist > yEnemyDist){
            if(xEnemy < xDelta + 57){
            xEnemy += 2;
            }
            else if(xEnemy > xDelta + 57){
            xEnemy += -2;
            }
        }
        else if(yEnemyDist > xEnemyDist){
            if(yEnemy < yDelta + 53){
            yEnemy += 2;
            }
            else if(yEnemy > yDelta + 53){
            yEnemy += -2;
            }
        else{
            endGame();
        }
        }
    
    }

    private void endGame() {
        
    }

    public void getDirection(String dir){
        direction = dir;
    }

    public void constantRun(){
        if(direction == "RIGHT"){
            changexDelta(3);
        }
        else if(direction == "LEFT"){
            changexDelta(-3);
        }
        else if(direction == "DOWN"){
            changeyDelta(3);
        }
        else if(direction == "UP"){
            changeyDelta(-3);
        }
    }

    public void boundaryPlayer(){
        if(xDelta < -17){
            xDelta = -17;
        }
        else if(xDelta > 1103){
            xDelta = 1103;
        }
        else if(yDelta > 628){
            yDelta = 628;
        }
        else if(yDelta < -14){
            yDelta = -14;
        }
    }

    public void boundaryEnemy(){
        if(xEnemy < 0){
            xEnemy = 0;
        }
        else if(xEnemy > 1200){
            xEnemy= 1200;
        }
        else if(yEnemy > 720){
            yEnemy= 720;
        }
        else if(yEnemy < 0){
            yEnemy = 0;
        }
    }

    public void hitBarrier(){
        
    }

    
    


    //Built in method within java.awt.Graphics for 'drawing' objects on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        constantRun();
        boundaryPlayer();
        boundaryEnemy();


        updateAnimationTick();
        follow();

        g.drawImage(idleAni[aniIndex], (int)xDelta, (int)yDelta, 120, 120, null);

        g.drawRect((int)xDelta, (int) yDelta, 120, 120);

        g.drawRect((int)xDelta + 17, (int)yDelta + 14, 80,78); //Tracks boundaries of actual shroom rather than shroom image boundaries

        g.drawRect(100, 100, 20, 500);

        g.fillRect(xEnemy, yEnemy, 60, 60);
       
    }
}

