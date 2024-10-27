package src.Main;

import javax.swing.JFrame;

//Controls JFrame contents
public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel){


        //Creates a usable JFrame object
        jFrame = new JFrame();

        
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        //Sets the frame's position to be in the center of the screen
        jFrame.setResizable(false);
        //Sets the game window size to the preffered size of its components(gamePanel)
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        //Makes the frame visible on the screen
        jFrame.setVisible(true);
    }
    
}
