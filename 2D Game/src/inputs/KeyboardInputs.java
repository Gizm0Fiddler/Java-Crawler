package src.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class KeyboardInputs implements KeyListener{

    Timer timer = new Timer();

    private src.Main.GamePanel gamePanel;

    public KeyboardInputs(src.Main.GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){

            case KeyEvent.VK_UP:
            
                gamePanel.getDirection("UP");
                //gamePanel.changeyDelta(-5);
                break;

            case KeyEvent.VK_DOWN:

                gamePanel.getDirection("DOWN");
                //gamePanel.changeyDelta(5);
                break;

            case KeyEvent.VK_LEFT:

                gamePanel.getDirection("LEFT");
                //gamePanel.changexDelta(-5);
                break;

            case KeyEvent.VK_RIGHT:

                gamePanel.getDirection("RIGHT");
                //gamePanel.changexDelta(5);
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){

            case KeyEvent.VK_UP:
            
                gamePanel.getDirection("UP");
                //gamePanel.changeyDelta(-5);
                break;

            case KeyEvent.VK_DOWN:
                gamePanel.getDirection("DOWN");
                //gamePanel.changeyDelta(5);
                break;

            case KeyEvent.VK_LEFT:
                gamePanel.getDirection("LEFT");
                //gamePanel.changexDelta(-5);
                break;

            case KeyEvent.VK_RIGHT:
                gamePanel.getDirection("RIGHT");
                //gamePanel.changexDelta(5);
                break;
        }
    }
         
}


